package com.helloweenvsfei.orm.dao.impl;

import java.util.List;


import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


import com.helloweenvsfei.orm.bean.Cat;
import com.helloweenvsfei.orm.dao.ICatDao;

public class CatDaoImpl extends HibernateDaoSupport implements ICatDao {
 

  // 儲存物件	
  public void createCat(Cat cat){
    this.getHibernateTemplate().persist(cat);  // 使用Template 儲存物件
  }

 
  // 查詢所有物件
  public List<Cat> listCats(){
	return this.getHibernateTemplate().find("select c from Cat c "); // 使用 Template 查詢
  }
  

  // 傳回物件數量
  public int getCatsCount(){
	return Integer.valueOf(this.getSession(true).createQuery("select count(c) from Cat c ").uniqueResult().toString());
  }
  
  

  // 根據名字查詢物件(根據名字查詢Cat)
  public Cat findCatByName(String name){
	List <Cat> catList = this.getHibernateTemplate().find("select c from Cat c where c.name = ? ",name); // 使用 Template
	if(catList.size()>0){      // 如果有資料
      return catList.get(0);   // 傳回第一條
	} 
	return null;
  }
	
   



  
  
}
