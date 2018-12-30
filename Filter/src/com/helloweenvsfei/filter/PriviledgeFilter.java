package com.helloweenvsfei.filter;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.helloweenvsfei.exception.AccountException;


public class PriviledgeFilter implements Filter {

	private Properties pp = new Properties();
	
	public void init(FilterConfig config) throws ServletException {

		String file = config.getInitParameter("file");
		String realPath = config.getServletContext().getRealPath(file);
		try {
		  System.out.println("realPath = " + realPath);
		  pp.load(new FileInputStream(realPath));
		}catch (Exception e) {
		  config.getServletContext().log("讀取許可權控制檔案失敗。", e);
		}
	}

	
	public void destroy() {
	  pp = null;
	}

	
	
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws ServletException, IOException {

	  HttpServletRequest request=(HttpServletRequest)req;
	  HttpServletResponse response=(HttpServletResponse)res;
	  
	  String requestURI=request.getRequestURI().replace(request.getContextPath()+"/","");
	  // System.out.println("requestURI = "+requestURI);
	  
	  String action=request.getParameter("action");
	  action=action==null?"":action;
	  
	  String uri=requestURI+"?action="+action;
	  // System.out.println("uri = "+requestURI);
	  
	  
	  String role=(String)request.getSession(true).getAttribute("role");
	  role=(role==null)?"guest":role;
	  
	  
	  boolean authentificated=false;
	  for(Object obj:pp.keySet()){
		String key=(String)obj;
		//System.out.println("key = "+key);
		if(uri.matches(key.replace("?","\\?").replace(".","\\.").replace("*",".*"))){
	      if(role.equals(pp.get(key))){
	    	 authentificated=true;
	    	 break;
	      } // if(role.equals(pp.get(key))){
		} // end if(uri.matches(key.replace("?","\\?").replace(".","\\.").replace("*",".*"))){
	  } // end for(Object obj:pp.keySet()){

	  if(!authentificated){
		throw new RuntimeException(new AccountException("您無權存取該頁面。請以合適的身份登入後檢視！！！"));  
	  }else{
	    chain.doFilter(req,res);
	  }
	  
	} 
	
	

}
