package com.helloweenvsfei.aop.run;


import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.helloweenvsfei.aop.dao.IAOPService;

public class AOPRun {

 /**
  * @param args
  */
  public static void main(String[] args) throws Exception {
	XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext-aop.xml"));
	IAOPService hello = (IAOPService)factory.getBean("aopService");
	hello.withAOP();
	hello.withoutAOP();
	factory.destroySingletons();
  }

}
