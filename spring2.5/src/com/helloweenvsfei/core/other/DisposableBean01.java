package com.helloweenvsfei.core.other;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class DisposableBean01 implements DisposableBean {

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
    System.out.println(DisposableBean01.class.getName()+",destroy() message => "+message);
  }
  
  
  
  public static void main(String args[]){    
    ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-core.xml");
    DisposableBean01 db01 = (DisposableBean01)context.getBean("disposableBean01");
    System.out.println("db01 = "+db01);
    context.close();
    
    
  }
  

}
