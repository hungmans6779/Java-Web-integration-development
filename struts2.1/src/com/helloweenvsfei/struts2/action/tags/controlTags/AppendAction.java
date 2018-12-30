package com.helloweenvsfei.struts2.action.tags.controlTags;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;


@Namespace(value = "/tags")
@Action(value = "appendTag",
		results = { 
		  @Result(name = "success", location = "/form/tags/controlTag/appendTag.jsp") 
		}
)
@SuppressWarnings("all")
public class AppendAction extends ActionSupport {

	private List<String> maleList = new ArrayList<String>() {
		{
			add("kevin");
			add("kent");
			add("vicent");
		}
	};

	private List<String> femaleList = new ArrayList<String>(){
		{
			add("lynn");
			add("jessie");
		}
	};
	
	
	
	// ¥D¤èªk
	public String execute() {
		System.out.println(AppendAction.class.getName() + ",execute()...");
		// System.out.println("maleList size = " + maleList.size());
		// System.out.println("femaleList size = " + femaleList.size());
		
		return SUCCESS;
	} // end execute

	
	
	
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
