package com.spring.orm.client;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.spring.orm.dao.ICatDao;
import com.spring.orm.entity.Cat;

public class Client {

  
  public static void main(String[] args) {

	// 更砞﹚郎
	XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
	
	// CatDao ン
	ICatDao catDao = (ICatDao)factory.getBean("catDao");
	

	
	
	Cat cat = new Cat();
	cat.setName("kevin's cat");
	cat.setCreateDate(new Date());
	
	
	// 纗ン
	catDao.createCat(cat);  // 纗ン
	System.out.println("\n");
	
	
	// 琩高┮ΤCat ン
	List<Cat> catList = catDao.listCats();
	for(Cat c:catList){
	  System.out.println("id"+c.getId());
	  System.out.println("name"+c.getName());
	  System.out.println("createDate"+c.getCreateDate());
	  
	  System.out.println("\n");
	} // end for(Cat c:catList){
	System.out.println("\n");
	 
	
	// 肚ン计秖
	int count = catDao.getCatsCount();
	System.out.println("眔羆掸计 count"+count);
	System.out.println("\n");
	 
	
	// 沮琩高ン
	Cat cat1 = catDao.findCatByName("kevin's cat");
	System.out.println("cat1 name = "+cat1.getName());
	System.out.println("\n");
	 
	
	
  } // end main
  
  

}
