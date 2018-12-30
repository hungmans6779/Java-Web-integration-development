package com.helloweenvsfei.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class HelloTag extends TagSupport {
  
	private String name;
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	public int doEndTag() throws JspException{	
		try{
		  pageContext.getOut().println("Hello "+name);	
		}catch(Exception e){
		  throw new JspException(e);
		}
		return EVAL_PAGE;
	}
	
	

	
	
  	 
}
