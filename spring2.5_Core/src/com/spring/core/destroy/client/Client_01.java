package com.spring.core.destroy.client;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.spring.core.destroy.DestroyBean01;

public class Client_01 {

  public static void main(String[] args) {
	  
	XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
	
	DestroyBean01 destroyBean = (DestroyBean01)factory.getBean("destoryBean01");
	destroyBean.showInfo();
	
  }

}
