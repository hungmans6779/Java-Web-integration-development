package com.helloweenvsfei.cache;

import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class CacheResponseWrapper extends HttpServletResponseWrapper{
  
  // 快取記憶體字元類別輸出(類別實現一個可用作 Writer 的字符緩衝區)
  private CharArrayWriter cacheWriter=new CharArrayWriter();
  

  public CacheResponseWrapper(HttpServletResponse response) throws IOException{
	 super(response); 
  }
  
  
  @Override
  public PrintWriter getWriter() throws IOException{; 
	 return new PrintWriter(cacheWriter);// 傳回快取記憶體內容的Writer
  }
  
  
  @Override
  public void flushBuffer() throws IOException{
	 cacheWriter.flush();  
  }
  
  
  public void finishResponse() throws IOException{
	cacheWriter.close();  
  }
  
  public CharArrayWriter getCacheWriter(){
	return cacheWriter;
  }
  
  
  public void setCacheWriter(CharArrayWriter cacheWriter) {
	  this.cacheWriter=cacheWriter;
  }
  
  
  
}
