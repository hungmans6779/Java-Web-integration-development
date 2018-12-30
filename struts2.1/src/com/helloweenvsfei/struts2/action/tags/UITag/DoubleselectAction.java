package com.helloweenvsfei.struts2.action.tags.UITag;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

@Namespace(value="/tags")
@Action(value="doubleselectTag",
  results={
	@Result(name="success",location="/form/tags/UITag/doubleselectTag.jsp")	
})
public class DoubleselectAction {
	
  // List 物件
  private List <String> provinceList = new ArrayList<String>(){
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
	  add("淅江 ");  // 增加資料
	}
  }; // end List <String> provinceList
  
  
  
  // Map 物件
  private Map<String,List<String>> cityMap = new HashMap<String,List<String>>(){
	{
		
      // 放到 map 物件中
	  put("北京",new ArrayList<String>(){
		{
		  add("東城區");
		  add("西城區");
		  add("海澱區");
		  add("朝陽區");
		}
	  });
	  
	  // 放到 map 物件中
	  put("山東",new ArrayList<String>(){
		{
		  add("青島");  
		  add("濟南");
		  add("濰坊");
		  add("煙台");
		  add("淄博");	  
		}
	  });

	}
	
  }; // end Map<String,List<String>> cityMap 
  
  
  
  
  
  // 主方法
  public String execute(){
	System.out.println(DoubleselectAction.class.getName()+",execute().....");
	
	return "success";
  } // end execute()



  

  public List<String> getProvinceList() {
	return provinceList;
  }

  public void setProvinceList(List<String> provinceList) {
	this.provinceList = provinceList;
  }

  public Map<String, List<String>> getCityMap() {
	return cityMap;
  }

  public void setCityMap(Map<String, List<String>> cityMap) {
	this.cityMap = cityMap;
  }
  

  
  
  
  
  
}
