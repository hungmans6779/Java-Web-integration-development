package com.spring.core.aware.client;

import java.util.Arrays;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.spring.core.aware.A;


/*
 *  ● boolean containsBean(String)：判斷指定名稱的 Bean 是否存在。
 *  ● Object getBean(String)：傳回指定名稱的Bean。如果沒有該Bean，會拋出例外。
 *  ● Object getBean(String,Class)：傳回指定名稱的Bean ，並轉化為指定的類別物件。如果沒有該 Bean ，會拋出例外。如果該轉化錯誤，也會拋出例外。
 *  ● boolean isSingleton(String)：判斷指定名稱的Bean是否被設定為 singleton。如果沒有該Bean ，會拋出例外。
 *  ● String[]getAliases(String)：傳回指定名稱的 Bean 的別名。  
 */
public class Client_BeanFactoryAware {

  public static void main(String[] args) {
    BeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
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
      System.out.println("*******************************************************************************");
      A a1 = (A)factory.getBean("a");
      a1.printB();
      System.out.println("*******************************************************************************");
    }  
  }
  

}
