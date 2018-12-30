package com.helloweenvsfei.struts2.action.tags.UITag;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

@Namespace(value="/tags")
@Action(value="addBookForm",
        results={
          @Result(name="success",location="/form/tags/UITag/addBookSuccess.jsp")
})
public class addBookFormAction {
  
  private String name;
  private String author;
  
  public String execute(){
	System.out.println(addBookFormAction.class.getName()+",execute().....");
	System.out.println("name   = "+name);
	System.out.println("author = "+author);
	
	return "success";  
  }

  public String getName() {
	return name;
  }

  public void setName(String name) {
	this.name = name;
  }

  public String getAuthor() {
	return author;
  }

  public void setAuthor(String author) {
	this.author = author;
  }
  
  

  
  
  
}
