package com.helloweenvsfei.struts2.action.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/*
    自訂的許可權驗證攔截器
    攔截器可以自由擴充。所有的攔截器都實現自Interceptor 介面。實現自訂攔截器也要實現 Interceptor 介面。
    一般直接繼承 AbstractInterceptor 描象類別即可。    
 */
public class AuthenticationInterceptor extends AbstractInterceptor{

	
	@Override
	@SuppressWarnings("all")
	public String intercept(ActionInvocation invocation) throws Exception {
		
	  // 透過 invocation 獲得本次呼叫的上下文
	  Map<String,Object> sessionValues = invocation.getInvocationContext().getSession();
	  
	  String account = (String) sessionValues.get("account");
	  System.out.println("kevintest account = "+account);
	  
	  
	  if(account==null){
		return "globalLogin";
	  }
	  
	  return invocation.invoke();  // 否則，正常執行
	} // end public String intercept(ActionInvocation invocation) 

	
	
	
	@Override
	public void destroy() {
	  super.destroy();
	}

	
	@Override
	public void init() {
	  super.init();
	}


  	
}
