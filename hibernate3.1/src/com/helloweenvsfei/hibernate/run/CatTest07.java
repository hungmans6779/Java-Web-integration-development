package com.helloweenvsfei.hibernate.run;

import java.util.Date;
import java.util.List;
import java.util.Map;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.helloweenvsfei.hibernate.bean.Cat;
import com.helloweenvsfei.hibernate.util.HibernateUtil;

public class CatTest07 {


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
  
    
    // 傳回 Java 實體物件
    /*
     *  對於只查詢部份屬性的查詢，傳回陣列、List、Map 時，很方便，但是操作Object[] 陣列，List、Map 等不如操作實體物件方便。
     *  實際上查詢部份屬性時，也可以傳回實體物件。HQL中也可以使用建構函數。
     */
    StringBuffer sqlStr = new StringBuffer();
    sqlStr.append("  select c from Cat c                   \n");
    sqlStr.append("   where c.mother.name != null          \n");
    sqlStr.append("     and c.createDate < :createDate     \n");
        
    List<Cat> catList = session.createQuery(sqlStr.toString()).setParameter("createDate",new Date()).list();
    System.out.println("catList size = "+catList.size());
    for(Cat c:catList){
      System.out.println("*******************************************");
      System.out.println("貓名："+c.getName());
      System.out.println("描述："+c.getDescription());
      System.out.println("建立日期："+c.getCreateDate());
      System.out.println("母貓的名字："+(c.getMother()!=null?c.getMother().getName():""));
      System.out.println("*******************************************");
    }
    
    // 執行交易
    trans.commit();
    
    
    // 關閉階段
    session.close();
    
  } // end main
  

}
