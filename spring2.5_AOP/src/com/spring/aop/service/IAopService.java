package com.spring.aop.service;

public interface IAopService {

  // 會被攔截
  public void withAop() throws Exception;    
  
  // 不會被攔截 
  public void withoutAop() throws Exception; 
  
}
