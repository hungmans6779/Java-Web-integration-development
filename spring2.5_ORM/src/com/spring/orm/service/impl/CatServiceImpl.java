package com.spring.orm.service.impl;

import java.util.List;

import com.spring.orm.dao.ICatDao;
import com.spring.orm.entity.Cat;
import com.spring.orm.service.ICatService;


/*
 *  CatServiceImpl 實現了ICatService 介面。程式碼中定了一個 DAO 類型屬性，以及 getter、setter 方法。
 *  Spring 將透過 getter、setter 方法注射在 DAO 物件。Service 層透過 DAO 物件實現業務邏輯。
 *  
 *  DAO 層：負責資料的儲存、儲存;
 *  Service 層：負責檢查資料的完整性，例如檢查是否重名等;
 */
public class CatServiceImpl implements ICatService {

	public CatServiceImpl() {

	}

	
	// Cat DAO 物件
	private ICatDao catDao;

	public ICatDao getCatDao(){
		return catDao;
	}

	public void setCatDao(ICatDao catDao) {
		this.catDao = catDao;
	}

	
	
	
	/*
	 * 儲存 Cat 物件
	 * 
	 * @param Cat 物件
	 */
	public void createCat(Cat cat) {
	  System.out.println(CatServiceImpl.class.getName()+",createCat() execute...");
	  Cat catObj = catDao.findCatByName(cat.getName());
	  System.out.println("catObj mm= "+catObj);
	  
      if(catObj !=null ){
    	throw new RuntimeException("貓 "+cat.getName()+", 已經存在！！！");  
      }
      catDao.createCat(cat); 
	} // end createCat(Cat cat)

	
	
	/*
	 * 列出所有 Cat
	 * 
	 * @return int Cat 數量
	 */
	public List<Cat> listCats(){
	  return this.catDao.listCats();
	} // end listCats()

	
	
	/*
	 * 查詢 Cat 數量
	 * 
	 * @return int 數量
	 */
	public int getCatsCount() {
	  return this.catDao.getCatsCount();
	} // end getCatsCount()

	
}
