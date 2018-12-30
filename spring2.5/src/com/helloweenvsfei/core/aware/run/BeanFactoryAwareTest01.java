package com.helloweenvsfei.core.aware.run;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.helloweenvsfei.core.aware.A;

import edu.emory.mathcs.backport.java.util.Arrays;

public class BeanFactoryAwareTest01 {

  /**
  * @param args
  */
  public static void main(String[] args) {
     BeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext-core.xml"));
     System.out.println("a'Bean is exists => "+factory.containsBean("a"));
     System.out.println("AKB48'Bean is exists => "+factory.containsBean("AKB48"));
     System.out.println("a'Bean is singleton => "+factory.isSingleton("a"));
     
     String [] arg = factory.getAliases("a");
     System.out.println("a'Bean is Aliases => "+Arrays.toString(arg));
     
     A a = (A)factory.getBean("a");
     a.printB();
     a.printB();
     a.printB();
     
     
     if(factory.containsBean("a")){
       System.out.println("**************************************************************");
       A a1 = (A)factory.getBean("a");
       a1.printB();
       System.out.println("**************************************************************");
     }
     
  }

  
}