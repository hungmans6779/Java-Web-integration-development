package com.spring.core.client;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.spring.core.service.IService;

public class Client {

  public static void main(String[] args){
	
	// ¸ü¤J³]©wÀÉ
	XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));  
	IService hello = (IService)factory.getBean("service");
	hello.service("kevin");
	
  }

}
