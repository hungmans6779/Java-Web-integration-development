package com.spring.core.propertyOverrideConfigurer.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.propertyOverrideConfigurer.PropertyOverrideConfigurer01;


public class Client_01 {

  public static void main(String[] args) {

    ApplicationContext context1 = new ClassPathXmlApplicationContext("applicationContext.xml");
    PropertyOverrideConfigurer01 propertyBean = (PropertyOverrideConfigurer01)context1.getBean("myPropertyBean01");
    
    String name = propertyBean.getName();
    String age = propertyBean.getAge();
    String worker = propertyBean.getWorker();
    String workCompany = propertyBean.getWorkCompany();
    
    System.out.println("*****************************************************");
    System.out.println("01. name        = "+name);
    System.out.println("02. age         = "+age);
    System.out.println("03. worker      = "+worker);
    System.out.println("04. workCompany = "+workCompany);
    System.out.println("*****************************************************");  
 
  }

  
}
