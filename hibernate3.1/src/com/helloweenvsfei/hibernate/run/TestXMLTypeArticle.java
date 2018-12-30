package com.helloweenvsfei.hibernate.run;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.helloweenvsfei.hibernate.bean.Article;
import com.helloweenvsfei.hibernate.bean.Type;
import com.helloweenvsfei.hibernate.util.HibernateXMLUtil;

public class TestXMLTypeArticle {


  public static void main(String[] args) {
	
	Type type = new Type();
	type.setName("學術論文");

	Article article = new Article();
	article.setType(type);
	article.setName("明清時代古典小說研究");
	article.setContent("明清時代是中國古典小說的高峰時期，湧現了一批經典的小說。四大名著便是產於這個時期。");
	
	
	// 開啟階段
	Session session = HibernateXMLUtil.getSession();
	
	// 開啟交易
	Transaction trans = session.beginTransaction();
	
	
	session.persist(article);
	
	
	StringBuffer sqlStr = new StringBuffer();
	sqlStr.append("  select a from Article a       \n");
	sqlStr.append("   where a.name like '%明清%'   \n");
	
	
	
	List<Article> list = session.createQuery(sqlStr.toString()).list();
	for(Article a:list){
	  System.out.println("類別："+a.getType().getName());
	  System.out.println("標題："+a.getName());
	  System.out.println("概要："+substring(a.getContent(),50));
	} // end for(Article a:list){
	
	
	// 關閉交易
	trans.commit();
	
	// 開關階段
	session.close();
		
  } // end main
  
  
  private static String substring(String content,int i){
	return content==null?"":content.length()<(i+1)?content:content.substring(0,i);  
  }

}
