package com.helloweenvsfei.struts2.action.interceptor.loginPage;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import com.helloweenvsfei.struts2.action.LoginAction;

@Namespace(value="/tags")
@Action(value="loginInterceptor",
  results={
	@Result(name="input",location="/form/interceptor/loginPage/login.jsp"),
	@Result(name="success",location="/form/interceptor/loginPage/loginSuccess.jsp")
  }
)
public class LoginInterceptorAction implements ServletContextAware,SessionAware,ServletRequestAware,ServletResponseAware{

  private ServletContext application;	
  private Map session;
  private HttpServletRequest request;
  private HttpServletResponse response;
  
  
  
  private String account;  // 帳號
  private String password; // 密碼
  
  
  // 主方法
  public String execute(){  
	System.out.println("***********************************************************************");
	System.out.println(LoginInterceptorAction.class.getName()+" , execute()...");
	System.out.println("01.account  = "+account);
	System.out.println("02.password = "+password);
	System.out.println("***********************************************************************");
	
	  
	if("kevin".equals(account) && "1234".equals(password)){
      System.out.println("登入成功！！！");
      
      request.getSession(true).setAttribute("account",account);
      
	  return "success";
	}
	  
	
	return "input";  
  } // end execute()


  
  
  
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




  public void setSession(Map<String, Object> session) {
    this.session = session;
  }

  public void setServletContext(ServletContext application) {
	this.application = application;
  }

  public void setServletRequest(HttpServletRequest request) {
	this.request = request;
  }

  public void setServletResponse(HttpServletResponse response) {
	this.response = response;
  }  
  

  
  
  
}
