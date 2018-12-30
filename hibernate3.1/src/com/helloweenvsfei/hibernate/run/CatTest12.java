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

public class CatTest12 {


  public static void main(String[] args) {
    

    
    // 開啟階段
    Session session = HibernateUtil.getSession();
    
    // 開啟交易
    Transaction trans = session.beginTransaction();

    
    
    /*
     * 使用 SQL 資料庫
     * HQL 可以看做是對所有SQL資料庫的封裝。HQL提供的功能是底層資料庫SQL支援的，HQL只是將功能"翻譯"成了底層SQL的功能。
     * 有些情況下，底層資料庫會提供某種功能，但是可能HQL不支援。這時可以使用底層SQL，在專業術語上叫做本機SQL(Native SQL)
     * 例如：
     */
    
    
    SQLQuery sqlQuery = session.createSQLQuery(" show variables ");
    List<Object[]> list = sqlQuery.list();
    for(Object[] obj:list){
      System.out.println(obj[0]+", "+obj[1]+",");	   // 輸出屬性值
    }
    
    
    // 執行交易
    trans.commit();
    
    
    // 關閉階段
    session.close();
    
  } // end main
  

}
