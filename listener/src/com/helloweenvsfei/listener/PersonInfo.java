package com.helloweenvsfei.listener;

import java.io.Serializable;
import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;

import com.sun.org.apache.commons.logging.Log;
import com.sun.org.apache.commons.logging.LogFactory;

public class PersonInfo implements HttpSessionActivationListener,
		HttpSessionBindingListener, Serializable {

	
	private static final long serialVersionUID=-4780592776386225973L;
	Log log=LogFactory.getLog(getClass());
	private String name;       // 人的名字
	private Date dateCreated;  // 建立的日期
	

	// 被放進 Session 前被呼叫
	public void valueBound(HttpSessionBindingEvent event) {
      HttpSession session=event.getSession();
      String name=event.getName();
      log.info(this+"被綁定到session \""+session.getId()+"\"的"+name+"屬性上");
      
      this.setDateCreated(new Date());
     
	}

	
	// 從 Session 中移除後被呼叫
	public void valueUnbound(HttpSessionBindingEvent event) {
	  HttpSession session=event.getSession();
	  String name=event.getName();
	  log.info(this+"被從 session \""+session.getId()+"\"的"+name+"屬性上移除");   
	}
	
	
	// 從硬碟後恢復後被呼叫
	public void sessionDidActivate(HttpSessionEvent se) {
      HttpSession session=se.getSession();
      log.info(this+"已經成功從硬碟從載入。sessionId:"+session.getId());
	}

	
	// 即將被鈍化到硬碟時被呼叫
	public void sessionWillPassivate(HttpSessionEvent se) {
      HttpSession session=se.getSession();
      log.info(this+"即將儲存到硬碟。sessionID:"+session.getId());
	}

	
	public String toString(){
	  return "PersonInfo("+name+")";	
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

}
