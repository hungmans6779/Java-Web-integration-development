package com.helloweenvsfei.struts2.action.tags.controlTags;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.util.SubsetIteratorFilter;
import org.apache.struts2.util.SubsetIteratorFilter.Decider;


import com.opensymphony.xwork2.ActionSupport;


@Namespace(value="/tags")
@Action(value="subsetTag",
        results={
		@Result(name="success",location="/form/tags/controlTag/subsetTag.jsp")
       }		
)
public class SubsetAction extends ActionSupport {

  private List<String> maleList = new ArrayList<String>(){
	{
	  add("kevin");
	  add("自由人");
	  add("Other");
	  add("喵喵");
	}
  }; 
  
  
  
  // 匿名類別
  private Decider decider = new Decider(){
	 
    // 覆蓋原來的方法
	public boolean decide(Object obj) throws Exception{
	  if(obj instanceof String){
	    if(obj.equals("Other")){   // 如果是 Other時，則過濾掉
		  return false;  
	    }else{
		  return true;  
	    }
	  
	  } // end  if(obj instanceof String){
	  return false;
    }
  }; // end  private Decider decider = new Decider(){


  
  public String execute(){
	System.out.println(SubsetAction.class.getName()+",execute()...");
	System.out.println("maleList sizer = "+maleList.size());
	
	return "success";  
  }
  
  

  public List<String> getMaleList() {
	return maleList;
  }



  public void setMaleList(List<String> maleList) {
	this.maleList = maleList;
  }



  public Decider getDecider() {
	return decider;
  }



  public void setDecider(Decider decider) { 
	this.decider = decider;
  }
  
  
  
  
  
  	
}
