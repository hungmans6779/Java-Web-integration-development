package com.helloweenvsfei.mvc;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;




import com.helloweenvsfei.orm.bean.Cat;
import com.helloweenvsfei.orm.dao.ICatService;

// 繼承 AbstractController
public class  CatController extends AbstractController {
  
  private ICatService catService;      // service 物件
   
  public ICatService getCatService() {
	return catService;
  }

  public void setCatService(ICatService catService) {
	this.catService = catService;
  }


  // 主方法
  @Override
  protected ModelAndView handleRequestInternal(HttpServletRequest request,HttpServletResponse response) throws Exception {
   	String action = request.getParameter("action");
   	if("add".equals(action)){
   	  return this.add(request,response);
   	}
   	return this.list(request,response);
  }
  
  
  
  
  // 儲存 Cat
  protected ModelAndView add(HttpServletRequest request,HttpServletResponse reponse) throws Exception{
	Cat cat = new Cat();
	cat.setName(request.getParameter("name"));
	cat.setCreateDate(new Date());
	
	catService.createCat(cat);

	return new ModelAndView("cat/listCat","cat",cat);  // 傳回 cat/listCat 頁面 
  } // end add
  
  
  
  // 列出所有Cat 
  protected ModelAndView list(HttpServletRequest request,HttpServletResponse reponse) throws Exception{
	List<Cat> catList = catService.listCat();
	request.setAttribute("catList",catList);	
	  
	return new ModelAndView("cat/listCat");    // 傳回 cat/listCat 頁面
  } // end list
  

  
  
  
}
