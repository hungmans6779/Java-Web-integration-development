package com.helloweenvsfei.hibernate.run;

import java.awt.Font;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.helloweenvsfei.hibernate.bean.Cat;
import com.helloweenvsfei.hibernate.util.HibernateUtil;

public class CatTest01 {


  public static void main(String[] args) {
	
	Cat mother1 = new Cat();
	mother1.setName("Mary White");
	mother1.setDescription("The Mother's cat1.");
	mother1.setCreateDate(new Date());

	Cat mother2 = new Cat();
	mother2.setName("Helen Pink");
	mother2.setDescription("The Mother's cat2.");
	mother2.setCreateDate(new Date());
	
	
	Cat kitty = new Cat();
	kitty.setName("Kitty");
	kitty.setDescription("Hello Kitty.");
	kitty.setMother(mother1);   // 設定與 mother1 的母女關係(多對一的關係)
	kitty.setCreateDate(new Date());
		
	
	Cat mimmy = new Cat();
	mimmy.setName("Mimmy");
	mimmy.setDescription("Kitty's little twin sister. ");
	mimmy.setMother(mother1);  // 設定與 mother1 的母女關係(多對一的關係)
	mimmy.setCreateDate(new Date());
	
	
	Cat kevin = new Cat();
	kevin.setName("Kevin");
	kevin.setDescription("Kevin boy cat.");
	kevin.setMother(mother2);  // 設定與 mother2 的母女關係(多對一的關係)
	kevin.setCreateDate(new Date());
	
	
	
	
	
	// 開啟一個 Hibernate 對話
	Session session = HibernateUtil.getSessionFactory().openSession();
	
	// 開啟一個交易
	Transaction trans = session.beginTransaction();
	
	
	// 將相關的cat 物件儲存至資料庫
	session.persist(mother1);   // 將  mother1 儲存進資料庫
	session.persist(mother2);   // 將  mother2 儲存進資料庫
	session.persist(kitty);     // 將  kitty  儲存進資料庫
	session.persist(mimmy);     // 將  mimmy  儲存進資料庫
	session.persist(kevin);     // 將 kevin  儲存進資料庫
	
	
	// 查詢資料表內的所有貓
	// 設是一句 (HQL 語法：Hibernate Query Language，Hibernate 查詢敘述)，
	// 類似於SQL，不同的是HQL 裡使用的是 Entiry 類別名(Cat)
	@SuppressWarnings("all")
	// List<Cat> catList = session.createQuery(" from Cat").list();
	List<Cat> catList = session.createQuery("select c from Cat c").list();
	
	StringBuffer result = new StringBuffer();
	result.append("資料庫裡的所有貓：\r\n\r\n");
	for(Cat cat:catList){
	  result.append("貓："+cat.getName()+", ");	
	  result.append("貓媽媽："+(cat.getMother()==null?"沒有記錄":cat.getMother().getName()));
	  result.append("\r\n");
	} // end for(Cat cat:catList){
	
	
	
	// 傳送交易
	trans.commit();
	
	// 關閉  Hibernate 對話
	if(session!=null){ session.close();  }
	
	
	// 用 Swing 顯示查詢結果
	JOptionPane.getRootFrame().setFont(new Font("Arial",Font.BOLD,14));
	JOptionPane.showMessageDialog(null,result.toString());

  } // end void main

  
}
