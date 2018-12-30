package com.spring.aop.client;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.spring.aop.service.IAopService;

/*
 *  此範例：分別執行 Service 的兩個方法 withAop() 與 withoutAop()。
 *  Spring 將會在 withAop() 方法前後增加攔截器，但 withoutAop() 方法前後則不會增加。
 */
public class Client {
  
  public static void main(String [] args) throws Exception{
	  
	XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
	IAopService aopServiceBean = (IAopService)factory.getBean("aopService");
	
	System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
	System.out.println("呼叫 aopServiceBean.withAop() Method .....\n");
	aopServiceBean.withAop();
	System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
	System.out.println("呼叫 aopServiceBean.withoutAop() .....\n");
	aopServiceBean.withoutAop();
	System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
	System.out.println("呼叫 factory.destroySingletons() Method .....\n");
	factory.destroySingletons();
	System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
	
  } // end main
  
}
