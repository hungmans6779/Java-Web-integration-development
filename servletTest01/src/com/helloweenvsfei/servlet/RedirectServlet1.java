package com.helloweenvsfei.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RedirectServlet1 extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public RedirectServlet1() {
		super();
	}

	
	@Override
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}


	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Refresh","1000; URL=http://www.eztravel.com.tw");
	}

	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	   doGet(request,response);
	}

	
	@Override
	public void init() throws ServletException {
		// Put your code here
	}
	

}
