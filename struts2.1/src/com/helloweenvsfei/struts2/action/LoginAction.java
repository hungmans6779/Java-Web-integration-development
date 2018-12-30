package com.helloweenvsfei.struts2.action;

import com.opensymphony.xwork2.ActionSupport;

/*
 *  Struts2.x 中每個 Action 實例會被反覆使用。而 Struts 2 中每個 Action 都會有多個實例，處理一次請求產生一個實例，
 *  這些實例彼此獨立，處理完畢即銷毀。
 *  所以 Struts 2 是執行緒安全的。由於 Action 中沒有其他特殊資源，使用完畢後便被直接拋棄，而不會造成浪費。
 *  
 *  ActionSupport 中實現了其他的方法，例如資料驗證等，繼承 ActionSupport 的好處是可以直接使用資料驗證等  Struts2 整合方法。
 */
public class LoginAction extends ActionSupport {

	private String account;     // 帳號
	private String password;    // 密碼

	
    // 主方法
	public String execute(){
	
	  System.out.println("********************************");
	  System.out.println(LoginAction.class.getName());
	  System.out.println("01.account  = "+account);
	  System.out.println("02.password = "+password);
	  System.out.println("********************************");
		
	  if("kevin".equals(account) && "1234".equals(password)){
		return SUCCESS;      // 傳回成功頁面
		// return "success";
	  }
	  
	  // return LOGIN;      // 傳回登入頁面
	  return "login";
	  
	} // end execute
	
	
	
	
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
