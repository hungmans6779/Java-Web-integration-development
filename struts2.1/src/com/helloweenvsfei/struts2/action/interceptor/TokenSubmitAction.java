package com.helloweenvsfei.struts2.action.interceptor;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;


public class TokenSubmitAction extends ActionSupport {

	
  private String name;
  private static final List<String> NAMES = new ArrayList<String>();  // static，模擬資料庫
  
  
  // 主方法
  public String execute(){  
    System.out.println(TokenSubmitAction.class.getName()+" , execute()...");	
    
    NAMES.add(name);
    
    System.out.println("name = "+name);
    System.out.println("NAMES size = "+NAMES.size());
    
    
	return "success";
  } // end execute

  
  
  public String addName(){
	System.out.println(TokenSubmitAction.class.getName()+" , addName()...");	
	
	return execute();  
  } // end addName()
  
  
  

  public String getName() {
	return name;
  }

  public void setName(String name) {
	this.name = name;
  }

  public List<String> getNAMES() {
	return NAMES;
  }

	
}
