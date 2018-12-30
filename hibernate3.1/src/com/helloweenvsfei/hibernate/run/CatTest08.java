package com.helloweenvsfei.hibernate.run;

import java.util.Date;
import java.util.List;
import java.util.Map;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.helloweenvsfei.hibernate.bean.Cat;
import com.helloweenvsfei.hibernate.util.HibernateUtil;

public class CatTest08 {


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
  
    
    // 統計函數
    /*
     *  跟SQL 一樣，Hibernate 也提供一系列的統計函數。Hibernate 會把HQL 的統計函數轉化為底層資料庫SQL支援的函數。
     *  SQL 常用的統計函數例如，count()、sum()、min()、max()、avg()、count(distinct...) 等也都能用在HQL ，語法與SQL一樣。
     */
    StringBuffer sqlStr = new StringBuffer();
    sqlStr.append("  select count(c) from Cat c       \n");
    sqlStr.append("   where c.mother != null          \n");
 
    Number num = (Number)session.createQuery(sqlStr.toString()).uniqueResult();
    int count = num.intValue();
    System.out.println("貓的總數 count = "+count);
    
    // 執行交易
    trans.commit();
    
    
    // 關閉階段
    session.close();
    
  } // end main
  

}
