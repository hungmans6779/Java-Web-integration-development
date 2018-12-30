package com.helloweenvsfei.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

import com.sun.org.apache.commons.logging.Log;
import com.sun.org.apache.commons.logging.LogFactory;

public class ServletRequestListenerSample implements ServletRequestListener{
	Log log = LogFactory.getLog(getClass());
	

	public void requestInitialized(ServletRequestEvent sre) {
		HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
		String uri = request.getRequestURI();
		uri = request.getQueryString() == null ? uri : (uri + "?" + request.getQueryString());
		request.setAttribute("dateCreated", System.currentTimeMillis());
		log.info("IP" + request.getRemoteAddr() + " 請求 " + uri);
	}

	public void requestDestroyed(ServletRequestEvent sre) {
		HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
		long time = System.currentTimeMillis()- (Long) request.getAttribute("dateCreated");
		log.info(request.getRemoteAddr() + " 請求處理結束,用時" + time + "亳秒.");
	}

}
