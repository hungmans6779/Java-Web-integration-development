package com.helloweenvsfei.hibernate.run;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.helloweenvsfei.hibernate.bean.Person3;
import com.helloweenvsfei.hibernate.util.HibernateXMLUtil;

public class TestXMLPerson3Email {


  public static void main(String[] args) {
   
	Person3 person1 = new Person3();
	person1.setName("kevin");
	person1.getEmails().add("kevinhung@eztravel.com.tw");
	person1.getEmails().add("hungmans6779@msn.com");
	person1.getEmails().add("kevinhungs@gmail.com");
	
	
	
	Person3 person2 = new Person3();
	person2.setName("kk");
	person2.getEmails().add("kk@gmail.com");
	
	
	// 開啟階段
	Session session = HibernateXMLUtil.getSession();
	
	// 開啟交易 
	Transaction trans = session.beginTransaction();
	
	session.persist(person1);  // 儲存 person1 物件，會自動串聯儲存  Email 物件
	session.persist(person2);
	
	
	StringBuffer sqlStr = new StringBuffer();
	sqlStr.append("   select p from Person3 p left join fetch p.emails e   \n");
	sqlStr.append("    where e like '%@gmail.com%'                         \n");
	
	
	List list = session.createQuery(sqlStr.toString()).list();
	for(Person3 p:(List<Person3>)list){
      System.out.println("Person："+p.getName());
      for(String email:p.getEmails()){
        System.out.println("\t Email："+email);	  
      } // end for(String email:p.getEmails()){
	} // end for(Person3 p:(List<Person3>)list){
	
	
	// session.delete(person1);   // 刪除 Person 物件，會自動串聯刪除 Email 資料
	// session.delete(person2);
	
	// 傳送交易
	trans.commit();
	
	// 關閉交易
	session.close();  
	  
  } // end mail

}
