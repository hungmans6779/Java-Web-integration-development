package com.helloweenvsfei.struts2.action.tags.UITag;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

@Namespace(value="/tags")
@Action(value="optiongroupTag",results={
  @Result(name="success",location="/form/tags/UITag/optiongroupTag.jsp")		
})
public class OptgroupAction {

	
	
  // 一級資料放到 List 中	
  private List<String> cityList = new ArrayList<String>(){
	{
	  add("北京");  // 增加資料	  
	  add("上海");  // 增加資料
	  add("天津");  // 增加資料
	  add("重慶");  // 增加資料
	}
  }; // end private List<String> cityList
  
  
  // 二級資料放到 Map 中	
  private Map<String,HashMap<String,String>> provinceMap = new HashMap<String,HashMap<String,String>>(){
	{
		
	  put("山東",new HashMap(){
		{
		  put("濟南","濟南");	// 增加資料	 
		  put("青島","青島");	// 增加資料	   
		  put("煙台","煙台");	// 增加資料	   
		  put("淄博","淄博");	// 增加資料	   
		  put("濰坊","濰坊");	// 增加資料	   
		}
	  });
	 
	  put("河北",new HashMap(){
		{
		  put("石家莊","石家莊");    // 增加資料	
		  put("唐山","唐山");        // 增加資料	
		  put("滄州","滄州");        // 增加資料	
		  put("邯鄲","邯鄲");        // 增加資料	
		}
	  });
	  
	} // end 
	
  }; // end private Map<String,HashMap<String,String>> provinceMap 

  

  // 主方法  
  public String execute(){
	System.out.println(OptgroupAction.class.getName()+",execute().....");
	
	return "success";
  } // end execute()
  
  
  
  
  
  public List<String> getCityList() {
	return cityList;
  }

  public void setCityList(List<String> cityList) {
	this.cityList = cityList;
  }

  public Map<String, HashMap<String, String>> getProvinceMap() {
	return provinceMap;
  }

  public void setProvinceMap(Map<String, HashMap<String, String>> provinceMap) {
	this.provinceMap = provinceMap;
  }
	
  
  
}
