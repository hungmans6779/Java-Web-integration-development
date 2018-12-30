package com.helloweenvsfei.servlet;

import java.io.IOException;


import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import java.util.Locale;
import com.helloweenvsfei.util.IpUtil;



public class RequestServlet extends HttpServlet {

	
	/**
	 * Constructor of the object.
	 */
	public RequestServlet() {
		super();
	}

	
	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
	
	String version=null;
	public void init(ServletConfig config) throws ServletException{
	  super.init(config);
	  version=config.getInitParameter("version");
	  this.log("version = "+version);
	}

	
	
	// 傳回用戶端瀏覽器受的檔案類型
	private String getAccept(String accept){
		
	  StringBuffer buffer=new StringBuffer();
	  
	  if(accept.contains("text/html")){ buffer.append("HTML 檔案, "); } 
	  if(accept.contains("image/gif")){ buffer.append("GIF 檔案, "); } 
	  if(accept.contains("image/X-XBITMAP")){ buffer.append("BMP 檔案, "); } 
	  if(accept.contains("image/jpeg")){ buffer.append("JPG 檔案, "); } 
	  if(accept.contains("application/vnd.ms-excel")){ buffer.append("Excel 檔案, "); } 
	  if(accept.contains("application/vnd.ms-powerpoint")){ buffer.append("PPT 檔案, "); } 
	  if(accept.contains("application/vnd.ms-msword")){ buffer.append("Word 文件 , "); } 
	  
	  return buffer.toString().replace(", $","");
	}
	
	
	
	

	
	// 傳回IP位址對應的實體位置
	private String getAddress(String ip){
	  return IpUtil.getIpAddress(ip);
	}
	
	


	// 傳回用戶端作業系統
	private String getOS(String userAgent){
	  
	  if(userAgent.indexOf("Windows NT 5.1") >0 ){ return "Windows XP"; }
	  if(userAgent.indexOf("Windows 98") >0 ){ return "Windows 98"; }
	  if(userAgent.indexOf("Windows NT 5.0") >0 ){ return "Windows 2000"; }
	  if(userAgent.indexOf("Windows NT 6.1") >0 ){ return "Windows 7"; }
	  if(userAgent.indexOf("Linux") >0 ){ return "Linux"; }
	  if(userAgent.indexOf("Unix") >0 ){ return "Unix"; }
	  
	  return "未知";	
	}
	
	
	// 傳回用戶端瀏覽器資訊
	private String getNavigator(String userAgent){
	  
	  if(userAgent.indexOf("TencentTraveler") >0 ){ return "騰訊 瀏覽器"; }
	  if(userAgent.indexOf("Maxthon") >0 ){ return "Maxthon 瀏覽器"; }
	  if(userAgent.indexOf("MyIE2") >0 ){ return "MyIE2 瀏覽器"; }
	  if(userAgent.indexOf("Firefox") >0 ){ return "Firefox 瀏覽器"; }
	  if(userAgent.indexOf("MSIE") >0 ){ return "IE 瀏覽器"; }
	  
	  return "未知瀏覽器";	
	}
	
	
	
	// 傳回用戶端語言環境名稱
	private String getLocale(Locale locale){
		
	  if(Locale.SIMPLIFIED_CHINESE.equals(locale)){  return "簡體中文"; }	
      if(Locale.TRADITIONAL_CHINESE.equals(locale)){ return "繁體中文"; }
      if(Locale.ENGLISH.equals(locale)){ return "英文";  }
      if(Locale.JAPAN.equals(locale)){   return "日文"; }
      
	  return "未知語言環境";
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
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");	
		
		response.setContentType("text/html");
		

		
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("     request.getAuthType() = "+request.getAuthType()+"<br>");
		out.print("     request.getLocalAddr() = "+request.getLocalAddr()+",位於"+getAddress(request.getLocalAddr())+"<br>");
		out.print("     request.getLocalName() = "+request.getLocalName()+"<br>");
		out.print("     request.getLocalPort() = "+request.getLocalPort()+"<br><br>");
		
		out.print("     request.getLocale() = "+request.getLocale()+"<br>");
		out.print("     request.getContextPath() = "+request.getContextPath()+"<br>");
		out.print("     request.getMethod() = "+request.getMethod()+"<br>");
		out.print("     request.getPathInfo() = "+request.getPathInfo()+"<br>");
		out.print("     request.getPathTranslated() = "+request.getPathTranslated()+"<br>");
		out.print("     request.getProtocol()  = "+request.getProtocol()+"<br>");
		out.print("     request.getQueryString() = "+request.getQueryString()+"<br><br>");
		
		out.print("     request.getRemoteAddr() = "+request.getRemoteAddr()+",位於"+getAddress(request.getRemoteAddr())+"<br>");
		out.print("     request.getRemotePort() = "+request.getRemotePort()+"<br>");
		out.print("     request.getRemoteUser() = "+request.getRemoteUser()+"<br>");
		out.print("     request.getRequestedSessionId() = "+request.getRequestedSessionId()+"<br><br>");
		
		
		out.print("     request.getRequestURI() = "+request.getRequestURI()+"<br>");
		out.print("     request.getRequestURL() = "+request.getRequestURL()+"<br><br>");
		
		out.print("     request.getScheme() = "+request.getScheme()+"<br>");
		out.print("     request.getServerName() = "+request.getServerName()+"<br>");
		out.print("     request.getServerPort() = "+request.getServerPort()+"<br>");
		out.print("     request.getServletPath() = "+request.getServletPath()+"<br>");
		out.print("     request.getUserPrincipal() = "+request.getUserPrincipal()+"<br><br>");
		
		String accept =request.getHeader("accept");
		out.print("     request.getHeader('accept') = "+accept+"<br>");
		out.print("     您的瀏覽器接受 "+getAccept(accept)+"<br><br>");
		
		out.print("     request.getHeader('referer')= "+request.getHeader("referer")+"<br><br>");
		
		
		String userAgent=request.getHeader("user-agent");
		out.print("     request.getHeader('user-agent')  = "+userAgent+"<br>");
		out.print("     使用的作業系統 ："+getOS(userAgent)+"<br>");
		out.print("     使用的瀏覽器 ："+getNavigator(userAgent)+"<br>");
		out.print("     使用的語系 ："+getLocale(request.getLocale())+"<br>");
		out.print("     this.getServletContext().getServerInfo() = "+this.getServletContext().getServerInfo()+"<br><br>");

		
		out.println("   Servlet 類別名："+this.getClass().getName()+"<br>");
		out.println("   本應用程式在硬碟的根目錄為："+this.getServletContext().getRealPath("")+"<br>");
		
		
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
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
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
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
