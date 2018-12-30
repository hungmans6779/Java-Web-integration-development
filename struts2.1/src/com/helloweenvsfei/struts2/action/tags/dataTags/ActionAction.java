package com.helloweenvsfei.struts2.action.tags.dataTags;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;



@Namespace(value="/tags")
@Action(value="actionTag",
        results={
		  @Result(name="success",location="/form/tags/dataTag/actionTag.jsp"),
		  @Result(name="login",location="/form/tags/dataTag/login.jsp")
       }
)
public class ActionAction extends ActionSupport {
 	
  public String execute(){
	return "success";
  }
  
}
