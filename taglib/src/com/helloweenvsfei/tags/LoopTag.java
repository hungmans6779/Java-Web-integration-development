package com.helloweenvsfei.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class LoopTag extends BodyTagSupport {

	public LoopTag() {
		// TODO Auto-generated constructor stub
	}
	
	private int times;
	
	public int doStartTag() throws JspException{
		times=5;
		return super.doStartTag();
	}
	
	
	public int doAfterBody() throws JspException{
		
	  if(times-- >0){
		  try{
			this.getPreviousOut().print(this.getBodyContent().getString()+"<br>");  
		  }catch(Exception e){}
		  return EVAL_BODY_AGAIN;
	  }else{
		  return SKIP_BODY;
	  }
	}

}
