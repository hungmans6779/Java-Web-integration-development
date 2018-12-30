package com.helloweenvsfei.hibernate.run;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.helloweenvsfei.hibernate.bean.Address;
import com.helloweenvsfei.hibernate.bean.Customer;
import com.helloweenvsfei.hibernate.util.HibernateUtil;

public class TestAnnotationedCustomerAddress {

  @SuppressWarnings("all")	
  public static void main(String[] args) {
   
	// **************************************************************************  
	// 第一位客戶資料
	Customer customer1 = new Customer();
	customer1.setName("kevin");
	
	Address address1 = new Address();
	address1.setAddress("台北市民生東路三段49號4樓");
	address1.setZip("104");
	address1.setTelephone("02-25010888 #607");
	// **************************************************************************
	

	// **************************************************************************  
	// 第二位客戶資料
	Customer customer2 = new Customer();
	customer2.setName("hungmans6779");
	
	Address address2 = new Address();
	address2.setAddress("台南市安南區郡安路xx路xx號");
	address2.setZip("777");
	address2.setTelephone("06-xxxxxxx");
	// **************************************************************************
	
	
	
	// 開啟階段 
	Session session = HibernateUtil.getSession();
	
	// 開啟交易
	Transaction trans = session.beginTransaction();
	
	// 儲存  customer1、customer2 物件, 資料庫會對 customer 自動分配ID
	session.persist(customer1);
    session.persist(customer2);

	// 用手工設定 address1、address2 的 ID 保證兩個ID 一致
	address1.setId(customer1.getId());
    address2.setId(customer2.getId());
	
    
	// 持久化物件,儲存 address1、address2
	session.persist(address1);
	session.persist(address2);
	
	
	// 輸出到用戶端瀏覽器
	session.flush();
	
	
	// 查詢名為kevin 的資料，傳回 list 物件
	List<Customer> list1= session.createQuery("select c from Customer c where c.name = :name").setParameter("name","kevin").list();
	for(Customer c:list1){  // 檢查 Customer
      session.refresh(c);  // 防止快取記憶體，從資料庫更新
      System.out.println("客戶姓名："+c.getName());
      System.out.println("\t 電話："+c.getAddress().getTelephone());
      System.out.println("\t 郵遞區號："+c.getAddress().getZip());
      System.out.println("\t 地址："+c.getAddress().getAddress());
	} // end for(Customer c:list){
	
	
	
	// 查詢名為hungmans6779 的資料，傳回 list 物件
	List<Customer> list2= session.createQuery("select c from Customer c where c.name = :name").setParameter("name","hungmans6779").list();
	for(Customer c:list2){  // 檢查 Customer
      session.refresh(c);  // 防止快取記憶體，從資料庫更新
      System.out.println("客戶姓名："+c.getName());
      System.out.println("\t 電話："+c.getAddress().getTelephone());
      System.out.println("\t 郵遞區號："+c.getAddress().getZip());
      System.out.println("\t 地址："+c.getAddress().getAddress());
	} // end for(Customer c:list){
	
	
	
	// 傳送交易
	trans.commit();
	
	// 關閉階段
	session.close();
	
  } // end main

}
