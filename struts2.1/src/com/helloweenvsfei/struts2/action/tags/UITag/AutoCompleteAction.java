package com.helloweenvsfei.struts2.action.tags.UITag;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;

@Namespace(value="/tags")
@Action(value="autoCompleteTag",
  results={
	@Result(name="success",location="/form/tags/UITag/autocompleteTag.jsp")	
})
public class AutoCompleteAction extends ActionSupport implements ServletContextAware,SessionAware,ServletRequestAware,ServletResponseAware{

	
  private ServletContext application;     // Servlet 上下文
  private Map session;                    // session 物件
  private HttpServletRequest request;     // request 物件
  private HttpServletResponse response;   // response 物件
	
  public void setServletContext(ServletContext application) {
    this.application = application;		
  }

  public void setSession(Map sessionValues) {
    this.session = sessionValues;
  }

  public void setServletRequest(HttpServletRequest request) {
	  this.request = request;
  }

  public void setServletResponse(HttpServletResponse response) {
    this.response = response;
  }


  
  
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
	  add("浙江");  // 增加資料
	} 
  };
  
  
  
  // 主方法
  public String execute(){
	System.out.println(AutoCompleteAction.class.getName()+",execute()...");
	 
	request.setAttribute("provinceList1",provinceList);
	
	
	
	ServletContext application2 = ServletActionContext.getServletContext();
	HttpServletRequest request2 = ServletActionContext.getRequest();
	HttpServletResponse response2 = ServletActionContext.getResponse();
	HttpSession session1 = request2.getSession(true);
	request2.setAttribute("provinceList2",provinceList);
	
	
	
	return "success";
  } // end execute()

  
  
  
  


  public List<String> getProvinceList() {
	return provinceList;
  }

  public void setProvinceList(List<String> provinceList) {
	this.provinceList = provinceList;
  }
 
 
  
  
  
  
  
}
