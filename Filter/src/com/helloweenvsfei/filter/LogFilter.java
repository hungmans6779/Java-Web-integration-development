package com.helloweenvsfei.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.commons.logging.Log;
import com.sun.org.apache.commons.logging.LogFactory;



public class LogFilter implements Filter{

  private Log log=LogFactory.getLog(this.getClass());
  
  private String filterName;
	
  public void init(FilterConfig config) throws ServletException{
	filterName =config.getFilterName();
	log.info("啟動 Filter "+filterName);
  }
  
  
  public void destroy(){
	log.info("關閉  Filter: "+filterName);  
  }
  
  
  public void doFilter(ServletRequest req,ServletResponse res,FilterChain chain) throws IOException,ServletException{
	HttpServletRequest request=(HttpServletRequest)req;
	HttpServletResponse response=(HttpServletResponse)res;
	
	long startTime=System.currentTimeMillis();
	String reqeustURI=request.getRequestURI();
	
	reqeustURI=request.getQueryString()==null?reqeustURI:(reqeustURI+"?"+request.getQueryString());
	
	chain.doFilter(request, response);
	long endTime=System.currentTimeMillis();
	
	log.info(request.getRemoteAddr()+" 存取了 "+reqeustURI+",總用時 "+(endTime-startTime)+ " 毫秒。");
	
  }
	
  
	
}
