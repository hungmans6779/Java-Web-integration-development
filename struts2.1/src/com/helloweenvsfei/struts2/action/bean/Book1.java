package com.helloweenvsfei.struts2.action.bean;

import java.sql.Date;



/*
 * ※POJO 極重要的觀念※
 【POJO】(Plain Old Java Object): 具有業務邏輯處理的規則的 Java 對象（regular java objects）
 參閱：http://supermand9362787.wordpress.com/
 Java 對象不是 JavaBean、EntityBeans（EJB的一種）。
 POJO一個正規的Java對象（不是JavaBean，EntityBean等），也不擔當任何的特殊的角色，也不實現任何Java框架指定的接口。

 POJO 應該不是我們開始認為的 JavaBean，當然更不是 EJB，它不應該依賴於框架即繼承或實現某些框架類或接口。
 例如：Struts1中的 Action 和 ActionForm 當然不屬於POJO了，
 而在 Struts2 中的 Action 由於可以不繼承任何的接口，所以在這種情況下 Action 是 POJO，
 但是 Struts2 中的 Action 也可以繼承 ActionSupport 類就不再屬於POJO了。
 POJO 裡面是可以包含業務邏輯處理和持久化邏輯，也可以包含類似與JavaBean屬性和對屬性訪問的 set 和 get 方法的。
 最後，我們總結一下給一個定義
 POJO 是一個簡單的、正規Java對象，它包含業務邏輯處理或持久化邏輯等，
 但不是JavaBean、EntityBean等，不具有任何特殊角色和不繼承或不實現任何其它Java框架的類別或接口。

 http://dev.firnow.com/course/3_program/java/javashl/200845/108451.html
 */

// POJO

/*
 * Struts2.x 有一個預設的日期類型轉化器，但是功能有限，只能轉化形如 "2012-09-13" 的日期，如果轉化失敗，還會拋出例外。  
 */
public class Book1 {

	private String name;            // 書名
	private String author;          // 作者
	private Date publishedDate;     // 出版日期
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}


	
}
