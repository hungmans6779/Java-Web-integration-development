package com.helloweenvsfei.aop.dao;


//Service 介面，定義兩個方法
public interface IAOPService {
	
  // 將會被攔截
  public void withAOP() throws Exception;

  // 將不會被攔截
  public void withoutAOP() throws Exception;

}
