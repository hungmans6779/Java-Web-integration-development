package com.webservice.xfire;

/*
 *  HelloWebServiceEnc 的實作類別
 */
public class HelloWebServiceEncImpl implements IHelloWebServiceEnc {
	
	
  public String sayHello(String message) {
		
	return "Hello,"+message;
  } // end sayHello
	
}