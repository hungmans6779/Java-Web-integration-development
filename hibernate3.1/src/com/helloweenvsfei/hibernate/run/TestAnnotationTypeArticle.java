package com.helloweenvsfei.hibernate.run;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.helloweenvsfei.hibernate.bean.Article;
import com.helloweenvsfei.hibernate.bean.Type;
import com.helloweenvsfei.hibernate.util.HibernateSessionFactory;

public class TestAnnotationTypeArticle {


	
  public static void main(String[] args) throws Exception {
	
	Type type = new Type();
	type.setName("學術論文");  // 類別名稱
	
	Article article = new Article();                                                                      // 論文
	article.setType(type);                                                                                // 設定類別
	article.setName("明清時代古典小說研究");                                                               // 論文標題
	article.setContent("明清時代是中國古典小說的高峰時期，湧現了一批經典的小說。四大名著便是產於這個時期。");  // 論文內容

	
	
	
	
	// 開啟階段 
	Session session = HibernateSessionFactory.getSession();
	
	// 開啟交易
	Transaction trans = session.beginTransaction();
	
	// 儲存到資料庫
	session.persist(article);
	
	
	
	StringBuffer sqlStr = new StringBuffer();
	sqlStr.append("    select a from Article a              \n");
	sqlStr.append("     where a.name like '%小說%'          \n");
    System.out.println("sqlStr:\n"+sqlStr.toString());

	List<Article> list = session.createQuery(sqlStr.toString()).list();
    for(Article a:list){
      System.out.println("*************************************************");
      System.out.println("類別："+a.getType().getName());
      System.out.println("標題："+a.getName());
      System.out.println("概要："+substring(a.getContent(),50));
      System.out.println("*************************************************");
    } // end for(Article a:list){
	
	
	
	// 關閉交易
	trans.commit();
	
	// 關閉階段
	session.close();
	
	
  } // end main
  
  
  
  private static String substring(String content,int i){
	 return (content == null?"":content.length()<(i+1)?content:content.substring(0,i)); 
  } // end substring
  

}
