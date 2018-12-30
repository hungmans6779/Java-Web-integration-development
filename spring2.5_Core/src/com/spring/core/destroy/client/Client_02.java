package com.spring.core.destroy.client;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.spring.core.destroy.DestroyBean02;


public class Client_02 {

  public static void main(String[] args) {
		  
	XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
		
	DestroyBean02 destroyBean = (DestroyBean02)factory.getBean("destoryBean02");
	destroyBean.showInfo();	
  }

}