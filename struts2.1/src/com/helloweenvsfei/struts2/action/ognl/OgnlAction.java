package com.helloweenvsfei.struts2.action.ognl;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import com.helloweenvsfei.struts2.action.bean.Magazine;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class OgnlAction extends ActionSupport implements ServletRequestAware,SessionAware,ServletContextAware {

	
	private ServletContext application;
	private Map <String,Object> session;
	private HttpServletRequest request;


	public void setServletContext(ServletContext application) {
	  this.application=application;
	}
	
	@SuppressWarnings("all")
	public void setSession(Map<String, Object> session) {
	  this.session=session;
	}

	public void setServletRequest(HttpServletRequest request) {
	  this.request=request;
	}
	

	
	
	@SuppressWarnings("all")
	private List <Magazine> magazineList= new ArrayList<Magazine>(){
	  { 
		 add(new Magazine("時代周刊",10));
		 add(new Magazine("足球之夜",19));
		 add(new Magazine("時尚",20));
		 add(new Magazine("時代影視",50));
	  }
	};

	
	/**
	 * @return the managineList
	 */
	public List<Magazine> getMagazineList() {
		return magazineList;
	}


	/**
	 * @param managineList the managineList to set
	 */
	public void setMagazineList(List<Magazine> magazineList) {
		this.magazineList = magazineList;
	}
	
	
	
	
	public String execute() {
	  System.out.println(OgnlAction.class.getName()+",execute()......");

	  request.setAttribute("account", "account from request");
	  session.put("account", "account from session");
	  application.setAttribute("account", "account from application");
	  return Action.SUCCESS;
	} // end  execute()
	
	
}
