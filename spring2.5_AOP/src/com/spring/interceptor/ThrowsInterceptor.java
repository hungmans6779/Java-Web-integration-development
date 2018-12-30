package com.spring.interceptor;

import java.lang.reflect.Method;

import javax.security.auth.login.AccountException;

import org.springframework.aop.ThrowsAdvice;

/*
 *  例外攔截器
 *  
 *  實現自ThrowsAdvice 介面。如果指定的方法中有例外被拋出，則其被呼叫。
 *  與其兩個攔截器介面不同，ThrowsAdvice 介面沒有定義任何方法，因此不需要實現任何方。
 */
public class ThrowsInterceptor implements ThrowsAdvice {

  // 方法一
  public void afterThrowing(Method method,Object [] args,Object object,AccountException ex) throws Throwable{
	System.out.println("\n");
	System.out.println(ThrowsInterceptor.class.getName()+", afterThrowing() 方法一  execute...");
    System.out.println("方法名稱 "+method.getName()+"，拋出例外："+ex);	  
  } // end  afterThrowing(Method method,Object [] args,Object object,AccountException ex)
  
  
  // 方法二
  public void afterThrowing(NullPointerException ex) throws Throwable{
	System.out.println("\n");
	System.out.println(ThrowsInterceptor.class.getName()+", afterThrowing() 方法二  execute...");
	System.out.println("拋出了例外："+ex);
  } // end  afterThrowing(NullPointerException ex)
  
  
}
