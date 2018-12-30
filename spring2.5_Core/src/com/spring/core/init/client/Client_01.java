package com.spring.core.init.client;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.spring.core.init.InitializingBean01;

public class Client_01 {

  public static void main(String [] args){
	 
	XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
	
	InitializingBean01 init = (InitializingBean01)factory.getBean("initializingBean01");
	init.showInfo("kevin-1");
	
	
  }
  
}
