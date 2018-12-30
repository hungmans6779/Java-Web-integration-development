package com.helloweenvsfei.gzip;

import java.io.IOException;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class GZipResponseWrapper extends HttpServletResponseWrapper {
 
  // 預設的response	
  private HttpServletResponse response;
  
  // 自訂的outputStream,執行close()的時候對資料壓縮，並輸出
  private GZipOutputStream gzipOutputStream;
  
  // 自訂 printWriter,將內容輸出到 GZipOutputStream 中 
  private PrintWriter writer;
  
  
  public GZipResponseWrapper(HttpServletResponse response) throws IOException{
	super(response);
	this.response=response;
  }
  
  
  
  // 覆蓋getOutputStream()方法,處理二進位內容
  public ServletOutputStream getOutputStream() throws IOException{
	if(gzipOutputStream ==null){
	  gzipOutputStream=new GZipOutputStream(response);	
	}
	return gzipOutputStream;
  }
  
  
  
  // 覆蓋 getWriter() 方法，處理字元內容
  public PrintWriter getWriter() throws IOException{
	if(writer==null){
	  writer=new PrintWriter(new OutputStreamWriter(new GZipOutputStream(response),"UTF-8"));	
	}
	return writer;  
  }
  
  
  // 壓縮後資料長度會發生變化，因此將該方法內容清空
  public void setContentLength(int contentLength){
  }
  
  
  public void flushBuffer() throws IOException{
    gzipOutputStream.flush();
  }
  
  // 執行該方法將對資料進行GZIP壓縮，並輸出到瀏覽器。
  public void finishResponse() throws IOException{

    if(gzipOutputStream!=null){	
      gzipOutputStream.close();
    }
    
    if(writer!=null){
	  writer.close();
    }
    
  }
  
  
  
  
}
