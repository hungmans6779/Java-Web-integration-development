package com.helloweenvsfei.hibernate.run;

import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.helloweenvsfei.hibernate.bean.Email;
import com.helloweenvsfei.hibernate.bean.Person2;
import com.helloweenvsfei.hibernate.util.HibernateSessionFactory;

public class TestLazyInitializationException {


  static int createId = 0;
  
  // 類別載入的時候儲存一個Person
  static{
	  
	// 初始化一個 Person 實例 
    Person2 person1 = new Person2();	  
	person1.setName("Kevin");
	List<Email> emails1 = person1.getEmails();
	

	Email email = new Email();                       // 產生一個Email 實例
	email.setEmail("kevinhung@eztravel.com.tw");     // 設定email 屬性
	emails1.add(email);                              // 增加到person 中 
	

	// 開啟階段
	Session session = HibernateSessionFactory.getSession();
	
	// 開啟交易
	Transaction trans = session.beginTransaction();
	
	// 儲存到資料庫
	session.persist(person1);
	
	// 將 id 儲存起來
	createId = person1.getId();
	

	// 傳送交易
	trans.commit();             
	
	// 關閉階段
	session.close();            	
  } // end static
  
  
  
  public static void main(String[] args) {
    
	// 開啟階段 
	Session session = HibernateSessionFactory.getSession();
    
	// 只查詢，不開啟交易
    Person2 person = (Person2)session.get(Person2.class,createId);
    
    // 開閉階段
    session.close();    
   
    try{
      List<Email> list = person.getEmails();
      System.out.println("person Name = "+person.getName());
      for(Email mail:list){
    	System.out.println("\t"+mail.getEmail());  
      }
    }catch(Exception e){
      String title = e.getClass().getName();
      String msg = e.getMessage().replace(",",",\r\n").replace(":",":\r\n");
      JOptionPane.showMessageDialog(null,msg,title,JOptionPane.ERROR_MESSAGE);
    }
    
    
  } // end main
  
  

}
