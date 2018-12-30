package com.helloweenvsfei.orm.dao;

import java.util.List;

import com.helloweenvsfei.orm.bean.Cat;

public interface ICatService {
	
  // 持久化Cat 物件
  public void createCat(Cat cat); 
  
  // 列出所有的Cat
  public List<Cat>listCat();   
  
  // 查詢Cat 數量
  public int getCatsCount();  
}
