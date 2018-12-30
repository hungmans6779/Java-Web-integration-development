package com.helloweenvsfei.watermark;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WaterMarkFilter implements Filter {

  // 浮水印圖片檔案的路徑，設定在初始化參數中
  private String waterMarkFile;
  
  
  public void init(FilterConfig config) throws ServletException{
    String file=config.getInitParameter("waterMarkFile");	
	  
    // 真正檔案位置
    waterMarkFile=config.getServletContext().getRealPath(file);
     
  }
  
  
  public void doFilter(ServletRequest req,ServletResponse res,FilterChain chain) throws IOException,ServletException{
	HttpServletRequest request=(HttpServletRequest)req;
	HttpServletResponse response=(HttpServletResponse)res;
	
	WaterMarkResponseWrapper waterMarkRes=new WaterMarkResponseWrapper(response,waterMarkFile);
	chain.doFilter(request, waterMarkRes);
	
	// 增加浮水印，輸出到用戶端瀏覽器
	waterMarkRes.finishResponse();
  }
  
  
  public void destroy(){  
  }
  
  
  
  
  
}
