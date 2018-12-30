package com.helloweenvsfei.struts2.action.tags.UITag;

import java.util.Date;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

@Namespace(value="/tags")
@Action(value="datetimepickerSubmit",
  results = {
    @Result(name="success",location="/form/tags/UITag/datetimepickerTagSuccess.jsp")	
})
public class DatetimepickerSubmitAction {
  
  private Date date;
  
  public String execute(){
	System.out.println(DatetimepickerSubmitAction.class.getName()+",execute()...");
	
	System.out.println("date = "+date);
	  
	return "success";
  } // end execute()

  
  
  public Date getDate() {
	return date;
  }

  public void setDate(Date date) {
	this.date = date;
  }

  

  
  
  
  
  
  
	
}
