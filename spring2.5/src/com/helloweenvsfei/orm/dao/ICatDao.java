package com.helloweenvsfei.orm.dao;

import java.util.List;

import com.helloweenvsfei.orm.bean.Cat;

// DAO 介面
public interface ICatDao {  

  // 儲存物件	
  public void createCat(Cat cat);

  // 查詢所有物件
  public List<Cat> listCats();
 
  // 傳回物件  
  public int getCatsCount();
 
  // 根據名字查詢物件
  public Cat findCatByName(String name);
  
}
