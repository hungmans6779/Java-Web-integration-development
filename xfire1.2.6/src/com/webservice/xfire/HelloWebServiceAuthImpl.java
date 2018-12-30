package com.webservice.xfire;


/*
 *  HelloWebService 的實作類別
 */
public class HelloWebServiceAuthImpl implements IHelloWebServiceAuth {

  // 定義服務方法
  public String sayHello(String message) {
	return message;
  }
	
}