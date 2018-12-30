package com.helloweenvsfei.struts2.action.interceptor;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;


public class TokenInputAction extends ActionSupport{

	
  // ¥D¤èªk
  public String execute(){
	System.out.println(TokenInputAction.class.getName()+",execute()...");
	
	return SUCCESS;
  } // end execute()

  
}
