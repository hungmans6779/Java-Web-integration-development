package com.helloweenvsfei.struts2.action.interceptor;

import com.opensymphony.xwork2.ActionSupport;

public class WaitAction extends ActionSupport {

	
  // ¥D¤èªk
  public String execute() throws Exception{
	Thread.sleep(10000);  // ©µ¿ð10¬í 
	
	return "success";  
  } // end execute()
  
  
}
