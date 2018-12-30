package com.helloweenvsfei.struts2.action.tags.NonUITag;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;


@Namespace(value="/tags")
@Action(value="tabbedPanelTag",
   results={
     @Result(name="input",location="/form/tags/NonUITag/tabbedPanelTag.jsp")
})
public class TabbedPanelAction extends ActionSupport {
	
  public String execute(){
	System.out.println(TabbedPanelAction.class.getName()+" , execute()...");
	
	return "input";
  } // end  public String execute()
  
}
