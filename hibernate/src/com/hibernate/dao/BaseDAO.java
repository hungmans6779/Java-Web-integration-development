package com.hibernate.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.hibernate.util.HibernateUtil;
import com.hibernate.util.HibernateSessionFactory;



public class BaseDAO<T> {

	
	
  /**
   * 插入資料
   * 
   * @param object
   */
  public void create(T object){
	  
	// 開啟一個 Hibernate 階段  
	Session session = HibernateSessionFactory.getSessionFactory().openSession();
	try{
	  Transaction trans = session.beginTransaction();   // 開啟一個交易
	  session.persist(object);                          // 將物件儲存進資料庫
	  trans.commit();                                   // 傳送交易
	 /*
	  session.beginTransaction();
	  session.persist(object);
	  session.getTransaction().commit();
	  */
	}catch(Exception e){
	  e.printStackTrace();	
	  session.getTransaction().rollback();  // 如果拋出例外，則回復交易
	}finally{
	  session.close();	                    // 關閉 Hibernate 階段
	}
  } // end create(T object)
	
  

  
  
  
  
  
 /**
  * 更新資料庫
  * 
  * @param object
  */
  public void update(T object){
	  
	// 開啟一個 Hibernate 階段  
	Session session = HibernateSessionFactory.getSessionFactory().openSession();
	try{
	  Transaction trans = session.beginTransaction();  // 開啟交易
	  session.update(object);                          // 更新object 對應的資料行
	  trans.commit();                                  // 傳送交易
	/*  
	  session.beginTransaction();
	  session.update(object);
	  session.getTransaction().commit();
	  */
	}catch(Exception e){
	  e.printStackTrace();	
	  session.getTransaction().rollback();  // 如果拋出例外，則回復交易
	}finally{
	  session.close();	                    // 關閉 Hibernate 階段
	}
  } // end update(T object)
	
  
  
  
  
  
  
  
  /**
   * 從資料庫中刪除
   * 
   * @param object
  */
  public void delete(T object){
	  
	// 開啟一個 Hibernate 階段  
	Session session = HibernateSessionFactory.getSessionFactory().openSession();  
	try{
	  Transaction trans = session.beginTransaction();  // 開啟交易
	  session.delete(object);                          // 刪除 object 對應的資料行
	  trans.commit();                                  // 傳送交易
	  /*
	  session.beginTransaction();
	  session.delete(object);
	  session.getTransaction().commit();
	  */
	}catch(Exception e){
	  e.printStackTrace();
	  session.getTransaction().rollback();  // 如果拋出例外，則回復交易
	}finally{
	  session.close();                      // 關閉 Hibernate 階段
	}
  } // end delete(T object)
	
  
  
  
  
  
 /**
  * 根據 id 尋找單一Entity Bean
  * 
  * @param clazz
  * @param id
  * @return
  */
  @SuppressWarnings("unchecked")
  public T find(Class<? extends T> clazz, Serializable id) {
	
	// 開啟一個 Hibernate 階段  
	Session session = HibernateSessionFactory.getSessionFactory().openSession();
	try{
	  session.getTransaction();             // 開啟交易
	  return (T) session.get(clazz,id);     // 根據 id 查詢實體類別物件
	}finally{
	  session.close();                      // 關閉 Hibernate 階段
	}
  }
	
  
  
  
  
  
  
  
  /**
   * 尋找多個Entity Bean
   * 
   * @param hql
   * @return
   */
  @SuppressWarnings("unchecked")
  public List <T> list(String hql){
	
	// 開啟一個 Hibernate 階段  
	Session session = HibernateSessionFactory.getSessionFactory().openSession();
	try{
	  session.beginTransaction();               // 開啟交易
	  return session.createQuery(hql).list();   // 查詢 hql 結果，傳回List 物件
	}finally{
      session.getTransaction().commit();        // 傳送交易
      session.close();                          // 關閉 Hibernate 階段
	}
  } // end list(String hql)
  
  
  
  
  
  
}
