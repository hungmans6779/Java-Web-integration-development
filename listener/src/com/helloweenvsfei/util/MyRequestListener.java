package com.helloweenvsfei.util;

import javax.servlet.ServletRequestEvent;

import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class MyRequestListener implements ServletRequestListener {

	// 銷毀request 時呼叫
	public void requestDestroyed(ServletRequestEvent event) {
	}

	
	// 建立request 時呼叫
	public void requestInitialized(ServletRequestEvent event) {

		HttpServletRequest request = (HttpServletRequest) event.getServletRequest();
		HttpSession session = request.getSession(true);

		// 記錄IP地址
		session.setAttribute("ip", request.getRemoteAddr());

		// 記錄存取次數，只記錄存取 .html, .do, .jsp, .action 的累計次數
		String uri = request.getRequestURI();
		String [] suffix = {".html", ".do", ".jsp", ".action" };
		for(int i=0; i<suffix.length;i++){
		  if(uri.endsWith(suffix[i])) {
			break;
		  }
		  if(i == suffix.length-1){
			return;
		  }	
		}

		Integer activeTimes = (Integer) session.getAttribute("activeTimes");
		if(activeTimes == null) {
		  activeTimes = 0;
		}
		session.setAttribute("activeTimes", activeTimes + 1);
	}
	
	
}
