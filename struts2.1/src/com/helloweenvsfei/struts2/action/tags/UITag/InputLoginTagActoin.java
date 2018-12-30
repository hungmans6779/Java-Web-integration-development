package com.helloweenvsfei.struts2.action.tags.UITag;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

@Namespace(value="/tags")
@Action(value="inputLoginTag",
        results={
		  @Result(name="success",location="/form/tags/UITag/inputTag.jsp"),
		  @Result(name="logout", location="/form/tags/UITag/logoutInputTag.jsp")
})
public class InputLoginTagActoin extends ActionSupport{

  private String textfield;    // 文字方塊
  private String password;     // 密碼域
  private String file;         // 檔案域
  private String sex;          // 單選框
  private String [] hobby;     // checkbox 
  
  
  
  public String execute(){
	System.out.println(InputLoginTagActoin.class.getName()+",execute()...");
	System.out.println("textfield = "+textfield);
	System.out.println("password  = "+password);
	System.out.println("file      = "+file);
	System.out.println("sex       = "+sex);
	System.out.println("hobby     = "+hobby);
	
	return "success";  
  } // end execute()

  
  

  public String logout(){
    System.out.println(InputLoginTagActoin.class.getName()+",logout()...");
	System.out.println("textfield = "+textfield);
	System.out.println("password  = "+password);
	System.out.println("file      = "+file);
	System.out.println("sex       = "+sex);
	System.out.println("hobby     = "+hobby);
		
	return "logout";  
  }
  
  
  public String getTextfield() {
	return textfield;
  }


  public void setTextfield(String textfield) {
	this.textfield = textfield;
  }


  public String getPassword() {
	return password;
  }


  public void setPassword(String password) {
	this.password = password;
  }


  public String getFile() {
	return file;
  }


  public void setFile(String file) {
	this.file = file;
  }


  public String getSex() {
	return sex;
  }


  public void setSex(String sex) {
	this.sex = sex;
  }


  public String[] getHobby() {
	return hobby;
  }


  public void setHobby(String[] hobby) {
	this.hobby = hobby;
  }
  
  
  
  

}
