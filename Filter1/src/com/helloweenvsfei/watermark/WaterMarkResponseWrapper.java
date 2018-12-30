package com.helloweenvsfei.watermark;

import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class WaterMarkResponseWrapper extends HttpServletResponseWrapper{

	private String waterMarkFile;
	private HttpServletResponse response;
	
	
	// 自訂 servletOutputStream ,用於緩衝圖像資料
	private WaterMarkOutputStream waterMarkOutputStream = new WaterMarkOutputStream();
	
	public WaterMarkResponseWrapper(HttpServletResponse response,String waterMarkFile) throws IOException{
	  super(response);
	  this.response=response;
	  this.waterMarkFile=waterMarkFile;
	}
	
	
	// 覆蓋 getOutputStream(),傳回自訂的waterMarkOutputStream
	public ServletOutputStream getOutputStream() throws IOException{
		return waterMarkOutputStream;
	}
	
	
	public void flushBuffer() throws IOException{
		waterMarkOutputStream.flush();	
	}
	
	
	//  將圖像資料增加浮水印，並輸出到用戶端瀏覽器
	public void finishResponse() throws IOException{
	  
	  // 原圖片資料
	  byte [] imageData = waterMarkOutputStream.getByteArrayOutputStream().toByteArray();
	  
	  // 增加浮水印後的圖片資料
	  byte [] image =ImageUtil.waterMark(imageData, waterMarkFile);
	  
	  // 設定輸出內容的實際長度
	  response.setContentLength(image.length);
	  
	  // 將影像輸出到瀏覽器
	  response.getOutputStream().write(image);
	  
	  // 關閉waterMarkOutputStream 流
	  waterMarkOutputStream.close();
	  
	}
	
	
	
}
