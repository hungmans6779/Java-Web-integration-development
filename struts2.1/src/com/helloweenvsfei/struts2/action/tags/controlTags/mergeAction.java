package com.helloweenvsfei.struts2.action.tags.controlTags;

import java.util.ArrayList;
import java.util.List;


import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

@Namespace("/tags")
@Action(value="mergeTag",
        results={
		  @Result(name="success",location="/form/tags/controlTag/mergeTag.jsp")
       })
public class mergeAction extends ActionSupport{

  private List<String> maleList = new ArrayList<String>(){
	  {
		add("1-1.kevin");
		add("1-2.¦Û¥Ñ¤H");
		add("1-3.ØpØp");
	  }
  };
	
  
  private List<String> femaleList = new ArrayList<String>(){
	{
	  add("2-1.«½«½³½");
	  add("2-2.¤p¤¡³½");
	  add("2-3.³½³½");
	}
  };


  public List<String> getMaleList() {
	return maleList;
  }


  public void setMaleList(List<String> maleList) {
	this.maleList = maleList;
  }


  public List<String> getFemaleList() {
	return femaleList;
  }


  public void setFemaleList(List<String> femaleList) {
	this.femaleList = femaleList;
  }
  
	
  
  
  
}
