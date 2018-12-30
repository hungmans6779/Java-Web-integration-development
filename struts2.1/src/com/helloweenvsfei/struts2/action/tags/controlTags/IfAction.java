package com.helloweenvsfei.struts2.action.tags.controlTags;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;


@Namespace(value="/tags")
@Action(value="ifTag",
		results={
          @Result(name="success",location="/form/tags/controlTag/ifTag.jsp")
        }
)
public class IfAction extends ActionSupport{

	private String name;

	// ¥D¤èªk
	public String execute(){
	  System.out.println(IfAction.class.getName()+",execute()...");
	  System.out.println("name = "+name);
	  
	  return SUCCESS;
	} // end execute()
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}