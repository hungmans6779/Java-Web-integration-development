package com.helloweenvsfei.struts2.action.tags.UITag;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;


@Namespace(value="/tags")
@Action(value="doubleselectSubmmit",
  results={
	@Result(name="success",location="/form/tags/UITag/doubleselectTagSuccess.jsp")	
})
public class DoubleselectSubmitAction {

  private String province;   // 省
  private String city;       // 市
  
  // 主方法
  public String execute(){
	System.out.println(DoubleselectSubmitAction.class.getName()+",execute()...");
	
	System.out.println("省:province = "+province);
	System.out.println("市:city     = "+city);
	
	return "success";
  } // execute

  
  
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
