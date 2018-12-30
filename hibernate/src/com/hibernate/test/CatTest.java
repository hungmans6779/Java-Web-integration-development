package com.hibernate.test;

import java.awt.Font;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.bean.Cat;
import com.hibernate.util.HibernateUtil;

public class CatTest {
  
	
  public static void main(String args[]){
	  
	Cat monther = new Cat();
	monther.setName("Mary White");
	monther.setDescription("The Mama cat.");
	monther.setCreateDate(new Date());
	
	
	Cat kitty = new Cat();
	kitty.setMother(monther);
	kitty.setName("Kitty");
	kitty.setDescription("Hello Kitty.");
	kitty.setCreateDate(new Date());
	
	
	Cat mimmy = new Cat();
	mimmy.setMother(monther);
	mimmy.setName("Mimmy");
	mimmy.setDescription("Kitty's little twin sister.");
	mimmy.setCreateDate(new Date());
	
	
	
	
	// 開啟一個 Hibernate 對話
	Session session = HibernateUtil.getSessionFactory().openSession();
	
	// 開啟一個交易
	Transaction trans = session.beginTransaction();
	
	session.persist(monther);  // 將 monther 儲存進資料庫
	session.persist(kitty);    // 將 kitty 儲存進資料庫
	session.persist(mimmy);    // 將 mimmy 儲存進資料庫
	
	
	// 查詢資料中的所有的貓
	@SuppressWarnings("all")
	List <Cat> catList = session.createQuery(" from Cat").list();
	
	
	// 輸出查詢結果
	StringBuffer result = new StringBuffer();
	result.append("資料庫裡的所有的貓：\r\n\r\n");
	
	// 檢查
	for(Cat cc:catList){
	  result.append("貓 ："+cc.getName()+" , "); 
	  result.append("貓媽媽："+(cc.getMother()==null?" 沒有紀錄":cc.getMother().getName()));
	  result.append("\r\n");
	} // end for(Cat cc:catList){
	
	
	trans.commit();    // 傳送交易
	session.close();   // 關閉 Hibernate 對話
	
	
	// 用 Swing 顯示查詢結果
	JOptionPane.getRootFrame().setFont(new Font("Arial",Font.BOLD,14));
	JOptionPane.showMessageDialog(null,result.toString());
	
  }
  
  
}
