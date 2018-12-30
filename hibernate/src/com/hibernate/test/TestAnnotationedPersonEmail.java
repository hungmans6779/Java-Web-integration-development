package com.hibernate.test;

import java.util.List;


import org.hibernate.Session;

import com.hibernate.bean.Email;
import com.hibernate.bean.Person2;
import com.hibernate.util.HibernateSessionFactory;

public class TestAnnotationedPersonEmail {

	
  public static void main(String [] args){
	
    Person2 person = new Person2();             // 產生實體一個Person 
    person.setName("Jane");                     // 設定名稱
    
    Email email = new Email();                  // 產生實體一個 Email
    email.setEmail("yahoo@yahoo.com.tw");       // 設定 Email
    person.getEmails().add(email);              // 增加到 Person 物件中
    
    email = new Email();                        // 產生實體一個 Email
    email.setEmail("163@163.com");              // 設定 Email
    person.getEmails().add(email);              // 增加到 Person 物件中
    
    
    
    Session session = HibernateSessionFactory.getSession();  // 開啟一個Session
    session.beginTransaction();                              // 開始交易
    session.persist(person);                                 // 儲存 Person 物件，會自動串聯儲存 Email 物件
    
    StringBuffer sqlStr = new StringBuffer();
    sqlStr.append("select p from Person2 p left join fetch p.emails e   \n");
    sqlStr.append("   where e.email like '%@yahoo.com.tw'               \n");

    List list = session.createQuery(sqlStr.toString()).list();
    for(Person2 p:(List<Person2>) list){
      System.out.println("Person: "+p.getName());
      for(Email e:p.getEmails()){
    	System.out.println("\t id: "+e.getId()+", Email: "+e.getEmail()); 
      } // end for(Email e:p.getEmails()){
    } // end for(Person2 p:(List<Person2>) list){
   
    // session.delete(person);                      // 刪除 Person 物件，會自動串聯刪除屬於它的 Email 記錄
    
    session.getTransaction().commit();           // 傳送交易
    session.close();                             // 關閉對話
    
  } // end main
  
  
}
