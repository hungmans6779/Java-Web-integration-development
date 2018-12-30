package com.helloweenvsfei.struts2.action;

import java.sql.Date;
import java.sql.Time;

import com.opensymphony.xwork2.ActionSupport;


/*
 *  Struts2.x 中每個 Action 實例會被反覆使用。而 Struts 2 中每個 Action 都會有多個實例，處理一次請求產生一個實例，
 *  這些實例彼此獨立，處理完畢即銷毀。
 *  所以 Struts 2 是執行緒安全的。由於 Action 中沒有其他特殊資源，使用完畢後便被直接拋棄，而不會造成浪費。
 *  
 *  ActionSupport 中實現了其他的方法，例如資料驗證等，繼承 ActionSupport 的好處是可以直接使用資料驗證等  Struts2 整合方法。
 */
public class ConvertorAction extends ActionSupport {

	private Date sqlDate;
	private Time sqlTime;
	private java.util.Date utilDate;

	
	
	// 主方法
	public String execute(){
	  System.out.println(ConvertorAction.class.getName()+",execute().....");
		
	  return INPUT;
	} // end execute()
	
	
	
	
	public String convert(){
	  System.out.println(ConvertorAction.class.getName()+",convert().....");
	  
	  return SUCCESS;	
	} // end convert()
	
	
	
	
	
	
	
	
	
	public Date getSqlDate() {
		return sqlDate;
	}

	public void setSqlDate(Date sqlDate) {
		this.sqlDate = sqlDate;
	}

	public Time getSqlTime() {
		return sqlTime;
	}

	public void setSqlTime(Time sqlTime) {
		this.sqlTime = sqlTime;
	}

	public java.util.Date getUtilDate() {
		return utilDate;
	}

	public void setUtilDate(java.util.Date utilDate) {
		this.utilDate = utilDate;
	}

	
}