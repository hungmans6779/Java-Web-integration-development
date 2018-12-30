package com.helloweenvsfei.struts2.action.tags.NonUITag;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

@Namespace(value="/tags")
@Action(value="errorTag",
        results={
		  @Result(name="success",location="/form/tags/NonUITag/errorInputTag.jsp")
}) 
public class ErrorAction extends ActionSupport {


  // 主方法
  public String execute(){
	System.out.println(ErrorAction.class.getName()+",execute()...");
	
	return "success";
  } // end execute()
  
  
  
  
  // error 方法。(增加 ActionError) 
  public String error(){
	System.out.println(ErrorAction.class.getName()+",error()...");
	
	this.addActionError("執行 error() 方法，拋出了第一個 error 訊息。");
	this.addActionError("執行 error() 方法，拋出了第二個 error 訊息。");
	  
	return "success";  // 傳回輸入頁面
  } // end error()
  
  
  
  
  // message 方法。(增加 ActionMessage) 
  public String message(){
	System.out.println(ErrorAction.class.getName()+",message()...");  
	  
    this.addActionMessage("執行 message() 方法，拋出了第一個 message 訊息。");
    this.addActionMessage("執行 message() 方法，拋出了第二個 message 訊息。");
    
	return "success";  // 傳回輸入頁面
  } // end message
  
  
  
  
  // fieldError 方法。(增加 FieldError) 
  public String fieldError(){
	System.out.println(ErrorAction.class.getName()+",fieldError()...");  

	this.addFieldError("username","請填寫使用者名稱");
	this.addFieldError("password","密碼不能為空");    
	  
	return "success";  // 傳回輸入頁面
  } // end fieldError()
  
  
  
}
