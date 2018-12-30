package com.helloweenvsfei.xml;

import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class XSLTFilter implements Filter{

	private ServletContext servletContext; 
	
	public void init(FilterConfig config) throws ServletException{
	  servletContext=config.getServletContext();	
	}
	
	
	public void doFilter(ServletRequest req,ServletResponse res,FilterChain chain) throws IOException,ServletException{
	
	  HttpServletRequest request=(HttpServletRequest)req;
	  HttpServletResponse response=(HttpServletResponse)res;
	  
	  // 格式樣本檔案
	  Source styleSource=new StreamSource(servletContext.getRealPath("/MessageLog.xsl"));
	  
	  // 請求的XML檔案
	  Source xmlSource=new StreamSource(servletContext.getRealPath(request.getRequestURI().replace(request.getContextPath()+"","")));
	  
	  try{
		
		// 轉換器工廠
	    TransformerFactory transformerFactory=TransformerFactory.newInstance();
	    
	    // 轉換器
	    Transformer transformer =  transformerFactory.newTransformer(styleSource);
	    
	    // 將轉換的結果儲存到該物件中
	    CharArrayWriter charArrayWriter = new CharArrayWriter();
	    
	    // 快取記憶體 writer
	    StreamResult result = new StreamResult(charArrayWriter);
	    
	    // 轉換
	    transformer.transform(xmlSource,result);
	    
	    response.setContentType("text/html");
	    response.setContentLength(charArrayWriter.toString().length());
	    
	    
	    PrintWriter out = response.getWriter();
	    out.write(charArrayWriter.toString());
	    
	  }catch(Exception e){
       
	  }
	  
	    
	  
	}
	
	
	public void destroy(){}
	
	
	
}
