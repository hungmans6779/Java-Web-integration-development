package com.helloweenvsfei.tags;

import java.util.ResourceBundle;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

public class Copyright implements Tag {

	
	private Tag parent;               // 父標籤，本例中沒有用到
	private PageContext pageContext;  // JSP內容
	
	
	// 標籤開始執行
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		return SKIP_BODY;
	}

	// 標籤結束執行
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		
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


	public Tag getParent() {
		// TODO Auto-generated method stub
		return this.parent;
	}

	public void release() {
		// TODO Auto-generated method stub
	}

	public void setPageContext(PageContext pageContext) {
		// TODO Auto-generated method stub
      this.pageContext=pageContext;
	}

	public void setParent(Tag parent) {
		// TODO Auto-generated method stub
      this.parent=parent;
	}

}
