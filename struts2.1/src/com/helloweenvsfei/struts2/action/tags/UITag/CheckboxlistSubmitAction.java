package com.helloweenvsfei.struts2.action.tags.UITag;

import java.util.Arrays;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

@Namespace(value="/tags")
@Action(value="checkboxlistSubmmit",
  results={
	@Result(name="success",location="/form/tags/UITag/checkboxlistTagSuccess.jsp")	
})
public class CheckboxlistSubmitAction extends ActionSupport {

  private String [] favourite;
  
  // ¥D¤èªk
  public String execute(){
	System.out.println(CheckboxlistSubmitAction.class.getName()+",execute().....");
	System.out.println("favourite = "+Arrays.toString(favourite));
	
	return "success";
  } // end execute()

  
  
  
  public String[] getFavourite() {
	return favourite;
  }

  public void setFavourite(String[] favourite) {
	this.favourite = favourite;
  }
  
  
  
}
