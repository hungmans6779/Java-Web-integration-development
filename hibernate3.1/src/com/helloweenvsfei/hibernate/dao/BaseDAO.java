package com.helloweenvsfei.hibernate.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.helloweenvsfei.hibernate.util.HibernateSessionFactory;
import com.helloweenvsfei.hibernate.util.HibernateUtil;


/* 
 *  DAO 層：專門負責資料的讀寫。由於不用寫SQL敘述，DAO 層就簡單得多了。
 *  Hibernate 能夠管理所有的 Entity 類別，因此可以寫一個通用的 DAO ，操作所有的Entity。
 *  如果某個 Entity Bean 需要其他特別的操作，可以繼承 BaseDAO，並實現自己的操作，達到 BaseDAO 程式碼重用的目的。
 */

public class BaseDAO<T> {
  	
	
	
 /**
  * 插入資料表
  * @param object
  */
  public void create(T object){
	  
	// 開啟一個 Hibernate 對話  
    Session session = HibernateSessionFactory.getSessionFactory().openSession();
    Transaction trans = null;
    try{ 
      trans = session.beginTransaction();       // 開啟一個交易
      session.persist(object);                  // 將物件儲存進資料庫
      trans.commit();                           // 傳送交易
    }catch(Exception e){
      trans.rollback();                         // 如果有例外拋出，則回覆交易
    }finally{
      if(session!=null) { session.close();  }	// 關閉  Hibernate 階段
    }
  } // end void create
  
  
  
  
  
  
 /**
  * 更新資料表
  * @param object
  */
  public void update(T object){
	
	// 開啟一個 Hibernate 對話    
	Session session = HibernateSessionFactory.getSessionFactory().openSession();
	Transaction trans = null;
	try{
      trans = session.beginTransaction();      // 開啟一個交易
      session.update(object);                  // 更新object 對應的資料行
      trans.commit();                          // 傳送交易
	}catch(Exception e){       
	  trans.rollback();	                       // 如果有例外拋出，則回覆交易
	}finally{
	  if(session!=null) { session.close();  }  // 關閉  Hibernate 階段
	}
  } // end void update
  
  
  
  
  
  
 /**
  * 從資料庫中刪除
  * @param object
  */
  public void delete(T object){
	
	// 開啟一個 Hibernate 對話 
    Session session = HibernateSessionFactory.getSessionFactory().openSession();
    Transaction trans = null;
    try{
      trans = session.beginTransaction();     // 開啟一個交易
      session.delete(object);                 // 刪除 object 對應的資料行
      trans.commit();                         // 傳送交易
    }catch(Exception e){
      trans.rollback();	                      // 如果有例外拋出，則回覆交易
    }finally{
      if(session!=null) { session.close();  } // 關閉  Hibernate 階段
    }
    
  } // end void delete
  
  
  
  
  
    
 /**
  * 尋找單一Entity Bean
  * 
  * @param clazz
  * @param id
  * @return
  */
  @SuppressWarnings("unchecked")
  public T find(Class<? extends T> clazz,Serializable id){
	  
	// 開啟一個 Hibernate 對話  
	Session session = HibernateSessionFactory.getSessionFactory().openSession();
	Transaction trans = null;
	try{
	  trans = session.beginTransaction();     // 開啟一個交易
	  return (T)session.get(clazz,id);
	}finally{
	  // session.getTransaction().commit();
	  trans.commit();                         // 傳送交易            
	  if(session!=null){ session.close(); }   // 關閉  Hibernate 階段
	}
  } // end T find
  
  
  
  
  
   
 /**
  * 尋找多個Entity Bean
  * 
  * @param hql
  * @return
  */  
  @SuppressWarnings("unchecked")
  public List <T> list(String hql){
	  
	// 開啟一個 Hibernate 對話  
	Session session = HibernateSessionFactory.getSessionFactory().openSession();
	Transaction trans = null;
	try{	  
	  trans = session.beginTransaction();   // 開啟一個交易
	  return session.createQuery(hql).list();
	}finally{
	  // session.getTransaction().commit();
	  trans.commit();                          // 傳送交易          
	  if(session!=null) { session.close();  }  // 關閉  Hibernate 階段
	} 
  } // end List<T>
  
	

  
}
