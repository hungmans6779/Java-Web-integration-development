package com.helloweenvsfei.struts2.action.tags.UITag;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;


@Namespace(value="/tags")
@Action(value="optiontransferselectTag",results={
  @Result(name="success",location="/form/tags/UITag/optiontransferselectTag.jsp")		
})
public class OptiontransferselectAction extends ActionSupport {

  // 勾選的省份的List
  private List<String> provinceSelected = new ArrayList<String>(){
	{
	  add("北京");  // 增加資料	  
	  add("上海");  // 增加資料
	  add("天津");  // 增加資料
	  add("重慶");  // 增加資料
	  add("河北");  // 增加資料
	  add("河南");  // 增加資料
	  add("山東");  // 增加資料
	  add("山西");  // 增加資料
	  add("江蘇");  // 增加資料
	  add("浙江");  // 增加資料
	}
  }; // end private List<String> provinceSelected 
  
  
  
  // 沒有勾選的省份 List
  private List <String> provinceUnselected = new ArrayList<String>(){
	{
	  add("湖南");  // 增加資料	  
	  add("湖北");  // 增加資料	 
	  add("雲南");  // 增加資料	 
	  add("廣東");  // 增加資料	 
	  add("廣西");  // 增加資料	 
	}
  };  // end private List <String> provinceUnselected

  

  // 主方法
  public String execute(){
	System.out.println(OptiontransferselectAction.class.getName()+",execute()...");
	
	return "success"; 
  } // end execute()

  
  
  
  
  public List<String> getProvinceSelected() {
	return provinceSelected;
  }

  public void setProvinceSelected(List<String> provinceSelected) {
	this.provinceSelected = provinceSelected;
  }

  public List<String> getProvinceUnselected() {
	return provinceUnselected;
  }

  public void setProvinceUnselected(List<String> provinceUnselected) {
	this.provinceUnselected = provinceUnselected;
  }
  
  
  
  
	
}
