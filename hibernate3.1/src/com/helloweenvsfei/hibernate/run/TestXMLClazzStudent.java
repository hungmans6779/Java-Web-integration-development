package com.helloweenvsfei.hibernate.run;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.helloweenvsfei.hibernate.bean.Clazz;
import com.helloweenvsfei.hibernate.bean.Student;
import com.helloweenvsfei.hibernate.util.HibernateSessionFactory;
import com.helloweenvsfei.hibernate.util.HibernateXMLUtil;

public class TestXMLClazzStudent {


  @SuppressWarnings("all")
  public static void main(String[] args) {
	    

    // ******************************************************************************
	// 三年一班學生
	Clazz clazz31 = new Clazz();            // 產生實體的一個班級
	clazz31.setName("三年一班");             // 班級名稱
	    
	Student student311 = new Student();     // 產生實體的一個學生
	student311.setName("周杰倫");           // 姓名
	student311.setSex("男");                // 性別
	   
	Student student312 = new Student();
	student312.setName("蔡依琳");
	student312.setSex("女");
	// ******************************************************************************
	    
	    
	    
	       
	// ******************************************************************************
	// 三年二班學生
	Clazz clazz32 = new Clazz();  // 產生實體的一個班級
	clazz32.setName("三年二班");
	   
	Student student321 = new Student();
	student321.setName("素還真");
	student321.setSex("男");
	    
	Student student322 = new Student();
	student322.setName("山口裡菜");
	student322.setSex("女");
	    
	Student student323 = new Student();
	student323.setName("一生懸命");
	student323.setSex("男");
	// ******************************************************************************
	    
	    
	    
	    
	    
	    
	    
	    
	    
    // 開啟階段
	Session session = HibernateXMLUtil.getSession();
	    
	// 開啟交易
	Transaction trans = session.beginTransaction();
	    
	// 持久化物件
	session.persist(clazz31);
	session.persist(student311);
	session.persist(student312);
	   
	session.persist(clazz32);
	session.persist(student321);
	session.persist(student322);
	session.persist(student323);
	    
	    
	    
	// 設定班級，由於控制權設定在多方，因此要透過  student 來儲存實體間的關聯
	// 三年一班的學生
	student311.setClazz(clazz31);
	student312.setClazz(clazz31);
	    
	// 三年二班的學生
	student321.setClazz(clazz32);
	student322.setClazz(clazz32);
	student323.setClazz(clazz32);
	    
	    
	    
	// 儲存相依關係
	// 三年一班
	session.save(student311);     
	session.save(student312);    
	
	// 三年二班
	session.save(student321);
	session.save(student322);
	session.save(student323);
	    
	   
	// 傳送交易
	trans.commit();
	    
	    
	   
	    
	    
	    
    // 開啟交易
    trans = session.beginTransaction();
	 
	    
	    
	// *************************************************************************************************************************************************
	// 查詢名為"三年一班"的班級
	Clazz c1 = (Clazz)session.createQuery("select c from Clazz c where c.name = :name ").setParameter("name","三年一班").uniqueResult();  // 傳回單一實體  
	    
	// 重新從資料庫獲得資料
	session.refresh(c1);

	System.out.println("(1)三年一班的所有學生");
	for(Student s:c1.getStudents()){
	  System.out.println("\t 姓名："+s.getName()+",性別："+s.getSex());
	} // end for(Student s:c.getStudents()){
	    
	// 查詢班級
	List<Student> students1 = session.createQuery("select s from Student s where s.clazz.name = :name ").setParameter("name","三年一班").list();
	System.out.println("(2)三年一班的所有學生");
	for(Student s:students1){
	  System.out.println("\t 姓名："+s.getName()+",姓名："+s.getSex());	
	} // end for(Student s:students){
	// *************************************************************************************************************************************************
	    
	    
	    
	    
	    
	// *************************************************************************************************************************************************
    // 查詢名為"三年二班"的班級
	Clazz c2 = (Clazz)session.createQuery("select c from Clazz c where c.name = :name ").setParameter("name","三年二班").uniqueResult(); // 傳回單一個實體
	    
	// 重新從資料庫獲得資料
	session.refresh(c2);
	    
	System.out.println("(3)三年二班的所有學生");
	for(Student s:c2.getStudents()){
	  System.out.println("\t 姓名："+s.getName()+",性別："+s.getSex());	
	} // end for(Student s:c2.getStudents()){
	    
	// 查詢班級
	List<Student> students2 = session.createQuery("select s from Student s where s.clazz.name = :name ").setParameter("name","三年二班").list();
	System.out.println("(4)三年二班的所有學生");
	for(Student s:students2){
	  System.out.println("\t 姓名："+s.getName()+",姓名："+s.getSex());	
	} // end for(Student s:students2){
	// *************************************************************************************************************************************************
	    
	    
	// 傳送交易
	trans.commit();
	    
	// 關閉階段
	session.close();
	     
  }

}
