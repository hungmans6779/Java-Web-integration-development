package com.helloweenvsfei.struts2.action;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import com.helloweenvsfei.orm.bean.Cat;
import com.helloweenvsfei.orm.dao.ICatService;

public class CatAction {
	
	private ICatService catService;                    // Service 物件
	private Cat cat;                                   // Cat 物件
	private List<Cat> catList = new ArrayList<Cat>();  //  catList 物件

	
	public ICatService getCatService() {
		return catService;
	}

	public void setCatService(ICatService catService) {
		this.catService = catService;
	}

	public Cat getCat() {
		return cat;
	}

	public void setCat(Cat cat) {
		this.cat = cat;
	}

	public List<Cat> getCatList() {
		return catList;
	}

	public void setCatList(List<Cat> catList) {
		this.catList = catList;
	}
	

	// 可執行方法，儲存 Cat
	public String add(){
	 cat.setCreateDate(new Date());
	 catService.createCat(cat);
	 
	 return list(); 
	}
	
  
	
	
	// 可執行方法，列出所有的 Cat
	public String list(){
	  catList = catService.listCat();
	  
	  return "list";	
	}
	
	

}
