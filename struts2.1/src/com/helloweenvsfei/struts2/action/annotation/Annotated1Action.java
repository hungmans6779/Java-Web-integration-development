package com.helloweenvsfei.struts2.action.annotation;

import org.apache.struts2.convention.annotation.Namespace;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import com.opensymphony.xwork2.ActionSupport;

/*
 *  零設定(zero configuration) 的意思不是任何設定檔佈署 Struts2 應用，如  struts.xml、struts.properties、validation.xml 等。
 *  零設定並不是真的"零設定"，只是沒有傳統的設定檔 struts.xml 了，但是仍需要使用 @Annotation 設定。 @Annotation 翻譯為@註釋、 @標記，
 *  有些資料也釋譯為 @註釋。
 */



// 命名空間
@Namespace(value = "/useAnnotationNamespace")
@Results({  // 結果集(3個結果頁面)
  @Result(name="login",   location="/form/annotated/login1.jsp"),
  @Result(name="success", location="/form/annotated/success1.jsp"),
  @Result(name="redirect",location="/form/annotated/redirect1.jsp")
})
public class Annotated1Action extends ActionSupport {

	private String account;
	private String password;

	// 主方法
	public String execute() {	
	  System.out.println(Annotated1Action.class.getName()+",execute()");
		 
      System.out.println("********************************************");
	  System.out.println(Annotated1Action.class.getName());
	  System.out.println("01. account = "+account);
	  System.out.println("02. password = "+password);
	  System.out.println("********************************************");

	  if("kevin".equals(account) && "1234".equals(password)){
		return add();  
	  }
	  return LOGIN;
	} // end execute()

	
	
	public String add() {
	  System.out.println(Annotated1Action.class.getName()+",add()");

	  return SUCCESS;
	} // end add

	
	
	public String login() {
	  System.out.println(Annotated1Action.class.getName()+",login()");
	  
	  return execute();
	} // end login

	
	
	public String redirect() {
      System.out.println(Annotated1Action.class.getName()+",redirect()");  
	  return "redirect";
    } // end login
	
	
	
	
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
