package com.helloweenvsfei.util;

import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.helloweenvsfei.util.ApplicationConstants;



public class MySessionListener implements HttpSessionListener,HttpSessionAttributeListener {


	// Session 建立時被呼叫
	public void sessionCreated(HttpSessionEvent sessionEvent) {

	  HttpSession session = sessionEvent.getSession();

	  // 將 session 放入 map
	  ApplicationConstants.SESSION_MAP.put(session.getId(), session);
		
	  // 總存取人數++
	  ApplicationConstants.TOTAL_HISTORY_COUNT++;

	  // 如果目前在線人數超過歷史記錄，則更新最大在線人數，並記錄時間
	  if (ApplicationConstants.SESSION_MAP.size() > ApplicationConstants.MAX_ONLINE_COUNT) {
		ApplicationConstants.MAX_ONLINE_COUNT = ApplicationConstants.SESSION_MAP.size();
		ApplicationConstants.MAX_ONLINE_COUNT_DATE = new Date();
	  }
	}
	
	
	
	
	
    // Session 銷毀時被呼叫
	public void sessionDestroyed(HttpSessionEvent sessionEvent) {
	  HttpSession session = sessionEvent.getSession();
	  // 將session從map中移除
	  ApplicationConstants.SESSION_MAP.remove(session.getId());
	}

	
	
	
	
	// 增加屬性時被呼叫
	public void attributeAdded(HttpSessionBindingEvent event) {
	  if(event.getName().equals("personInfo")) {
		// 目前登入使用者數++
		ApplicationConstants.CURRENT_LOGIN_COUNT++;
		HttpSession session = event.getSession();

		// 尋找該帳號有沒有在其他機器上登入
		for (HttpSession sess : ApplicationConstants.SESSION_MAP.values()) {
		  // 如果該帳號已經在其他機器上登入，則以前的登入失效
		  if (event.getValue().equals(sess.getAttribute("personInfo"))&& session.getId() != sess.getId()) {
			sess.invalidate();
		  }
		}
	  }
	}
	
	
	
	
	
	public void attributeReplaced(HttpSessionBindingEvent event) {
	  // 重新登入
	  if(event.getName().equals("personInfo")) {
		HttpSession session = event.getSession();
		for(HttpSession sess : ApplicationConstants.SESSION_MAP.values()) {
		  // 如果新帳號在其他機器上登入過，則以前登入失效
		  if (event.getValue().equals(sess.getAttribute("personInfo")) && session.getId() != sess.getId()) {
			sess.invalidate();
		  }
		}
	  }
	}
	
	
	
	
	 
    // 移除屬性時被呼叫
	public void attributeRemoved(HttpSessionBindingEvent event) {
	  // 註銷 目前登入使用者數--
	  if (event.getName().equals("personInfo")) {
		ApplicationConstants.CURRENT_LOGIN_COUNT--;
	  }
	}

	

	
	

}
