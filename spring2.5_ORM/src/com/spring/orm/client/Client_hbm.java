package com.spring.orm.client;

import java.util.Date;

import java.util.List;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.spring.orm.dao.ICatDao;
import com.spring.orm.entity.Cat;


public class Client_hbm {

  public static void main(String[] args) {
    
	System.out.println(Client_hbm.class.getName()+",main() execute...");
	  
	  
	// 載入設定檔
	XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext_hbm.xml"));
	
	
	// Cat DAO 物件
	ICatDao catDao = (ICatDao)factory.getBean("catDao");
	

	
	Cat cat = new Cat();
	cat.setName("kevin's cat");
	cat.setCreateDate(new Date());
	
	
	// 儲存物件
	catDao.createCat(cat);  // 儲存物件
	System.out.println("\n");
	
	
	// 查詢所有的Cat 物件
	List<Cat> catList = catDao.listCats();
	for(Cat c:catList){
	  System.out.println("id："+c.getId());
	  System.out.println("name："+c.getName());
	  System.out.println("createDate："+c.getCreateDate());
	  
	  System.out.println("\n");
	} // end for(Cat c:catList){
	System.out.println("\n");
	 	 
  } // end main
  

}
