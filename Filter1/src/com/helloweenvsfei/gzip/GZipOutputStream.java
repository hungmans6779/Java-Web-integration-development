package com.helloweenvsfei.gzip;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

public class GZipOutputStream extends ServletOutputStream{
  
	// 原response 
	private HttpServletResponse response;
	
	// 將壓縮後的資料存放到 ByteArrayOutputStream
	private ByteArrayOutputStream byteArrayOutputStream;
	
	// JDK 附帶的GZIP壓縮資料的類別
	private GZIPOutputStream gzipOutputStream;
	
	public GZipOutputStream(HttpServletResponse response) throws IOException{
      this.response=response;
      byteArrayOutputStream =new ByteArrayOutputStream();
      gzipOutputStream=new GZIPOutputStream(byteArrayOutputStream);
	}
	

	// 輸出到JDK的GZIP輸出類別中
	public void write(int b) throws IOException{
	  gzipOutputStream.write(b);
	}
	
	

	
	
	// 執行壓縮，並將資料輸出到瀏覽器
	public void close() throws IOException{
	  
      // 執行壓縮一定要呼叫該方法
	  gzipOutputStream.finish();
	  
	  // 將壓縮後的資料輸出到用戶端
	  byte [] content =byteArrayOutputStream.toByteArray();

	  // 設定壓縮方式為GZIP,用戶端瀏覽器會自動將資料壓縮
	  response.addHeader("Content-Encoding","gzip");
	  response.addHeader("Content-Length",Integer.toString(content.length));
	  
	  // 輸出到瀏覽器
	  ServletOutputStream out=response.getOutputStream();
	  out.write(content);
	  out.close();
	}
	
	
	public void flush() throws IOException{
	  gzipOutputStream.flush();
    }
		
	
	public void write(byte [] b,int off,int len)throws IOException{
	  gzipOutputStream.write(b,off,len);
	}
		
	public void write(byte [] b) throws IOException{
	  gzipOutputStream.write(b);	
	}
		
		


}

