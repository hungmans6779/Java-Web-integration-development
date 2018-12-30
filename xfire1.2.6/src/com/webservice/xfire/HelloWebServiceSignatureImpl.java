package com.webservice.xfire;


/*
 *  HelloWebServiceSignature 的實作類別
 */
public class HelloWebServiceSignatureImpl implements IHelloWebServiceSignature {
	
  // 定義服務方法
  public String sayHello(String message) {
	  
	return "Hello,"+message;
  } // end sayHello
  
	
  
}