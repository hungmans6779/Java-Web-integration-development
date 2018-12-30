package com.helloweenvsfei.orm.dao.impl;

import java.util.List;

import com.helloweenvsfei.orm.bean.Cat;
import com.helloweenvsfei.orm.dao.ICatDao;
import com.helloweenvsfei.orm.dao.ICatService;

// Service 介面實現
public class CatServiceImpl implements ICatService {

  private ICatDao catDao;  // DAO 物件
    
  public ICatDao getCatDao() {
	return catDao;
  }

  public void setCatDao(ICatDao catDao) {
	this.catDao = catDao;
  }

  
  

  // 持久化Cat 物件(儲存Cat 物件)
  public void createCat(Cat cat) {
    if(catDao.findCatByName(cat.getName())!=null){  // 檢查同名的Cat 是否存
      throw new RuntimeException("貓："+cat.getName()+",已經存在。");  // 拋出例外
    }else{                                          // 如果不存在則建立
      catDao.createCat(cat);
    }
  } // end public void createCat(Cat cat) {

  
  
  
  // 列出所有的Cat
  public List<Cat> listCat() {
	return catDao.listCats();      // 查詢所有Cat 物件
  } // end public List<Cat> listCat() {

  
  
  
  // 查詢Cat 數量
  public int getCatsCount() {
	return catDao.getCatsCount();   // 傳回已錄總數
  } // end public int getCatsCount() {

}
