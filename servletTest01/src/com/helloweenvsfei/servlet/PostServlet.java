package com.helloweenvsfei.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PostServlet extends HttpServlet {

	
	
	/**
	 * Constructor of the object.
	 */
	public PostServlet() {
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
       request.setCharacterEncoding("UTF-8");
       response.getWriter().println("請使用 POST 方式傳送資料");

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

		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		

		// 從 文字框 text 中取姓名
		String name = request.getParameter("name");
		// 從 密碼域 password 中取密碼
		String password = request.getParameter("password");
		// 從 單選框 checkbox 中取性別
		String sex = request.getParameter("sex");

		int age = 0;
		try {
			// 取 年齡. 需要把 字串 轉換為 int.
			// 如果格式不對會拋出 NumberFormattingException
			age = Integer.parseInt(request.getParameter("age"));
		} catch (Exception e) {
		}

		Date birthday = null;
		try {
			// 取 生日. 需要把 字串 轉化為 Date.
			// 如果格式不對會拋出 ParseException
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			birthday = format.parse(request.getParameter("birthday"));
		} catch (Exception e) {
		}

		// 從 多選框 checkbox 中取多個值
		String[] interesting = request.getParameterValues("interesting");
		// 從 下拉框 select 中取值
		String area = request.getParameter("area");
		// 從 文字域 textarea 中取值
		String description = request.getParameter("description");

		// 取 傳送按鈕 的鍵值
		String btn = request.getParameter("btn");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out
				.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("<HEAD><TITLE>感謝您傳送資訊</TITLE>");
		out.println("<style>");
		out.println("body, div, td, input {font-size:12px; margin:0px; }");
		out.println(".line {margin:2px; }");
		out
				.println(".leftDiv {width:110px; float:left; height:22px; line-height:22px; font-weight:bold; }");
		out.println(".rightDiv {height:22px; line-height:22px; }");
		out.println(".button {");
		out.println("	color:#fff;");
		out.println("	font-weight:bold;");
		out.println("	font-size: 11px; ");
		out.println("	text-align:center;");
		out.println("	padding:.17em 0 .2em .17em;");
		out.println("	border-style:solid;");
		out.println("	border-width:1px;");
		out.println("	border-color:#9cf #159 #159 #9cf;");
		out
				.println("	background:#69c url(/servlet/images/bg-btn-blue.gif) repeat-x;");
		out.println("</style>");
		out.println("</HEAD>");

		out.println("<div align=\"center\"><br/>");
		out.println("<fieldset style='width:90%'><legend>填寫使用者資訊</legend><br/>");

		out.println("		<div class='line'>");
		out.println("			<div align='left' class='leftDiv'>您的姓名：</div>");
		out.println("			<div align='left' class='rightDiv'>" + name + "</div>");
		out.println("		</div>");

		out.println("		<div class='line'>");
		out.println("			<div align='left' class='leftDiv'>您的密碼：</div>");
		out.println("			<div align='left' class='rightDiv'>" + password
				+ "</div>");
		out.println("		</div>");

		out.println("		<div class='line'>");
		out.println("			<div align='left' class='leftDiv'>您的性別：</div>");
		out.println("			<div align='left' class='rightDiv'>" + sex + "</div>");
		out.println("		</div>");

		out.println("		<div class='line'>");
		out.println("			<div align='left' class='leftDiv'>您的年齡：</div>");
		out.println("			<div align='left' class='rightDiv'>" + age + "</div>");
		out.println("		</div>");

		out.println("		<div class='line'>");
		out.println("			<div align='left' class='leftDiv'>您的生日：</div>");
		out.println("			<div align='left' class='rightDiv'>");
		out.println(new SimpleDateFormat("yyyy年MM月dd日").format(birthday));
		out.println("			</div>");
		out.println("		</div>");

		out.println("		<div class='line'>");
		out.println("			<div align='left' class='leftDiv'>您的興趣：</div>");
		out.println("			<div align='left' class='rightDiv'>");

		if (interesting != null)
			for (String str : interesting) {
				out.println(str + ", ");
			}

		out.println("			</div>");
		out.println("		</div>");

		out.println("		<div class='line'>");
		out.println("			<div align='left' class='leftDiv'>自我描述：</div>");
		out.println("			<div align='left' class='rightDiv'>" + description
				+ "</div>");
		out.println("		</div>");

		out.println("		<div class='line'>");
		out.println("			<div align='left' class='leftDiv'>按鈕鍵值：</div>");
		out.println("			<div align='left' class='rightDiv'>" + btn + "</div>");
		out.println("		</div>");

		out.println("		<div class='line'>");
		out.println("			<div align='left' class='leftDiv'></div>");
		out.println("			<div align='left' class='rightDiv'>");
		out
				.println("				<br/><input type='button' name='btn' value='傳回上一頁' onclick='history.go(-1); ' class='button'><br/>");
		out.println("			</div>");
		out.println("		</div>");

		out.println("<BODY>");
		out.println("</BODY>");
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
