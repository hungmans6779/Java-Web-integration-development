package com.helloweenvsfei.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListenerTest implements HttpSessionListener{

  public void sessionCreated(HttpSessionEvent se){
	HttpSession session =se.getSession();
	System.out.println("新建立了一個 session:"+session);  
  }
  
  public void sessionDestroyed(HttpSessionEvent se){
	HttpSession session =se.getSession();
    System.out.println("銷毀了一個 session:"+session);    
  }
  
}
