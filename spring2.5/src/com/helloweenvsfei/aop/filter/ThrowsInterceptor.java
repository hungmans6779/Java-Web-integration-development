package com.helloweenvsfei.aop.filter;

import java.lang.reflect.Method;
import javax.security.auth.login.AccountException;
import org.springframework.aop.ThrowsAdvice;

/*
 * 《例外拋出攔截器》
 *  實現自 ThrowsAdvice 介面。如果指定的方法中有例外被拋出，則其被呼叫。與上兩個攔截器介面不同，
 *  ThrowsAdvice 介面沒有定義任何方法，因此不需要實現任何方法。但是如果定義了了形如：
 *  afterThrowing ([Method],[args],[target],subclassOfThrowable)的方法，這些方法會被呼叫。
 *  參數分別為：被呼叫的方法、方法的參數、被攔截的Bean 以及拋出的例外類。這裡面只有最後一行是必須的。
 *  Spring 之所以這樣設計，是為了使開發者可以靈活地定義多個捕捉不同的例外...
 */
public class ThrowsInterceptor implements ThrowsAdvice {
	
  public void afterThrowing(Method method,Object [] args,Object instance,AccountException ex) throws Throwable{
	System.out.println(ThrowsInterceptor.class.getName()+"方法 ："+method.getName()+" 拋出例外："+ex);  
  }
  
  
  public void afterThrowing(NullPointerException ex) throws Throwable{
    System.out.println(ThrowsInterceptor.class.getName()+",拋出例外："+ex);	  
  }
  
  
}
