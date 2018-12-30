package com.helloweenvsfei.hibernate.run;

import java.util.Date;
import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.helloweenvsfei.hibernate.bean.Cat;
import com.helloweenvsfei.hibernate.util.HibernateUtil;

public class CatTest02 {


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
    
    // ***************************************************************************************
    // Query q1= session.createQuery("select c from Cat c");
    Query q1= session.createQuery(" from Cat ");
    List<Cat> catList1 = q1.list();
    for(Cat c:catList1){
      System.out.println("****************************************************************");
      System.out.println("第 "+c.getId()+" 隻貓");
      System.out.println("姓名："+c.getName());
      System.out.println("描述："+c.getDescription());
      System.out.println("母貓："+(c.getMother()!=null?c.getMother().getName():"無"));
      System.out.println("****************************************************************");
    } // end for(Cat c:catList1){
    // ***************************************************************************************
    
    
    
    // ***************************************************************************************
    // 查詢貓的數量
    Query q2 = session.createQuery("select count(c) from Cat c ");
    Number num = (Number)q2.uniqueResult();                      // 傳回數量的單一實例
    int count = num.intValue();
    System.out.println("貓的數量 count = "+count);
    // ***************************************************************************************
    
    
    
    // ***************************************************************************************
    // 傳回集合總數
    List<Cat> catList3 = session.createQuery("select c from Cat c ").list();
    for(Cat c:catList3){
      System.out.println("****************************************************************");
      System.out.println("第 "+c.getId()+" 隻貓");
      System.out.println("姓名："+c.getName());
      System.out.println("描述："+c.getDescription());
      System.out.println("母貓："+(c.getMother()!=null?c.getMother().getName():"無"));
      System.out.println("****************************************************************");
    } // end for(Cat c:catList3){
    
    
    List<String> nameList4 = session.createQuery("select c.name from Cat c ").list();
    for(String s:nameList4){
      System.out.println("name s = "+s);	
    } // end 
    
    
    
    List<Object[]> nameList5 = session.createQuery("select c.name,c.mother.name from Cat c ").list();
    System.out.println("nameList5 = "+nameList5);
    for(Object [] row:nameList5){
      for(Object obj:row){
    	System.out.println(""+obj);  
      }
    } // end for(Object [] row:nameList5){
    
    
    List<Cat> catList6 = session.createQuery("select c.mother from Cat c ").list();
    System.out.println("catList6 size = "+catList6.size());
    for(Cat c:catList6){
      System.out.println("****************************************************************");
      System.out.println("第 "+c.getId()+" 隻貓");
      System.out.println("姓名："+c.getName());
      System.out.println("描述："+c.getDescription());
      System.out.println("母貓："+(c.getMother()!=null?c.getMother().getName():"無"));
      System.out.println("****************************************************************");	
    } // end for(Cat c:catList6){
    // ***************************************************************************************
    
    
    
    
    
    // 執行交易
    trans.commit();
    
    
    // 關閉階段
    session.close();
    
  } // end main
  

}
