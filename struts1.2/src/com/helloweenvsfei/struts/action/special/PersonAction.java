package com.helloweenvsfei.struts.action.special;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.helloweenvsfei.struts.action.HelloAction;
import com.helloweenvsfei.struts.form.HelloForm;

public class PersonAction extends Action {

	
  public ActionForward execute(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response){

	System.out.println(PersonAction.class.getName()+" ActionForward execute() ！！！");
	 
	// 轉到 success 頁面，也就是 /form/special/PersonSuccess.jsp 頁面，設定在 struts-config.xml 中
	return mapping.findForward("success"); 
  } // end execute
  
}
