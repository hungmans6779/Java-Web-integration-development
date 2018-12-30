package com.spring.orm.client;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.spring.orm.entity.Cat;
import com.spring.orm.service.ICatService;

public class Client_transaction {

	
  public static void main(String[] args) {
	 
	// 載入設定檔
    XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext_transaction.xml"));
    
    // 取得 CatServiceImpl 的物件
    ICatService catService = (ICatService)factory.getBean("catService");
    
   
    Cat cat = new Cat();
    cat.setName("kitty's");
    cat.setCreateDate(new Date());
    
    // 儲存 Cat 物件
    catService.createCat(cat);
    System.out.println("\n");
    
    
    // 查詢 Cat 數量
    int count = catService.getCatsCount();
    System.out.println("cat count = "+count);
    System.out.println("\n");
    
    // 列出所有 Cat
    List<Cat> catList = catService.listCats();
    for(Cat c:catList){
      System.out.println("id         = "+c.getId());
      System.out.println("name       = "+c.getName());
      System.out.println("createDate = "+c.getCreateDate());
      
      System.out.println("\n");
    } // end for(Cat c:catList){

  } // end main

  
}
