package com.helloweenvsfei.servlet;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class RedirectServlet extends HttpServlet {
	
	
    Map<String, Integer> map = new HashMap<String, Integer>();
	
	@Override
	public void init() throws ServletException {
		map.put("/download/setup.exe",0);
		map.put("/download/application.zip",0);
		map.put("/download/01.mp3",0);
	}

	
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String filename = request.getParameter("filename");
		
		if(filename != null){
			// 更Ω计
			int hit = map.get(filename);
			// 更Ω计 + 1 纗
			map.put(filename, ++ hit);
			
			this.log("request.getContextPath() = "+request.getContextPath());
			this.log("filename = "+filename);
			// 穝旧郎
			response.sendRedirect(request.getContextPath() + filename);
		}else{
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
			out.println("<HTML>");
			out.println("  <HEAD><TITLE>郎更</TITLE></HEAD>");
			out.println("	<link rel='stylesheet' type='text/css' href='../css/style.css'>");
			out.println("  <BODY><br/>");

			out.println("<fieldset align=center style=width:90%><legend>郎更</legend>");
			out.println("<table width=100%>");
			out.println("	<tr>");
			out.println("		<td><b>郎</b></td>");
			out.println("		<td><b>更Ω计</b></td>");
			out.println("		<td><b>更</b></td>");
			out.println("	</tr>");
			
			for(Entry <String,Integer> entry:map.entrySet()){
		       this.log("Key = "+entry.getKey()+",value = "+entry.getValue());		
			}
			
			
			for(Entry<String, Integer> entry : map.entrySet()){
				out.println("<tr>");
				out.println("	<td>" + entry.getKey() + "</td>");
				out.println("	<td>" + entry.getValue() + "</td>");
				out.println("	<td><a href='" + request.getRequestURI() + "?filename=" + entry.getKey() + "' target='_blank' onclick='location=location; '>更</a></td>");
				out.println("</tr>");
			}
			
			out.println("</table>");
			out.println("	</legend>");
			out.println("  </BODY>");
			out.println("</HTML>");
			out.flush();
			out.close();
		}
		
	}

	@Override
	public void destroy() {
		map = null;
	}

}
