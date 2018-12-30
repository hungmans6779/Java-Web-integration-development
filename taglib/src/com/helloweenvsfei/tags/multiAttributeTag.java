package com.helloweenvsfei.tags;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class multiAttributeTag extends SimpleTagSupport{

	public multiAttributeTag() {
		// TODO Auto-generated constructor stub
	}

	private JspFragment body1;
	private JspFragment body2;
	/**
	 * @return the body1
	 */
	public JspFragment getBody1() {
		return body1;
	}
	/**
	 * @param body1 the body1 to set
	 */
	public void setBody1(JspFragment body1) {
		this.body1 = body1;
	}
	/**
	 * @return the body2
	 */
	public JspFragment getBody2() {
		return body2;
	}
	/**
	 * @param body2 the body2 to set
	 */
	public void setBody2(JspFragment body2) {
		this.body2 = body2;
	}
	
	
	public void doTag() throws JspException,IOException{
		
	  StringWriter writer1=new StringWriter();	
	  StringWriter writer2=new StringWriter();	
	  
	  for(int i=0;i<5;i++){
		body1.invoke(writer1);  
	  }
	 
	  for(int i=0;i<3;i++){
		body2.invoke(writer2);  
	  }
	  
	  this.getJspContext().getOut().print("5 次呼叫 body1 後的結果："+writer1.getBuffer().toString()+"<br><br>");
	  
	  this.getJspContext().getOut().print("3 次呼叫 body2 後的結果："+writer2.getBuffer().toString()+"<br><br>");
	  
	}
	
	
	
}
