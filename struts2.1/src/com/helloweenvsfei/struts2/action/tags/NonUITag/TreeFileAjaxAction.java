package com.helloweenvsfei.struts2.action.tags.NonUITag;

import java.io.File;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import com.helloweenvsfei.struts2.action.bean.FileWrapper;


@Namespace(value="/tags")
@Action(value="treeFileAjax",
  results={
    @Result(name="input",location="/form/tags/NonUITag/treeFileAjax.jsp")		
})
public class TreeFileAjaxAction implements ServletContextAware,SessionAware,ServletRequestAware,ServletResponseAware{

  private ServletContext application;    // Servlet 上下文
  private Map session;                   // session 物件
  private HttpServletRequest request;    // request 物件
  private HttpServletResponse response;  // response 物件

  
  public void setServletContext(ServletContext application) {
    this.application = application;
  }

  
  public void setSession(Map<String, Object> session) {
    this.session = session;
  }

  public void setServletRequest(HttpServletRequest request) {
    this.request = request;
  }

  
  public void setServletResponse(HttpServletResponse response) {
    this.response = response;
  }



  // 主方法
  public String execute(){
	String path = application.getRealPath("");
	System.out.println("path = "+path);
	
	request.setAttribute("file",new FileWrapper(new File(path)));
	
	return "input";  
  } // end execute()
	
  
}
