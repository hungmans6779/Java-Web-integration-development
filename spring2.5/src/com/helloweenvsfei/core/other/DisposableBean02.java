package com.helloweenvsfei.core.other;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DisposableBean02 {
  
  String message;

  /**
   * @return the message
   */
  public String getMessage() {
	return message;
  }

  /**
   * @param message the message to set
   */
  public void setMessage(String message) {
	this.message = message;
  }
  
  
  public void destroy() throws Exception {
	System.out.println(DisposableBean02.class.getName()+",destroy() message => "+message);  
  }
  
  
  public static void main(String args[]){
	ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-core.xml");
	DisposableBean02 db02 =(DisposableBean02)context.getBean("disposableBean02");
	System.out.println("db02 = "+db02);
	context.close();  
  }
}
