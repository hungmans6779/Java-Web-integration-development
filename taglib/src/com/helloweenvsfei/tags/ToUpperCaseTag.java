package com.helloweenvsfei.tags;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ToUpperCaseTag extends SimpleTagSupport{

	public ToUpperCaseTag() {
		// TODO Auto-generated constructor stub
	}
	
	public void doTag() throws IOException,JspException{
		
      StringWriter writer=new StringWriter(); // 將標籤體內容寫入該writer
      JspFragment jspFragment=this.getJspBody(); // 標籤體為JspFragment 
      jspFragment.invoke(writer); // 透過 invoke 輸出到指定的writer 中，如果參數為null ，將輸出到預設中的writer中
      
      String content=writer.getBuffer().toString();  // 標籤體內容
      this.getJspContext().getOut().print(content.toUpperCase());
      
	}

}
