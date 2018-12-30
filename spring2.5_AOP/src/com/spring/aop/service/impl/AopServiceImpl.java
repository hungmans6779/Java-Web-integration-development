package com.spring.aop.service.impl;

import javax.security.auth.login.AccountException;

import com.spring.aop.service.IAopService;

/*
 *  實作 IAopService 的介面
 */
public class AopServiceImpl implements IAopService {

  private String name;

  public String getName() {
	return name;
  }

  public void setName(String name) {
    System.out.println(AopServiceImpl.class.getName()+",setName() Method execute....");
    System.out.println("name = "+name);
	this.name = name;
  }

	
	
  // 會被攔截
  public void withAop() throws Exception {
	System.out.println("\n");
	System.out.println(AopServiceImpl.class.getName()+",withAop()  execute...");
    System.out.println("有 AOP 的函數執行。name = "+name);
    System.out.println("\n");
    if(name.trim().length() ==0 ){
      throw new AccountException("name 屬性不能為空");
    }
  } // end withAop()
 
	
  
  // 不會被攔截
  public void withoutAop() throws Exception {
	System.out.println("\n");
	System.out.println(AopServiceImpl.class.getName()+",withoutAop()  execute...");
 	System.out.println("沒有 AOP 的函數執行。name = "+name);
 	System.out.println("\n"); 
  } // end withoutAop()
  
  

}
