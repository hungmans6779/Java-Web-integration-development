package com.helloweenvsfei.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class toLowerCaseTag extends BodyTagSupport {

	public toLowerCaseTag() {
		// TODO Auto-generated constructor stub
	}
	
	public int doEndTag() throws JspException{
	
		try{
		  String content=this.getBodyContent().getString();
		  this.pageContext.getOut().println(content.toLowerCase());
		}catch(Exception e){}
		return EVAL_PAGE;
	}
	
	

}
