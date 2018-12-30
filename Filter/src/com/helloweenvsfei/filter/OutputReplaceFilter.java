package com.helloweenvsfei.filter;

import com.helloweenvsfei.response.HttpCharacterResponseWrapper;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class OutputReplaceFilter implements Filter {
  
  private Properties pp=new Properties();	
 	
  public void init(FilterConfig config) throws ServletException{
	String file=config.getInitParameter("file"); 
	String realPath=config.getServletContext().getRealPath(file);
	try{
	  pp.load(new FileInputStream(realPath));	
	}catch(Exception e){	
	}
  }
  
  public void destroy(){
	pp=null;  
  }
  
  
  public void doFilter(ServletRequest req,ServletResponse res,FilterChain chain) throws IOException,ServletException{
	  
	  HttpCharacterResponseWrapper response=new HttpCharacterResponseWrapper((HttpServletResponse)res);  
	  chain.doFilter(req,response);
	  String output=response.getCharArrayWriter().toString();
	  
	  for(Object obj:pp.keySet()){
		String key=(String)obj;
		output=output.replace(key,pp.getProperty(key));
	  }

	  PrintWriter out=res.getWriter();
	  out.write(output);
	  out.println("<-- Generated at "+new java.util.Date()+" -->");

  }
  
  
  
}
