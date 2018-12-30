package com.helloweenvsfei.struts2.action.tags.NonUITag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

@Namespace(value="/tags")
@Action(value="divLoginTag",
        results={
          @Result(name="input",location="/form/tags/NonUITag/divLogin.jsp"),
          @Result(name="script",location="/form/tags/NonUITag/divLoginScript.jsp")
})
public class DivLoginAction extends ActionSupport {

	
  private String username;  // 使用者名稱
  private String password;  // 使用者密碼
  
  
  
  // 主方法	
  public String execute(){
	System.out.println(DivLoginAction.class.getName()+",execute()...");
	
	return "input";    //  傳回輸入頁面
  } // end execute()
  
  
  
  
  
  // login 登錄方法
  public String login(){
	System.out.println(DivLoginAction.class.getName()+",登入 login()...");
	System.out.println("username = "+username);  
	System.out.println("password = "+password);
  
	HttpServletRequest  request = ServletActionContext.getRequest();
	HttpSession session = request.getSession(true);
	
	if("kevin".equals(username) && "1234".equals(password)){
	  session.setAttribute("username",username);
	  request.setAttribute("status","success");  // 標記為成功
	}else{
	  request.setAttribute("status","failed");   // 標記為失敗
	}
	
	return "script";  // 傳回指令稿頁面
  } // end login()
  
  
  
  
  
  
  
  // logout 登出方法
  public String logout(){
    System.out.println(DivLoginAction.class.getName()+",登出 logout()...");  
 	HttpServletRequest  request = ServletActionContext.getRequest();
 	HttpSession session = request.getSession(true);
 	
    session.removeAttribute("username");
    request.setAttribute("status","logout");   // 標記為登出
 
	return "input";                          // 傳回指令稿頁面
  } // end logout()




  public String getUsername() {
	return username;
  }

  public void setUsername(String username) {
	this.username = username;
  }

  public String getPassword() {
	return password;
  }

  public void setPassword(String password) {
	this.password = password;
  }
  
  
  
}
