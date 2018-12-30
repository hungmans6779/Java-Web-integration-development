package com.helloweenvsfei.hibernate.run;

import java.util.Date;
import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.helloweenvsfei.hibernate.bean.Cat;
import com.helloweenvsfei.hibernate.util.HibernateUtil;

public class CatTest04 {


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
  
    
    // 傳回List 類型
    /*
     *  傳回結果還可以放到List<List>中，查詢時HQL 採用 " select new List(a,b,c) from ... "的形式。
     *  同樣需要檢查List 來獲得傳回的List，再檢查傳回的List 獲得查詢的結果，例如：
     */
    List<List> list = session.createQuery("select new List(c.name,c.mother.name,c.createDate) from Cat c ").list();
    for(List row:list){
      for(Object obj:row){
    	System.out.println(""+obj);  
      }
    }
    
    
    // 執行交易
    trans.commit();
    
    
    // 關閉階段
    session.close();
    
  } // end main
  

}
