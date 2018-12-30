package com.helloweenvsfei.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import com.sun.org.apache.commons.logging.Log;
import com.sun.org.apache.commons.logging.LogFactory;

public class SessionAttributeListenerSample implements HttpSessionAttributeListener {

	Log log = LogFactory.getLog(getClass());


	  public void attributeAdded(HttpSessionBindingEvent se){
		HttpSession session=se.getSession();  // 發生變化的session
		String name=se.getName();             // 新增加的屬性名
		Object value=se.getValue();           // 新增加的屬性值
		log.info("新增 session 屬性:"+name+",值為:"+value);
	  }
	  
	  

	  public void attributeRemoved(HttpSessionBindingEvent se){
		HttpSession session=se.getSession();  // 發生變化的session
		String name=se.getName();             // 即將刪除的屬性名
		Object value=se.getValue();           // 即將刪除的屬性值
		log.info("刪除 session 屬性:"+name+",值為:"+value);
	  }


	  
	  public void attributeReplaced(HttpSessionBindingEvent se){
		HttpSession session=se.getSession();        // 發生變化的session
		String name=se.getName();                   // 發生修改的屬性名
		Object oldValue=se.getValue();              // 原來的屬性值
		Object newVale=session.getAttribute(name);  // 新的屬性值
		log.info("修改 session 屬性:"+name+",原值為:"+oldValue+",新值:"+newVale);
	  }
	  
	  
}
