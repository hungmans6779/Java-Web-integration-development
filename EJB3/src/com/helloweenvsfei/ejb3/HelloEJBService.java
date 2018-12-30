package com.helloweenvsfei.ejb3;

import javax.ejb.Stateful;

@Stateful
public class HelloEJBService implements HelloEJBServiceRemote {
  
  public String sayHelloEJB(String name){
	String message = "Hello "+name +", Welcome to EJB World ¡I";
	
	return message;
  }
  
}
