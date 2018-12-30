package com.helloweenvsfei.hibernate.run;

import java.util.Date;
import java.util.List;
import java.util.Map;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.helloweenvsfei.hibernate.bean.Cat;
import com.helloweenvsfei.hibernate.util.HibernateUtil;

public class CatTest09 {


  public static void main(String[] args) {
    
	Cat catMother = new Cat(); 
    catMother.setName("Sue");
    catMother.setDescription("母貓");
    catMother.setCreateDate(new Date());
    

    Cat catChild1=new Cat();
    catChild1.setName("kevin");
    catChild1.setDescription("小貓'name is kevin ");
    catChild1.setMother(catMother);
    catChild1.setCreateDate(new Date());
    
    Cat catChild2=new Cat();
    catChild2.setName("kent");
    catChild2.setDescription("小貓'name is kent");
    catChild2.setMother(catMother);
    catChild2.setCreateDate(new Date());
    
    
    Cat catChild3=new Cat();
    catChild3.setName("joe");
    catChild3.setDescription("小貓'name is joe ");
    catChild3.setMother(catMother);
    catChild3.setCreateDate(new Date());
    
    
    
    
    
    // 開啟階段
    Session session = HibernateUtil.getSession();
    
    // 開啟交易
    Transaction trans = session.beginTransaction();
    
    
    session.persist(catMother);
    session.persist(catChild1);
    session.persist(catChild2);
    session.persist(catChild3);
  
    
    /*
     * HQL 分頁顯示
     *   分頁顯示是 Web 資料庫程式必備的功能。不同的資料庫使用不同的方式實現分頁，例如：MySQL 使用 limit、Oracle 使用 rownum。
     * Hibernate 隱藏了所有的細節，只需要設定目前頁數即可。
     *   分頁顯示一般先查詢記錄總數，然後查詢本頁顯示的記錄。Hibernate 透過 Query 查詢記錄，Query 透過 setFirstResult() 設定分頁的第一條記錄，
     * 透過 setMaxResults() 設定取本頁的資料數，
     * 例如：
     */
    long count  = (Long)session.createQuery("select count(c) from Cat c").uniqueResult();
    System.out.println("貓的總數 count = "+count);
    
    List<Cat> list = session.createQuery(" from Cat").setFirstResult(0).setMaxResults(10).list();
    for(Cat c:list){
      System.out.println("貓名："+c.getName());	
    } // end for(Cat c:list){
    
    
    // 執行交易
    trans.commit();
    
    
    // 關閉階段
    session.close();
    
  } // end main
  

}
