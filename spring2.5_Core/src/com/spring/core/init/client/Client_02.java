package com.spring.core.init.client;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.spring.core.init.InitializingBean02;

public class Client_02 {
	
  public static void main(String[] args) throws Exception {

	XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
    InitializingBean02 init = (InitializingBean02) factory.getBean("initializingBean02");
	
    init.showInfo("kevin-2");

  }
}
