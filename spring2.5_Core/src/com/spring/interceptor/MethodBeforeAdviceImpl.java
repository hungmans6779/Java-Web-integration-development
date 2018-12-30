package com.spring.interceptor;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.springframework.aop.MethodBeforeAdvice;


/*
 *  在某些方法前執行的攔截器
 */
public class MethodBeforeAdviceImpl implements MethodBeforeAdvice {

	
  public void before(Method method, Object[] args, Object obj) throws Throwable {
	System.out.println(MethodBeforeAdviceImpl.class.getName()+",before()  execute...");
    System.out.println("執行前檢查");
    System.out.println("Method："+method.getName());    // 輸出資訊
    System.out.println("Args："+Arrays.asList(args));   // 輸出參數
    System.out.println("Object："+obj);                 // 輸出物件
  } // end before

  
}
