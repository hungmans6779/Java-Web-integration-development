package com.helloweenvsfei.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LifeCycleServlet extends HttpServlet {

	private static double startPoint=0;
	
	/**
	 * Constructor of the object.
	 */
	public LifeCycleServlet() {
		super();
	}

	
	
	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
	  this.log("執行init()方法...");
	  ServletConfig conf=this.getServletConfig();
	  startPoint=Double.parseDouble(conf.getInitParameter("startPoint"));
	  this.log("startPoint = "+startPoint);
	}
	
	
	


	
	protected void service(HttpServletRequest arg0,HttpServletResponse arg1) throws ServletException,IOException{
		this.log("執行service()方法...");
		super.service(arg0, arg1);
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
		
		this.log("執行doGet()方法...");

		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<link rel='stylesheet' type='text/css' href='../css/style.css'>");
		out.println("<HTML><HEAD><TITLE>個人所得稅計算</TITLE></HEAD>");

		out.println("<div align='center'><br/><fieldset style=width:90%><legend>個稅計算器</legend><br/>");
		out.println("<form method='post' action='LifeCycleServlet'>");
		
		out.println("<div style='line'>");
		out.println("	<div class='leftDiv'>您的薪水為</div><div align='left' class='rightDiv'><input type='text' name='income'> 單位：元</div>");
		out.println("</div><br/>");
		
		out.println("<div style='line'>");
		out.println("	<div class='leftDiv'></div><div align='left' class='rightDiv'><input type='submit' value='  計算個稅  ' class=button></div>");
		out.println("</div>");
		
		out.println("</form>");
		
		out.println("<BODY>");
		out.println("</BODY>");
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

		this.log("執行doPost()方法...");
		
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML><HEAD><TITLE>個人所得稅計算</TITLE></HEAD>");
		out.println("<link rel='stylesheet' type='text/css' href='../css/style.css'>");
		out.println("<BODY>");
		
		out.println("<div align='center'><br/><fieldset style=width:90%><legend>個稅計算器</legend><br/>");
		
		try{
			// 從參數中獲得的薪水數目
			double income = new Double(request.getParameter("income"));
			// 應納稅部分
			double charge = income - startPoint;
			// 繳稅
			double tax = 0;

			if (charge<=0) {tax=0;}
			if (charge>0&&charge<=500) {tax=charge*0.05;}
			if (charge>500&&charge<=2000) {tax=charge*0.1-25;}
			if (charge>2000&&charge<=5000) {tax=charge*0.15-125;}
			if (charge>5000&&charge<=20000) {tax=charge*0.2-375;}
			if (charge>20000&&charge<=40000) {tax=charge*0.25-1375;}
			if (charge>40000&&charge<=60000) {tax=charge*0.30-3375;}
			if (charge>60000&&charge<=80000) {tax=charge*0.35-6375;}
			if (charge>80000&&charge<=100000) {tax=charge*0.4-10375;}
			if (charge>100000) {tax=charge*0.45-15375;}

			out.println("<div style='line'>");
			out.println("	<div class='leftDiv'>您的薪水為</div><div class='rightDiv'>" + income + " 元</div>");
			out.println("</div>");
			
			out.println("<div style='line'>");
			out.println("	<div class='leftDiv'>您應納稅</div><div class='rightDiv'>" + tax + " 元</div>");
			out.println("</div><br/>");

			out.println("<input type='button' onclick='history.go(-1);' value='納稅光榮 逃稅可恥 傳回'  class=button>");
			
		}catch(Exception e){
			out.println("請輸入數值類型資料。<input type='button' onclick='history.go(-1);' value='傳回'  class=button>");
		}
		out.println("</BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	
	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		this.log("執行destroy()方法...");
		startPoint=0;
		super.destroy(); // Just puts "destroy" string in log
		
		// Put your code here
	}
	
	
	
}
