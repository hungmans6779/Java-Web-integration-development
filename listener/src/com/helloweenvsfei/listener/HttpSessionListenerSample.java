package com.helloweenvsfei.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.sun.org.apache.commons.logging.Log;
import com.sun.org.apache.commons.logging.LogFactory;
             
public class HttpSessionListenerSample implements HttpSessionListener{
	Log log = LogFactory.getLog(getClass());
	
	public void sessionCreated(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		log.info("新建立一個session,ID 為" + session.getId());
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		log.info("銷毀一個session,ID 為" + session.getId());
	}
}
