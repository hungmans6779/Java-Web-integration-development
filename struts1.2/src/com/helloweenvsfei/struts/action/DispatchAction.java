/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.helloweenvsfei.struts.action;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.helloweenvsfei.struts.form.DispatchForm;

/** 
 * MyEclipse Struts
 * Creation date: 09-10-2012
 * 
 * XDoclet definition:
 * @struts.action path="/dispatch" name="dispatchForm" input="/form/dispatch.jsp" scope="request" validate="true"
 */
public class DispatchAction extends org.apache.struts.actions.DispatchAction {
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
	public ActionForward execute(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response) throws Exception{
	  
	  // �@�w�n����o��{���X�A�����O�|�Q�ΤϮg�I�s������k�A�Ϊ̧� execute() ��k�h��
	  return super.execute(mapping, form, request, response); 
	} // end execute
	
	
	
	public ActionForward add(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception{
	  System.out.println("���� �F add ��k");
	  
	  return null;	
	} // end add
	
	
	
	public ActionForward list(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception{
	  System.out.println("���� �F list ��k");
		  
	  return null;	
	} // end list
	
	
	
	public ActionForward view(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception{
	  System.out.println("���� �Fview ��k");
	  
	  return null;	
	} // end view
	
	

	
	
}