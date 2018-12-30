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

public class CatTest11 {


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
    event1.setDescription("吃飯、跑步");
    event1.setCreateDate(new Date());
    event1.setCat(catMother);
    
    Event event2 = new Event();
    event2.setDescription("吃飯、跑步");
    event2.setCreateDate(new Date());
    event2.setCat(catChild1);
    
    Event event3 = new Event();
    event3.setDescription("跑步、睡覺");
    event3.setCreateDate(new Date());
    event3.setCat(catChild2);
    
    Event event4 = new Event();
    event4.setDescription("吃飯");
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
     * 串聯查詢
     * 有些查詢需要使用串聯查詢。 HQL 支援SQL 的串聯查詢，包括 inner join、left join、right join、full join 等。
     * 串聯查詢適用於集合屬性，例如Cat 的 events 集合屬性，Clazz的 stuendt 集合屬性等。例如查詢 events 集合屬性中有"吃飯"事件的cat
     * 例如：
     */
    List<Cat> list = session.createQuery("select c from Cat c left join c.events e where e.description like :description ").setParameter("description","%吃飯%").list();
    for(Cat c:list){
      System.out.println("貓名："+c.getName());	
    } // end for(Cat c:list){
    
    
    // 執行交易
    trans.commit();
    
    
    // 關閉階段
    session.close();
    
  } // end main
  

}
