package com.hibernate.test;

import java.awt.Font;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Session;

import com.hibernate.bean.Email;
import com.hibernate.bean.Person2_1;
import com.hibernate.util.HibernateSessionFactory;

public class TestLazyInitializationException {
  
  static int createID = 0;
  
  static{  // 類別載入的時候儲存一個 Person
	
	Person2_1 person = new Person2_1();              // 初始化一個 Person 實例
	person.setName("kevin");          
	
	Email email = new Email();                       // 產生實體一個Email
	email.setEmail("kevinhung@eztravel.com.tw");     // 設定 email 屬性
	person.getEmails().add(email);                   // 增加到 person 中
	
	
	email = new Email();                              
	email.setEmail("hungmans6779@msn.com");
	person.getEmails().add(email);
	
	
	Session session = HibernateSessionFactory.getSession();  // 開啟階段
	session.beginTransaction();                              // 開啟交易
	
	session.persist(person);                                 // 儲存到資料庫
	createID = person.getId();                               // 將 id 儲存起來
	
	
	session.getTransaction().commit();                       // 傳送交易
	session.close();                                         // 關閉階段
	
  }
  
	
  
  public static void main(String [] args) throws Exception{
	
	  Session session = HibernateSessionFactory.getSession();     // 只查不用開啟交易
	  
	  Person2_1 p = (Person2_1) session.get(Person2_1.class,createID);  // 查詢
	  session.close();                                            // 關閉
	  
	  
	  try{
		List<Email> list = p.getEmails();                           // 載入資料， 將會拋出例外
		System.out.println(p.getName()+" 的電子郵件:");
		for(Email mail:list){    // 循環輸出Email
	      System.out.println("\t"+mail.getEmail());		 
		}
	  }catch(Exception e){
		String title = e.getClass().getName();  // 錯誤資訊
		String msg = e.getMessage().replace(",","\r\n").replace(":",":\r\n");
		
		System.out.println("kevintest title = "+title);
		System.out.println("kevintest msg = "+msg);

		// 用 Swing 顯示查詢結果
		JOptionPane.getRootFrame().setFont(new Font("Arial",Font.BOLD,14));
		JOptionPane.showMessageDialog(null,msg,title,JOptionPane.ERROR_MESSAGE);
	  }  
  }
  
}