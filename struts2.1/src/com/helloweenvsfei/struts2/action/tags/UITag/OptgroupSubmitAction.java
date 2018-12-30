package com.helloweenvsfei.struts2.action.tags.UITag;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

@Namespace(value="/tags")
@Action(value="optiongroupSubmmit",
  results={
	@Result(name="success",location="/form/tags/UITag/optiongroupTagSuccess.jsp")	
})
public class OptgroupSubmitAction {

  private String city;
  
  public String execute(){
	System.out.println(OptgroupSubmitAction.class.getName()+",execute().....");
	
	System.out.println("city = "+city);
	
	return "success";
  } // end execute()

  
  
  
  
  public String getCity() {
	return city;
  }

  public void setCity(String city) {
	this.city = city;
  }
  

	
}
