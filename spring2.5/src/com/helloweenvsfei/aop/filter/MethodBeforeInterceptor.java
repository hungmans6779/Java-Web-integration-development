package com.helloweenvsfei.aop.filter;

import java.lang.reflect.Method;


import org.springframework.aop.MethodBeforeAdvice;

import com.helloweenvsfei.aop.dao.impl.AOPServiceImpl;

/*
 * 《方法前攔截器》
 *  方法前攔截器檢查name 是否為 null
 *  方法前攔截器，實現自 MethodBeforeAdvice 介面。
 *  方法前攔截器在執行指定方法前被呼叫，參數分別為被呼叫的方法、執行時被傳入的參數，被攔截的Bean。
 *  被攔截的執行方法在 applicationContext-aop.xml 中設定。
 */
public class MethodBeforeInterceptor implements MethodBeforeAdvice {

	
  // 呼叫物件的方法前將執行該方法，參數分別為被呼叫的方法，被呼叫方法的參數、物件
  public void before(Method method, Object[] args, Object instance) throws Throwable {
	System.out.println(MethodBeforeInterceptor.class.getName()+",before() 即將要執行方法："+method.getName());
	
	if(instance instanceof AOPServiceImpl){
	  String name = ((AOPServiceImpl) instance).getName();  // 獲得name
	  if(name==null){
		throw new NullPointerException(MethodBeforeInterceptor.class.getName()+" , name 屬性不能為null...");
	  }
	} // end if(instance instanceof AOPServiceImpl){
	
  } // end before

}
