package com.helloweenvsfei.hibernate.bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

/**
 *  Person2 有id 主鍵，name 屬性、以及一個List<Email> 類型的一對多屬性。Person2 的資料儲存在表 tb_person2。 
 *  Person2 實體類別中使用 @OneToMany 設定一對多關聯性。fetch 設定載入方式(延遲載入(FetchType.LAZY)或者即時載入(FetchType.EAGER) )。
 *  
 *  targetEntity 中設定集合屬性中的類型，由於emails 屬性類型為 List<Email>，用泛型指定了集合內為 Email 物件，因此 targetEntity 可以省略。
 *  
 *  cascade 設定串聯的方式，本例設定為PERSIST、REMOVE、MERGE、REFRESH，表示在儲存、刪除、修改、更新 Person2 類別時，會自動在資料表中儲存、刪除、修改、更新屬性它的Email 物件。
 *  設定串聯關係後，可以透過操作 Person 類別來操作 Email 類別。該設定也等同於 CascadeType.ALL。
 *  
 *  @OrderBy 設定排序的方式，本例將Email 按照 email 列降冪排列。
 */



@Entity                                           // 宣告為實體類別
@Table(name="tb_person2")                         // 宣告表名
public class Person2 {
 
  @Id                                             // 宣告主鍵
  @GeneratedValue(strategy=GenerationType.AUTO)   // 宣告主鍵產生規則
  private Integer id;
  
  
  private String name;
 
  
  @OneToMany(fetch=FetchType.EAGER,targetEntity=Email.class,cascade={CascadeType.PERSIST,CascadeType.REMOVE,CascadeType.MERGE,CascadeType.REFRESH})
  // 給範例 TestLazyInitializationException 測試延時載入所出現的Exception
  // @OneToMany(fetch=FetchType.LAZY,targetEntity=Email.class,cascade={CascadeType.PERSIST,CascadeType.REMOVE,CascadeType.MERGE,CascadeType.REFRESH})
  @JoinColumns(value={@JoinColumn(name="person_id",referencedColumnName="id")})
  @OrderBy(value="email desc")
  private List<Email> emails = new ArrayList<Email>();


  public Integer getId() {
	return id;
  }


  public void setId(Integer id) {
	this.id = id;
  }


  public String getName() {
	return name;
  }


  public void setName(String name) {
	this.name = name;
  }


  public List<Email> getEmails() {
	return emails;
  }


  public void setEmails(List<Email> emails) {
	this.emails = emails;
  }



  
  
  
}
