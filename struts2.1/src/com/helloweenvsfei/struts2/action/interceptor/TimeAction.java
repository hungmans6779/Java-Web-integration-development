package com.helloweenvsfei.struts2.action.interceptor;

import com.opensymphony.xwork2.ActionSupport;


public class TimeAction extends ActionSupport {
  
  // ¥D¤èªk
  public String execute() throws Exception{
    System.out.println(TimeAction.class.getName()+",execute()...");
    
    Thread.sleep(1000);  // ©µ¿ð1¬í
    
	return "success";
  } // end execute()
  
  
  
}
