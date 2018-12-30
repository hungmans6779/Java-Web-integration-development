package com.helloweenvsfei.servlet;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;

public class UploadServlet extends HttpServlet {

	
	
	/**
	 * Constructor of the object.
	 */
	public UploadServlet() {
		super();
	}

	
	
	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	
	
	
	
	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.getWriter().println("請以 POST 方式上傳檔案");
	}

	
	
	
	
	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		File file1 = null, file2 = null;
		String description1 = null, description2 = null;

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <link rel='stylesheet' type='text/css' href='../css/style.css'>");
		out.println("  <BODY>");
		
		out.println("<div align=center><br/>");
		out.println("<fieldset style='width:90%'><legend>上傳檔案</legend><br/>");
		
		out.println("		<div class='line'>");
		out.println("			<div align='left' class='leftDiv'>上傳日誌：</div>");
		out.println("			<div align='left' class='rightDiv'>");
		
		// 使用 DiskFileUpload 對像解析 request
		DiskFileUpload diskFileUpload = new DiskFileUpload();
		try {
			// 將 解析的結果 放置在 List 中
			List<FileItem> list = diskFileUpload.parseRequest(request);
			out.println("檢查所有的 FileItem ... <br/>");
			// 檢查 list 中所有的 FileItem
			for(FileItem fileItem : list){
				
				if(fileItem.isFormField()){
					// 如果是 文字域
					if("description1".equals(fileItem.getFieldName())){
						// 如果該 FileItem 名稱為 description1
						out.println("檢查到 description1 ... <br/>");
						description1 = new String(fileItem.getString().getBytes(), "UTF-8");
					}
					
					if("description2".equals(fileItem.getFieldName())){
						// 如果該 FileItem 名稱為 description2
						out.println("檢查到 description2 ... <br/>");
						description2 = new String(fileItem.getString().getBytes(), "UTF-8");
					}
					
				}else{
					
					// 否則，為檔案域
					if("file1".equals(fileItem.getFieldName())){
						// 客戶端檔案路徑建構的 File 對像
						File remoteFile = new File(new String(fileItem.getName().getBytes(), "UTF-8"));
						out.println("檢查到 file1 ... <br/>");
						out.println("客戶端檔案位置: " + remoteFile.getAbsolutePath() + "<br/>");
						// 服務器端檔案，放在 upload 檔案夾下
						file1 = new File(this.getServletContext().getRealPath("attachment"), remoteFile.getName());
						file1.getParentFile().mkdirs();
						file1.createNewFile();
						
						// 寫檔案，將 FileItem 的檔案內容寫到檔案中
						InputStream ins = fileItem.getInputStream();
						OutputStream ous = new FileOutputStream(file1);
						
						try{
							byte[] buffer = new byte[1024]; 
							int len = 0;
							while((len=ins.read(buffer)) > -1){
								ous.write(buffer, 0, len);
							}	
							out.println("已儲存檔案" + file1.getAbsolutePath() + "<br/>");
						}finally{
							ous.close();
							ins.close();
						}
					}
					
					if("file2".equals(fileItem.getFieldName())){
						// 客戶端檔案路徑建構的 File 對像
						File remoteFile = new File(new String(fileItem.getName().getBytes(), "UTF-8"));
						out.println("檢查到 file2 ... <br/>");
						out.println("客戶端檔案位置: " + remoteFile.getAbsolutePath() + "<br/>");
						// 服務器端檔案，放在 upload 檔案夾下
						file2 = new File(this.getServletContext().getRealPath("attachment"), remoteFile.getName());
						file2.getParentFile().mkdirs();
						file2.createNewFile();
						
						// 寫檔案，將 FileItem 的檔案內容寫到檔案中
						InputStream ins = fileItem.getInputStream();
						OutputStream ous = new FileOutputStream(file2);
						
						try{
							byte[] buffer = new byte[1024]; 
							int len = 0;
							while((len=ins.read(buffer)) > -1){
								ous.write(buffer, 0, len);
							}	
							out.println("已儲存檔案" + file2.getAbsolutePath() + "<br/>");
						}finally{
							ous.close();
							ins.close();
						}
					}
					
				}
				
			}
			out.println("Request 解析完畢");
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		out.println("			</div>");
		out.println("		</div>");
		
		if(file1 != null){
		out.println("		<div class='line'>");
		out.println("			<div align='left' class='leftDiv'>file1：</div>");
		out.println("			<div align='left' class='rightDiv'>");
		out.println("				<a href='" + request.getContextPath() + "/attachment/" + file1.getName() + "' target=_blank>" + file1.getName() +  "</a>"	);
		out.println("			</div>");
		out.println("		</div>");
		}

		if(file2 != null){
		out.println("		<div class='line'>");
		out.println("			<div align='left' class='leftDiv'>file2：</div>");
		out.println("			<div align='left' class='rightDiv'>");
		out.println("				<a href='" + request.getContextPath() + "/attachment/" + URLEncoder.encode(file2.getName(), "UTF-8") + "' target=_blank>" + file2.getName() +  "</a>"	);
		out.println("			</div>");
		out.println("		</div>");
		}
		

		out.println("		<div class='line'>");
		out.println("			<div align='left' class='leftDiv'>description1：</div>");
		out.println("			<div align='left' class='rightDiv'>");
		out.println(description1);
		out.println("			</div>");
		out.println("		</div>");

		out.println("		<div class='line'>");
		out.println("			<div align='left' class='leftDiv'>description2：</div>");
		out.println("			<div align='left' class='rightDiv'>");
		out.println(description2);
		out.println("			</div>");
		out.println("		</div>");
		
		out.println("</fieldset></div>");
		
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
		
	}

	
	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

	
	
}
