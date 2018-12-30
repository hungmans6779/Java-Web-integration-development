package com.helloweenvsfei.struts2.action.interceptor;

import com.opensymphony.xwork2.ActionSupport;


public class AuthenticationInterceptorAction extends ActionSupport {

  private String message;

  
  // 主方法 
  public String execute() {
	message = "您正在存取 AuthenticationAction. ";

	return "success";
  } // end execute()
  

  public String getMessage() {
		return message;
  }

  public void setMessage(String message) {
		this.message = message;
  }
  
  
}
