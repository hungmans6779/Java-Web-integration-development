package com.spring.dao.client;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.spring.dao.transaction.TransactionRun;

public class Client_Transaction {

	
  public static void main(String[] args) {
		
	// 載入設定檔
    XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
    
    // 取得 Bean 
    TransactionRun tr = (TransactionRun)factory.getBean("transactionRun");
    
    // 主方法，供 Spring 呼叫
    tr.run();
  } // main

}
