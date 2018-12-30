package com.helloweenvsfei.upload;

import java.io.File;


import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
 
import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;
 
public class UploadRequestWrapper extends HttpServletRequestWrapper {

	private static final String MULTIPART_HEADER = "Content-type";

	// 是否是上傳檔案
	private boolean multipart;

	// map，儲存所有的域
	private Map<String, Object> params = new HashMap<String, Object>();

	@SuppressWarnings("all")
	public UploadRequestWrapper(HttpServletRequest request) {

		super(request);

		// 判斷是否為上傳檔案
		multipart = request.getHeader(MULTIPART_HEADER) != null
				&& request.getHeader(MULTIPART_HEADER).startsWith(
						"multipart/form-data");

		if (multipart) {

			try {
				// 使用apache的工具解析
				DiskFileUpload upload = new DiskFileUpload();
				upload.setHeaderEncoding("utf8");

				// 解析，獲得所有的文字域與檔案域
				List<FileItem> fileItems = upload.parseRequest(request);

				for (Iterator<FileItem> it = fileItems.iterator(); it.hasNext();) {

					// 檢查
					FileItem item = it.next();
					if (item.isFormField()) {

						// 如果是文字域，直接放到map裡
						params.put(item.getFieldName(), item.getString("utf8"));

					} else {

						// 否則，為檔案，先獲得檔案名稱
						String filename = item.getName().replace("\\", "/");
						filename = filename
								.substring(filename.lastIndexOf("/") + 1);

						// 儲存到系統臨時檔案夾中
						File file = new File(System
								.getProperty("java.io.tmpdir"), filename);

						// 儲存檔案內容
						OutputStream ous = new FileOutputStream(file);
						ous.write(item.get());
						ous.close();

						// 放到map中
						params.put(item.getFieldName(), file);
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Object getAttribute(String name) {

		// 如果為上傳檔案，則從map中取值
		if (multipart && params.containsKey(name)) {
			return params.get(name);
		}
		return super.getAttribute(name);
	}

	@Override
	public String getParameter(String name) {

		// 如果為上傳檔案，則從map中取值
		if (multipart && params.containsKey(name)) {
			return params.get(name).toString();
		}
		return super.getParameter(name);
	}

	public static void main(String[] args) {

		System.out.println(System.getProperties().toString().replace(", ",
				"\r\n"));

	}

}
