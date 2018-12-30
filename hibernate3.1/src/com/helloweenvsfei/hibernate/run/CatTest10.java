package com.helloweenvsfei.hibernate.run;

import java.util.Date;
import java.util.List;
import java.util.Map;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.helloweenvsfei.hibernate.bean.Cat;
import com.helloweenvsfei.hibernate.bean.Event;
import com.helloweenvsfei.hibernate.util.HibernateUtil;

public class CatTest10 {


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
    
    Event event1 = new Event();
    event1.setDescription("event'1 description");
    event1.setCreateDate(new Date());
    event1.setCat(catMother);
    
    Event event2 = new Event();
    event2.setDescription("event'2 description");
    event2.setCreateDate(new Date());
    event2.setCat(catChild1);
    
    Event event3 = new Event();
    event3.setDescription("event'3 description");
    event3.setCreateDate(new Date());
    event3.setCat(catChild2);
    
    Event event4 = new Event();
    event4.setDescription("event'4 description");
    event4.setCreateDate(new Date());
    event4.setCat(catChild3);
    
    
    // 開啟階段
    Session session = HibernateUtil.getSession();
    
    // 開啟交易
    Transaction trans = session.beginTransaction();
    
    
   
    
    session.persist(catMother);
    session.persist(catChild1);
    session.persist(catChild2);
    session.persist(catChild3);
    session.persist(event1);
    session.persist(event2);
    session.persist(event3);
    session.persist(event4);
    
    
    /*
     * 跨表查詢
     * 對於一般的跨表查詢，表連接就足夠了。Hibernate 支援用 "." 作為操作符獲屬性，用法類似於 JSP 中的EL運算式。
     * 表連接查詢適用於非集合屬性，例如Event 的 cat 屬性，Student 的 clazz 屬性等。
     * 例如：
     */
    List<Event> list = session.createQuery("select e from Event e where e.cat.name= 'kevin' ").list();
    for(Event e:list){
      System.out.println("貓名："+e.getCat().getName());	
    } // end for(Cat c:list){
    
    
    // 執行交易
    trans.commit();
    
    
    // 關閉階段
    session.close();
    
  } // end main
  

}
