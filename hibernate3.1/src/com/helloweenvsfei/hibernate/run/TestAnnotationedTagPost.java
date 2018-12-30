package com.helloweenvsfei.hibernate.run;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.helloweenvsfei.hibernate.bean.Post;
import com.helloweenvsfei.hibernate.bean.Tag;
import com.helloweenvsfei.hibernate.util.HibernateUtil;


@SuppressWarnings("all")
public class TestAnnotationedTagPost {
	
  public static void main(String[] args) {
	  
	  
    Tag tag1 = new Tag();
    tag1.setName("幽默");                               // 設定名稱
	
    Tag tag2 = new Tag();
    tag2.setName("浪漫");                               // 設定名稱
    
    
   
    Post post = new Post();                             // 建立Post
    post.setTilte("推薦一個好玩的廣告，很有浪漫氣息喔");  // 設定標題
    post.setContent("見視訊，自己看吧");                 // 設定內容
    
    // 設定兩個標籤
    post.getTags().add(tag1);
    post.getTags().add(tag2);
    
    
    
    
    
    
    // 開啟階段
    Session session = HibernateUtil.getSessionFactory().openSession();
    
    // 開啟交易
    Transaction trans = session.beginTransaction();
    
    // 持久化物件
    session.persist(post);  // 儲存進資料庫
    
    
    // 查詢標籤為"幽默"的帖子 
    // 注意程式碼中對多對多屬性的查詢，使用的是LEFT JOIN。翻譯成資料庫的SQL敘述後，這是一個跨三個表(標籤表、中間表、帖子表)的複雜查詢。
    List<Post> list = session.createQuery("select p from Post p left join fetch p.tags t where t.name =:name ").setParameter("name","幽默").list();
    
    System.out.print("與標籤「幽默」相關的帖子");
    // 輸出帖子主題及所有相關標籤
    for(Post p:list){
      System.out.println("標題："+p.getTilte());
      System.out.println("所屬標籤：");
      // 輸出所有的標籤
      for(Tag t:p.getTags()){
        System.out.println(t.getName()+",");	  
      } // end for(Tag t:p.getTags()){
      System.out.print("");
    } // end for(Post p:list){
    
    
    
    
    
    // 重新從資料庫中獲得資料
    session.refresh(tag1);
    
    
    
    
    System.out.println("標籤為「"+tag1.getName()+"」下的帖子：");
    for(Post p:tag1.getPosts()){
      System.out.println("標題："+p.getTilte());
      System.out.println("所屬標籤：");
      for(Tag t:p.getTags()){
    	System.out.println(t.getName()+",");
      }
      System.out.println();
    } // end for(Post p:tag1.getPosts()){
    
    
    // 執行交易
    trans.commit();
    
    
    // 關閉階段
    session.close();
    
    
  } // end main

}
