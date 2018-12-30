/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.helloweenvsfei.struts.action;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

/** 
 * MyEclipse Struts
 * Creation date: 09-11-2012
 * 
 * XDoclet definition:
 * @struts.action path="/dyna" name="dynaForm" input="/form/dyna.jsp" scope="request" validate="true"
 */
public class DynaAction extends Action {
	/*
	 * Generated Methods
	 */

	
	
	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response) {
	  DynaActionForm dynaForm = (DynaActionForm) form;
	
	  // get("xxx") �Ǧ^���OObject �����A�ھڰt�m�j����Ƭ������������Y�i...
	  
	  
	  String name =(String)dynaForm.get("name");       // ��o String ����
	  Integer age = (Integer)dynaForm.get("age");      // ��o Integer ����
	  Date birthday = (Date)dynaForm.get("birthday");  // ��o Date ����
	
	  System.out.println("***************************************");
	  System.out.println(DynaAction.class.getName());
	  System.out.println("01.name     = "+name);
	  System.out.println("02.age      = "+age);
	  System.out.println("03.birthday = "+birthday);
	  System.out.println("***************************************");
	  
	  
	  return mapping.getInputForward();  // �Ǧ^��J����  
	} // end execute
	
	
	
}