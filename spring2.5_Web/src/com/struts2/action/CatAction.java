package com.struts2.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.spring.orm.entity.Cat;
import com.spring.orm.service.ICatService;

public class CatAction {

	private ICatService catService;                     // Service 物件
	private Cat cat;                                    // Cat 物件
	private List<Cat> catList = new ArrayList<Cat>();   // catList 存放 Cat 物件


	// 增加 Cat 物件
	public String add(){
      System.out.println(CatAction.class.getName()+",add()  execute...");
      System.out.println("cat.name = "+cat.getName());
      cat.setCreateDate(new Date());
      catService.createCat(cat);  // 儲存 Cat 物件
   
	  return list();
	} // end add
	
	
	
	// 列出所有的 Cat
	public String list(){
	  System.out.println(CatAction.class.getName()+",list()  execute...");
	  catList = catService.listCats();
	  
	  return "list";
	} // list
	
	
	
	
	
	
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

}
