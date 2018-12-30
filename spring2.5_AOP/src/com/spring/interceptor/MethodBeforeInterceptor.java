package com.spring.interceptor;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

import com.spring.aop.service.impl.AopServiceImpl;

/*
 *  方法前攔截器
 *  
 *  實現自MethodBeforeAdvice　介面。方法前攔截器在執行指定方法前被呼叫，參數分別為呼叫的方法、執行時被傳入的參數、被攔截的 Bean。
 *  被攔截的執行方法在 applicationContext.xml 中設定。
 *  
 */
public class MethodBeforeInterceptor implements MethodBeforeAdvice {

  /*
   *  呼叫物件的方法前將執行該方法。參數分別為被呼叫的方法，被呼叫方法的參數、物件
   */
  public void before(Method method, Object[] args, Object obj) throws Throwable {
	System.out.println("\n");
	System.out.println(MethodBeforeInterceptor.class.getName()+" before() execute ...");  
	System.out.println("即將要執行方法名稱為："+method.getName());
	
	if(obj instanceof AopServiceImpl){
	  String name = ((AopServiceImpl)obj).getName();
	  System.out.println(MethodBeforeInterceptor.class.getName()+",name = "+name);
	  if(name == null){
		throw new NullPointerException("name 屬性不能為 null　！");  
	  }
	} // end if(obj instanceof AopServiceImpl){
	
  } // before

  
  
}
