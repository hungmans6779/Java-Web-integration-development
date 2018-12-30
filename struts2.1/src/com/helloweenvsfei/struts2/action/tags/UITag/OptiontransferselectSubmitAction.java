package com.helloweenvsfei.struts2.action.tags.UITag;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;


@Namespace(value="/tags")
@Action(value="optiontransferselectSubmmit",
  results={
	@Result(name="success",location="/form/tags/UITag/optiontransferselectTagSuccess.jsp")	
})
public class OptiontransferselectSubmitAction {

  private String province;
  private String city;
  
  public String execute(){
	System.out.println(OptiontransferselectSubmitAction.class.getName()+",execute()...");
	System.out.println("¬Ù¡Gprovince = "+province);
	System.out.println("¥«¡Gcity     = "+city);
	
	return "success";
  } // end execute()

  
  public String getProvince() {
	return province; 
  }

  public void setProvince(String province) {
	this.province = province;
  }

  public String getCity() {
	return city;
  }

  public void setCity(String city) {
	this.city = city;
  }
  
  
  
  
}
