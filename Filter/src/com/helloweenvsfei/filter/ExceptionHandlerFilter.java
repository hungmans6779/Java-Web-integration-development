package com.helloweenvsfei.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.helloweenvsfei.exception.AccountException;
import com.helloweenvsfei.exception.BusinessException;

public class ExceptionHandlerFilter implements Filter {

	public void init(FilterConfig config) throws ServletException {

	}

	public void destroy() {

	}

	
	
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		
		
       try{
    	  chain.doFilter(request,response);   
       }catch(Exception e){
    	  Throwable rootCause = e;
    	  while(rootCause.getCause()!=null){ 
    		rootCause=rootCause.getCause();  
    	  } // end while(rootCause.getCause()!=null){ 
    	  
    	  String message=rootCause.getMessage();
    	  message=message==null?" ¨Ò¥~ "+rootCause.getClass().getName():message;
    	  
    	  request.setAttribute("message",message);
    	  request.setAttribute("e",e);
    	  
    	  if(rootCause instanceof AccountException){
    	    request.getRequestDispatcher("/AccountException.jsp").forward(request,response);
    	  }else if(rootCause instanceof BusinessException){
    		request.getRequestDispatcher("/BusinessException.jsp").forward(request,response);
    	  }else{
    		request.getRequestDispatcher("/Exception.jsp").forward(request,response);  
    	  }
    	  
       }finally{
       }
       
       
	}

}
