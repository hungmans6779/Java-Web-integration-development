package com.helloweenvsfei.tags;

import java.util.ResourceBundle;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class Copyright2 extends TagSupport{
 
	
	public int doEndTag() throws JspException{
	   
		JspWriter out=pageContext.getOut();
		try{
		  out.println("<div align=center style='line-height:22px;font-size:12px;' >");
		  out.println(ResourceBundle.getBundle("copyright").getString("copyright"));
		  out.println("</div>");
		}catch(Exception e){
		  throw new JspException(e);
		}
	
		
		return EVAL_PAGE;
    }
  
	
}
