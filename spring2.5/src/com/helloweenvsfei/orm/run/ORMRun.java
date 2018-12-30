package com.helloweenvsfei.orm.run;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.xml.XmlBeanFactory;

import org.springframework.core.io.ClassPathResource;

import com.helloweenvsfei.orm.bean.Cat;
import com.helloweenvsfei.orm.dao.ICatDao;

public class ORMRun {

	
  public static void main(String [] args){
	  
	XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext-orm.xml"));  
	ICatDao catDao = (ICatDao) factory.getBean("catDao");
	
	Cat cat = new Cat();
	cat.setName("Hello Kitty");
	cat.setCreateDate(new Date()); 
	
	
	catDao.createCat(cat);                                           // 纗ン	
	

	List <Cat> catList = catDao.listCats();                          // 琩高┮Τン
	for(Cat c:catList){
	  System.out.println("Name"+c.getName());	
	} // end for(Cat c:catList){
	
	
	System.out.println("┮Τン计秖"+catDao.getCatsCount());     // 肚ン计秖
	
	
    Cat cat1 = catDao.findCatByName("Hello Kitty");                  // 沮琩高ン(沮琩高Cat)
    System.out.println("Hello Kitty => id = "+cat1.getId()+" , name = "+cat1.getName());
    
  }
  
  
  
}
