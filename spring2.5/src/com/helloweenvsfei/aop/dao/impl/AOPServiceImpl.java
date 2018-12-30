package com.helloweenvsfei.aop.dao.impl;

import javax.security.auth.login.AccountException;

import com.helloweenvsfei.aop.dao.IAOPService;

public class AOPServiceImpl implements IAOPService {

  private String name;
  
  // 將會被攔截
  public void withAOP() throws Exception {
    System.out.println("有 AOP 的函數執行。name："+name);
    if(name.trim().length()==0){
      throw new AccountException("name 屬性不能為空...");	
    }
  }

  
  // 將不會被攔截
  public void withoutAOP() throws Exception {
    System.out.println("沒有 AOP 的函數執行");
  }


  /**
   * @return the name
   */
  public String getName() {
	return name;
  }


  /**
   * @param name the name to set
   */
  public void setName(String name) {
	this.name = name;
  }

  
  
  
  
}
