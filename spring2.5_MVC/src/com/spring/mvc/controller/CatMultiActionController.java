package com.spring.mvc.controller;

import java.util.Date;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.spring.orm.entity.Cat;
import com.spring.orm.service.ICatService;


/*
 *  多業務分發器
 *  
 *  如果要用一個 Controller 處理多個業務邏輯，可以使用 org.springframework.web.servlet.mvc.multiaction.MultiActionController 。
 *  MultiActionController 是個分發器，相當於 Struts1.x 的 DispatcherAction ，能根據某參數值(例如 action 參數) 將不同的請求分發到不同的方法上。
 * 
 * 
 * 
 *  Spring 控制層
 *  
 *  
 *  Spring MVC 裡使用 Controller 處理使用的請求。 
 *  Controller 相當於 Struts1.x 裡的 Action ，它們實現機制、執行原理都類似。
 *  
 *  
 *  Spring MVC 的控制層是 Contoller 。Controller 是個介面，一般直接繼承 org.springframework.web.servlet.mvc.AbstractController，
 *  並實現 handleRequestInternal 方法。 handleRequestInternal 方法相當於 Struts1.x  Action 的 execute() 方法。
 *  
 *  
 *  Spring MVC 的優缺點
 *   
 *  作為 Spring 的一部份，Controller 具有天然的優勢，不需像 Struts1 & 2 的 Action 那樣特意整合就能融入 Spring 程式 Framework 中。
 *  catService 使用 IoC 植入到 Controller 中。 
 *   
 *  handleRequestInternal 方法參數為 request、response ，這樣可以從 request 中獲得資料，跟 Servlet 一樣操作。 
 *  
 *  
 *
 *  
 *  
 *  Spring MVC 獨特的地方在於 View 層的處理上。 handleRequestInternal 傳回 ModelAndView 物件，相當於 Struts1.x 裡的 ActionForward。
 * 
 *  ● ModelAndView：
 *     其可以看做是對JSP 物件的封裝。ModelAndView 直接接受JSP 頁面的路徑，例如 new ModelAndView("cat/list")。
 *     參數 "cat/list" 只是 JSP 路徑的一部份，完整的路徑為 "/WEB-INF/jsp/cat/listCat.jsp" ，路徑的前後部份是設定在設定檔中。 
 *     
 *  ● 傳遞參數：
 *     除了指定 JSP 路徑， ModelAndView 還可以直接傳遞 Model 物件到 View 層，而不用先放到 request 中。
 *     例如 new ModelAndView("cat/listCat","cat",cat) ，
 *     等於 
 *     request.setAttribute("cat",cat);
 *     return new ModelAndView("cat/listCat");
 *  
 *  ● 傳遞多個參數
 *     Map map = new HashMap(); 
 *     map.put("cat",cat);
 *     map.put("catList",catList);
 *     return new ModelAndView("cat/listCat",map);   // 放回 ModelAndView
 *
 */
public class CatMultiActionController extends MultiActionController {

  // service 物件	
  private ICatService catService;

  public ICatService getCatService() {
	return catService;
  }

  public void setCatService(ICatService catService) {
	System.out.println(CatMultiActionController.class.getName()+",catService = "+catService);
	this.catService = catService;
  }

	
	
  // 主方法
  @Override
  protected ModelAndView handleRequestInternal(HttpServletRequest request,HttpServletResponse response) throws Exception {
	System.out.println(CatMultiActionController.class.getName()+",handleRequestInternal() execute...");
	
    String action = request.getParameter("action");
	if("add".equals(action)){
	  return this.add(request,response);
	}
	return this.list(request,response);
  }
	 
	
	
	// 儲存 Cat
	@SuppressWarnings("unchecked")
	public ModelAndView add(HttpServletRequest request,HttpServletResponse response) throws Exception{
	  System.out.println(CatMultiActionController.class.getName()+",add() execute...");
      System.out.println("name = "+request.getParameter("name"));
      
	  Cat cat = new Cat();
	  cat.setName(request.getParameter("name"));
	  cat.setCreateDate(new Date());

	  catService.createCat(cat);

	  return this.list(request, response);
	} // end add
	
	
	
	
	
	// 列出所有Cat 
	@SuppressWarnings("unchecked")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception{
	  System.out.println(CatMultiActionController.class.getName()+",list() execute...");
		
	  List<Cat> catList = catService.listCats();
	  request.setAttribute("catList",catList);
	  
	  return new ModelAndView("cat/listCat");    // 傳回 cat/listCat 頁面
	} // end list
	
	
	
	
	
}