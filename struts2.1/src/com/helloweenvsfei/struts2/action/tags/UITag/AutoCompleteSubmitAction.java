package com.helloweenvsfei.struts2.action.tags.UITag;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

@Namespace(value="/tags")
@Action(value="autocompleteTagSubmit",results={
  @Result(name="success",location="/form/tags/UITag/autocompleteTagSuccess.jsp")
})
public class AutoCompleteSubmitAction extends ActionSupport {
 
  private String province1;
  private String province2;
  
  
  public String execute(){
	System.out.println(AutoCompleteSubmitAction.class.getName()+",execute().....");
	System.out.println("province1 = "+province1);
	System.out.println("province2 = "+province2);
	
	return "success";  
  } // end execute()
  
  
  public String getProvince1() {
	return province1;
  }
  
  public void setProvince1(String province1) {
	this.province1 = province1;
  }
  
  public String getProvince2() {
	return province2;
  }
  
  public void setProvince2(String province2) {
	this.province2 = province2;
  }
    
}
