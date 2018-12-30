package com.spring.interceptor;

import java.lang.reflect.Method;
import org.springframework.aop.AfterReturningAdvice;

/*
 *  方法後攔截器
 *  
 *  實現自AfterReturningAdvice介面。傳回後攔截器在執行完指定方法、並傳回之後被呼叫。
 *  如果有傳回值，可以取到傳回值，否則為 null 。參數分別為方法傳回值、被呼叫的方法、執行時被傳入的參數、被攔截的 Bean。
 *  
 */
public class MethodAfterInterceptor implements AfterReturningAdvice {

  public void afterReturning(Object value,Method method,Object[] args,Object object) throws Throwable {
	System.out.println(MethodAfterInterceptor.class.getName()+",afterReturning()  execute...");
	System.out.println("方法 "+method.getName()+" 執行完畢，傳回傳："+value);
  } // end afterReturning

	
}
