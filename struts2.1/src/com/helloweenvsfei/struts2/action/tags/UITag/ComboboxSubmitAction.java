package com.helloweenvsfei.struts2.action.tags.UITag;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

@Namespace(value="/tags")
@Action(value="comoboboxSubmmit",
  results={
	@Result(name="success",location="/form/tags/UITag/comboboxTagSuccess.jsp")	
})
public class ComboboxSubmitAction {

  private String favourite;

  
  public String execute(){
	System.out.println(ComboboxSubmitAction.class.getName()+",execute()...");
	
	System.out.println("favourite = "+favourite);
	
	return "success";
  } // end execute()
  
  
  
  public String getFavourite() {
	return favourite;
  }

  public void setFavourite(String favourite) {
	this.favourite = favourite;
  }
  
  
}
