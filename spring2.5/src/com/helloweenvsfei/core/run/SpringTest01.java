package com.helloweenvsfei.core.run;

import java.io.FileInputStream;
import java.io.InputStream;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.helloweenvsfei.core.service.IService;
import com.helloweenvsfei.core.service.IService2;

public class SpringTest01 {


	
	
  public static void main(String[] args) {
	
	  
	// *********************************************************************************************  
	
	// 載入設定檔
	XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext-core.xml"));

	// 從設定檔中獲得物件
	IService hello = (IService)factory.getBean("service");
	
	// 執行 service 方法
	hello.service("Kevin01");
	
	// 銷毀產生的Bean
	factory.destroySingletons();
	
	// *********************************************************************************************
	
	
	
	// ***********************************************************************************************
	// 練習用1
    ClassPathResource rs = new ClassPathResource("applicationContext-core.xml");
	XmlBeanFactory factory1 = new XmlBeanFactory(rs);  
    IService hello01_1 = (IService)factory1.getBean("service");
    hello01_1.service("kevinTest01-1");
	factory1.destroySingletons();
	// ***********************************************************************************************

	
	
	// ***********************************************************************************************
	// 練習用2(執行2個以上的 Spring 設定檔)
	ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(
	  new String []{"applicationContext-core.xml","applicationContext-core1.xml"}
	);
	BeanFactory factory2 = (BeanFactory)appContext;
	
    IService hello02_1 = (IService)factory2.getBean("service");
	hello02_1.service("kevinTest02-1");
	
	IService2 hello02_2 = (IService2)factory2.getBean("service2");
	hello02_2.service("kevinTest02-2");
	// ***********************************************************************************************
	
  } // end public static void main(String[] args) {
  
  

}
