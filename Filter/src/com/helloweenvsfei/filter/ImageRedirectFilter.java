package com.helloweenvsfei.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.rmi.server.Dispatcher;

public class ImageRedirectFilter implements Filter {

	public void init(FilterConfig config) throws ServletException {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;

		
		response.setCharacterEncoding("UTF-8");

		String referer = request.getHeader("referer");
		System.out.println("referer = " + referer);
		System.out.println("serverName = "+request.getServerName());
		
		
		if(referer==null || !referer.contains(request.getServerName())){
		  System.out.println("顯示 error.gif");
		  RequestDispatcher dispatcher =  request.getRequestDispatcher("/error.gif");
		  dispatcher.forward(request, response);
		  
		}else{
	      System.out.println("正常顯示");
		  chain.doFilter(request, response);
		}
		
		
	}

}
