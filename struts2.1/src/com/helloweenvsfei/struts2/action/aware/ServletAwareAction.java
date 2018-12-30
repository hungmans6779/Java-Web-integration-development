package com.helloweenvsfei.struts2.action.aware;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;



/*
 *  Struts2.x 中每個 Action 實例會被反覆使用。而 Struts 2 中每個 Action 都會有多個實例，處理一次請求產生一個實例，
 *  這些實例彼此獨立，處理完畢即銷毀。
 *  所以 Struts 2 是執行緒安全的。由於 Action 中沒有其他特殊資源，使用完畢後便被直接拋棄，而不會造成浪費。
 *  
 *  ActionSupport 中實現了其他的方法，例如資料驗證等，繼承 ActionSupport 的好處是可以直接使用資料驗證等  Struts2 整合方法。
 *  
 *  Struts2 提供了 Aware 介面。Aware 為"感知"的意思，實現了相關  Aware 介面的Action 能夠感知相關的資源。
 *  Struts 在產生實體一個 Action 實例時，如果發現它實現了相應的 Aware 介面，會把相應的資源透過 Aware 介面方法注射進去。
 *  這種方式也可以叫做射方式(IoC方式)。 
 *  
 *  Aware 介面其實是一種攔截器，攔截器程式碼會在執行 Action 之前執行，將相關的Servlet 物件設定進來。
 */
public class ServletAwareAction extends ActionSupport implements ServletContextAware,SessionAware,ServletRequestAware,ServletResponseAware{

	private ServletContext application;     // Servlet 上下文
	private Map session;                    // session 物件
	private HttpServletRequest request;     // request 物件
	private HttpServletResponse response;   // response 物件

	
	
	public void setServletContext(ServletContext application) {
      this.application = application;		
	}

	public void setSession(Map sessionValues) {
      this.session = sessionValues;
	}

	public void setServletRequest(HttpServletRequest request) {
	  this.request = request;
	}

	public void setServletResponse(HttpServletResponse response) {
      this.response = response;
	}

	
	
	
    // 主方法
	public String execute(){
	  
	  System.out.println("********************************************");
	  System.out.println(ServletAwareAction.class.getName());
	  System.out.println("application.getRealPath('upload') = "+application.getRealPath("upload"));	
	  System.out.println("session.get('account')            = "+session.get("account"));  
	  System.out.println("request.getRemoteAddr()           = "+request.getRemoteAddr());
	  System.out.println("response.getContentType()         = "+response.getContentType());
	  System.out.println("********************************************");
	  
	  return Action.SUCCESS;
	} // end  execute()
		
		
  	
  	
}
