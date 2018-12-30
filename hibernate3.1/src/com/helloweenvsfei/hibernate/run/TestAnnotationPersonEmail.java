package com.helloweenvsfei.hibernate.run;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.helloweenvsfei.hibernate.bean.Email;
import com.helloweenvsfei.hibernate.bean.Person2;
import com.helloweenvsfei.hibernate.util.HibernateSessionFactory;

public class TestAnnotationPersonEmail {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
	  Person2 person1 = new Person2();               // 產生實體的一個Person 
      person1.setName("kevin");                      // 設定名稱
      List<Email> emails1 = person1.getEmails();

      
      Person2 person2 = new Person2();
      person2.setName("KK");
      List<Email> emails2 = person2.getEmails();
      
      
      
     
      
      Email email = null;
      
      email = new Email();                           // 產生實體的一個Email                      
      email.setEmail("kevinhung@eztravel.com.tw");   // 設定 Email(kevinhung@eztravel.com.tw)
      // person2.getEmails().add(email);             // 增加到 Person 物件中
      emails1.add(email);                            // 增加到 Person 物件中
      
      email = new Email();                           // 產生實體的一個Email    
      email.setEmail("hungmans6779@msn.com");        // 設定 Email(hungmans6779@msn.com)
      // person2.getEmails().add(email);             // 增加到 Person 物件中
      emails1.add(email);                            // 增加到 Person 物件中
      
      email = new Email();                           // 產生實體的一個Email        
      email.setEmail("kevinhungs@gmail.com");        // 設定 Email(kevinhungs@gmail.com)
      // person2.getEmails().add(email);             // 增加到 Person 物件中
      emails1.add(email);                            // 增加到 Person 物件中
     
      
      
      email = new Email();
      email.setEmail("KK@eztravel.com.tw");
      emails2.add(email);
      
      email = new Email();
      email.setEmail("KK@msn.com");
      emails2.add(email);
      
      email = new Email();
      email.setEmail("KK@gmail.com");
      emails2.add(email);
      
      
     
      
      // 開啟一個Session 
      Session session = HibernateSessionFactory.getSession();  
     
      // 開始交易
      Transaction trans = session.beginTransaction();
      
      // 儲存 Person2 物件，會自動串聯儲存Email 物件
      session.persist(person1);
      session.persist(person2);
      
      
      
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("   select p from Person2 p left join fetch p.emails e         \n");
      sqlStr.append("    where e.email like '%@msn.com%'                           \n");
      

      System.out.println("所執行的  sqlStr = \n"+sqlStr.toString());
      List list = session.createQuery(sqlStr.toString()).list();
      for(Person2 p:(List<Person2>)list){
    	System.out.println("person1："+p.getName());
    	for(Email e:p.getEmails()){
          System.out.println("\t person1 like '@msn.com@'  Email：   "+e.getEmail());		
    	} 
      } // end for(Person2 p:(List<Person2>)list){
      
      // session.delete(person2);             // 刪除  Person2 物件，會自動串聯刪除屬於它的 Email 記錄
      
      // session.getTransaction().commit();
      trans.commit();                         // 傳送交易
      
      
      session.close();                        // 關閉對話
      
	}

}
