package com.helloweenvsfei.servlet.upload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


public class ProgressUploadServlet extends HttpServlet {

	private static final long serialVersionUID = -4935921396709035718L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 上傳狀態
		UploadStatus status = new UploadStatus();

		// 監聽器
		UploadListener listener = new UploadListener(status);

		// 把 UploadStatus 放到 session 裡
		request.getSession(true).setAttribute("uploadStatus", status);

		// Apache 上傳工具
		ServletFileUpload upload = new ServletFileUpload(
				new DiskFileItemFactory());

		// 設定 listener
		upload.setProgressListener(listener);

		try {
			List itemList = upload.parseRequest(request);

			for (Iterator it = itemList.iterator(); it.hasNext();) {
				FileItem item = (FileItem) it.next();
				if (item.isFormField()) {
					System.out.println("FormField: " + item.getFieldName()
							+ " = " + item.getString());
				} else {
					System.out.println("File: " + item.getName());

					// 統一 Linux 與 windows 的路徑分隔符
					String fileName = item.getName().replace("/", "\\");
					fileName = fileName.substring(fileName.lastIndexOf("\\"));

					File saved = new File("C:\\upload_test", fileName);
					saved.getParentFile().mkdirs();

					InputStream ins = item.getInputStream();
					OutputStream ous = new FileOutputStream(saved);

					byte[] tmp = new byte[1024];
					int len = -1;

					while ((len = ins.read(tmp)) != -1) {
						ous.write(tmp, 0, len);
					}

					ous.close();
					ins.close();

					response.getWriter().println("已儲存檔案：" + saved);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().println("上傳發生錯誤：" + e.getMessage());
		}
	}

	
	
	
	
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setHeader("Cache-Control", "no-store");
		response.setHeader("Pragrma", "no-cache");
		response.setDateHeader("Expires", 0);

		UploadStatus status = (UploadStatus) request.getSession(true)
				.getAttribute("uploadStatus");

		if (status == null) {
			response.getWriter().println("沒有上傳資訊");
			return;
		}

		long startTime = status.getStartTime();
		long currentTime = System.currentTimeMillis();

		// 已傳輸的時間 單位：s
		long time = (currentTime - startTime) / 1000 + 1;

		// 傳輸速度 單位：byte/s
		double velocity = ((double) status.getBytesRead()) / (double) time;

		// 估計總時間 單位：s
		double totalTime = status.getContentLength() / velocity;

		// 估計剩餘時間 單位：s
		double timeLeft = totalTime - time;

		// 已完成的百分比
		int percent = (int) (100 * (double) status.getBytesRead() / (double) status
				.getContentLength());

		// 已完成數 單位：M
		double length = ((double) status.getBytesRead()) / 1024 / 1024;

		// 總長度 單位：M
		double totalLength = ((double) status.getContentLength()) / 1024 / 1024;

		// 格式：百分比||已完成數(M)||檔案總長度(M)||傳輸速率(K)||已用時間(s)||估計總時間(s)||估計剩餘時間(s)||正在上傳第幾個檔案
		String value = percent + "||" + length + "||" + totalLength + "||"
				+ velocity + "||" + time + "||" + totalTime + "||" + timeLeft
				+ "||" + status.getItems();

		response.getWriter().println(value);
	}
	
	

}
