package com.helloweenvsfei.struts2.action;

import java.io.File;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

/*
 * Struts2.x 的 Action 並 不一定要實現 Action 介面，任何的 POJO 都可以用做 Action ，只要這個 Action 具有 public String execute() 方法。

 * 如果 Struts2 發現 Action 類別沒有實現 Action 介面，會透過反射來呼叫 execute() 方法。
 */




/*
 *  此類別不實現任何介面，不繼承任何類別
 *  不實現 Action 介面的好處是不與 Struts2 發生耦合，程式碼不相依於 Struts2 的類別函式庫
 *  Struts2 還可以執行 Action 的其他方法，只要這些方法沒有參數，並傳回 String 類型。這些方法也可以有 throws 宣告，也可以沒有。
 *  Struts2 會在執行時根據方法的特徵判斷是否可執行方法(參數、傳回)，並透過反射執行。
 *  login() 及 logout() 並不是預設可執行方法。可將其設定到 struts.xml 中，或者透過特定的 URL
 *  (例如： loginPerson3!login.action 、 loginPerson3!logout.action 等)直接執行這些非預定方法。
 */
public class LoginAction3 {

	private String account;   // 帳號
	private String password;  // 密碼

	
	
	  
	// 主方法
	// Struts2.x 的 Action 並 不一定要實現 Action 介面，任何的 POJO 都可以用做 Action ，只要這個 Action 具有 public String execute() 方法。
	// 如果 Struts2 發現 Action 類別沒有實現 Action 介面，會透過反射來呼叫 execute() 方法。
	public String execute(){
	  System.out.println(LoginAction3.class.getName()+",execute() 執行了");
		 
	  // 透過 ServletActionContext 取得 request,response 物件
	  HttpServletRequest request = ServletActionContext.getRequest();

	  // 將帳號放到 session 中
	  HttpSession session = request.getSession(true);
	  session.setAttribute("account",account);
	  
	  System.out.println("**************************************************");
	  System.out.println("execute()");
	  System.out.println("01.account         = "+account);
	  System.out.println("02.password        = "+password);
	  System.out.println("03.account         => request.getParameter('account')  = "+request.getParameter("account"));
	  System.out.println("04.password-1      => request.getParameter('password') = "+request.getParameter("password"));
	  System.out.println("05.session account => session.getAttribute('account')  = "+session.getAttribute("account"));
	  System.out.println("**************************************************");
				
	  if("kevin".equals(account) && "1234".equals(password)){
		return "success";   // 傳回成功頁面
	  }
	  
	  return "login";       // 傳回登入頁面
	} // end execute() 
	

	
	
	
	
	
	// 登入方法
	public String login() throws Exception{
	  System.out.println(LoginAction3.class.getName()+",login() 執行了");
	  
	  // 透過 ServletActionContext 取得 request,response 物件
	  HttpServletRequest request = ServletActionContext.getRequest();
	  HttpServletResponse response = ServletActionContext.getResponse();

	  // 將帳號放到 session 中
	  HttpSession session = request.getSession(true);
	  session.setAttribute("account",account);
	  
	  // 獲得 Web 應用根目錄下的 /upload 檔案夾
	  ServletContext context = ServletActionContext.getServletContext();
	  File uploadFile = new File(context.getRealPath("upload"));
	  
	  System.out.println("**************************************************");
	  System.out.println("login() ");
	  System.out.println("01.account    => request.getParameter('account')  = "+request.getParameter("account"));
	  System.out.println("02.password-1 => request.getParameter('password') = "+request.getParameter("password"));
	  System.out.println("**************************************************");
				
	  
	  return execute(); // 傳回主方法	
	} // end     DROP TABLE itrocko_person;
	
	
	
	
	
	
	// 註銷方法
	public String logout(){
      System.out.println(LoginAction3.class.getName()+",logout() 執行了");
	  return "logout"; // 傳回登出頁面
	} // end logout
	
	
	
	
	
	
	
	
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
