package com.helloweenvsfei.hibernate.run;

import java.util.Date;
import java.util.List;
import java.util.Map;


import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.helloweenvsfei.hibernate.bean.Cat;
import com.helloweenvsfei.hibernate.bean.Event;
import com.helloweenvsfei.hibernate.util.HibernateUtil;

public class CatTest13 {


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
     * 傳回實體類別型
     * SQLQuery 與 Query 一樣，都可以設定參數、分頁顯示等。SQLQuery 傳回的結果為List<Object[]> 類型。
     * 也可以設定為實體類別，使查詢結果直接傳回實體類別物件。 
     * 例如：
     */
    SQLQuery sqlQuery = session.createSQLQuery("select * from tb_cat ");
    sqlQuery.addEntity(Cat.class);
    List<Cat> catList = sqlQuery.list();
    System.out.println("catList size = "+catList.size());
    for(Cat c:catList){
      System.out.println(c.getName());	   // 輸出屬性值
    }
    
    
    // 執行交易
    trans.commit();
    
    
    // 關閉階段
    session.close();
    
  } // end main
  

}
