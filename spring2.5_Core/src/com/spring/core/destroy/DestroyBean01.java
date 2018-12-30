package com.spring.core.destroy;

import org.springframework.beans.factory.DisposableBean;

/*
 *  DisposableBean 介面執行銷毀方法
 *  
 *  實現了 DisposableBean 介面的 JavaBean 會在物件丟棄的時候呼叫銷毀方法。
 *  但使用該介面會與 Spring 程式碼發生耦合，因此不推薦使用。
 */
public class DestroyBean01 implements DisposableBean {
	
  private String message;

  public String getMessage() {
	return message;
  }

  public void setMessage(String message) {
	this.message = message;
  }

  
  public void showInfo(){
	System.out.println(DestroyBean01.class.getName()+",showInfo() execute...");
	System.out.println("message = "+message);
  }
  
  
  
  
  public void destroy() throws Exception {
	System.out.println(DestroyBean01.class.getName()+",destroy() execute...");
  }

  
			 
}
