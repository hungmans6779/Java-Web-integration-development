package com.helloweenvsfei.hibernate.bean;

import java.util.ArrayList;


import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/*
 * 實體類別(Entity)是指與資料庫有映射關係的Java 類別，一般推薦使用POJO。例如此類別是普通的JavaBean 類別，
 * 所有屬性都是對應的getter、setter 方法。但是使用 @Entity 設定後，Cat 類別就被宣告為了一個實體類別。
 * 實體類別還需要設定對應的表名(用@Table 設定)、主鍵(用@Id設定)、普通屬性(用@Column 設定)對應的列名等。程式碼如下：
 */


/*
 * 所有的 @註釋都是 javax.persistence.* 下的，而不是 org.hibernate.* 下。javax.persistence.* 下的註釋為  JPA 規範規定的註釋，
 * 用於標記實體類別與資料庫的映射關係，而 org.hibernate.* 下的註釋僅用於補充，當某個功能 JPA 暫時不支援而 Hibernate 支援時使用。
 */


// 使用 @註釋設定實體類別時，要使用@註釋設定命名查詢，用到的Java 註釋為 @NamedQuery 與 @NamedNativeQuery 。
// 其中，@NamedQuery 用於設定命名的HQL查詢。@NamedNativeQuery 用於設定命名的底層資料庫SQL 查詢。
// @NamedQuery(name="all cat",query="select c from tb_cat" )               // 命名查詢
// @NamedNativeQuery(name="all cat",query="select * from tb_cat ")

// 設定查詢擴充
// 命名查詢中，允許使用 @QueryHint 對命名查詢設定JPA 擴充。JPA 規範允許JPA 供應商(例如：Hibernate、TopLink、OpenJPA 等 ORMFramework)
// 對 JPA 進行一些功能上的擴充，以加速查詢性能、提供其他功能。例如：
// @NamedQuery(name="cat by name",query="select c from Cat c where c.name = :name",hints={@QueryHint(name="org.hibernate.callable",value="true")})


// 設定多個命名查詢
// 一個實體類別不能設定多個@NamedQuery。如果有多個命名查詢，需要使用 @NamedQuerties 設定。@NamedQuerties 中可以設定多個@NameQuery ，例如：
/*
@NamedQueries(value={ 
  @NamedQuery(name="all cat",query="select c from Cat c"),
  @NamedQuery(name="cat by name",query="select c from Cat c where c.name = :name"),
  @NamedQuery(name="cat by mother",query="select c from Cat c where c.mother.name =:name")
})
*/

@Entity                                          // 註釋 Entiry 表示該類別能被 Hibernate 持久化
@Table(name="tb_cat")                            // 指定該 Entity 對應的資料表名
public class Cat {

  public Cat(){}
  
  public Cat(String name,String description,Date createDate,Cat mother){
    this.name=name;
    this.description=description;
    this.createDate=createDate;
    this.mother=mother;
  }
	
  
  
  @Id                                            // 指定該列為主鍵。主鍵類型最好不要使用int 等原始類型。
  @Column(name="id")                             // 指定屬性對應的資料庫表的列為 「id」
  @GeneratedValue(strategy=GenerationType.AUTO)  // 主鍵類型， auto 為資料庫自增長類型 
  private Integer id;
  
  
  @Column(name="name")                           // 指定屬性對應的資料庫表的列為 「name」
  private String name;    
  
  
  @Column(name="description")                    // 指定屬性對應的資料庫表的列為 「description」
  private String description;
  
  
  @ManyToOne                                     // 指定POJO之間的關係，本例為多對一關係
  @JoinColumn(name = "mother_id")                // 指定屬性對應的資料庫表的列為 「mother_id」
  private Cat mother;                            // 對屬性對應的列
  
  
  @Temporal(TemporalType.TIMESTAMP)              // 日期類型(DATE,TIME 還是 TIMESTEMP)
  @Column(name="createDate")  
  private Date createDate;
  
  

  @OneToMany(mappedBy ="cat")
  private List<Event> events = new ArrayList<Event>();


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


  public String getDescription() {
	return description;
  }


  public void setDescription(String description) {
	this.description = description;
  }


  public Cat getMother() {
	return mother;
  }


  public void setMother(Cat mother) {
	this.mother = mother;
  }


  public Date getCreateDate() {
	return createDate;
  }


  public void setCreateDate(Date createDate) {
	this.createDate = createDate;
  }

  
  

  public List<Event> getEvents() {
	return events;
  }


  public void setEvents(List<Event> events) {
	this.events = events;
  }

  
  
}
