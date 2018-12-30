package com.helloweenvsfei.core.other.run;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class InitializingBeanTest02 {

  /**
   * @param args
   */
  public static void main(String[] args) {
	XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext-core.xml"));
	factory.getBean("initialBean02");
  }

}
