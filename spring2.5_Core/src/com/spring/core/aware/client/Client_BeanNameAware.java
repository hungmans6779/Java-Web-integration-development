package com.spring.core.aware.client;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.spring.core.aware.WhatsTheNameBean;

public class Client_BeanNameAware {


  public static void main(String[] args) {
	
	System.out.println("µ{§Ç-1");
    XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));

    System.out.println("µ{§Ç-2");
    WhatsTheNameBean bean = (WhatsTheNameBean)factory.getBean("beanNameId");
    
    System.out.println("µ{§Ç-3");
    bean.showBean();
  
    System.out.println("µ{§Ç-4");
    
  } // end main

}
