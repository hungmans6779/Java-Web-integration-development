package com.helloweenvsfei.struts2.action.tags.dataTags;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

@Namespace(value="/tags")
@Action(value="loginAction",
        results={
          @Result(name="success",location="/form/tags/dataTag/login.jsp")
        }
)
public class LoginAction extends ActionSupport {
 
  private String account;
  private String password;
  
  
  public String execute(){
	System.out.println(LoginAction.class.getName()+",execute()...");
	System.out.println("account  = "+account);
	System.out.println("password = "+password);
	
	return "success";
  } // end public String execute(){

  


  public String getAccount() {
	return account;
  }

  public void setAccount(String account) {
	this.account = account;
  }

  public String getPassword() {
	return password;
  }

  public void setPassword(String password) {
	this.password = password;
  }
  
  
  
  
}
