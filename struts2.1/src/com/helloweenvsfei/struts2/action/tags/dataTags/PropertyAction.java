package com.helloweenvsfei.struts2.action.tags.dataTags;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

@Namespace(value="/tags")
@Action(value="propertyTag",
results={
	@Result(name="success",location="/form/tags/dataTag/propertyTag.jsp")	
})
public class PropertyAction extends ActionSupport {
  
  private String id;
  
  public String execute(){  
	System.out.println(PropertyAction.class.getName()+",execute()...") ;
	System.out.println("id = "+id);
	return "success";  
  }

  public String getId() {
	return id;
  }

  public void setId(String id) {
	this.id = id;
  }

 
}
