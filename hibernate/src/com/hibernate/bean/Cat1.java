package com.hibernate.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity                // @Entity 表示該類別能被 Hibernate 持久化
@Table(name="tb_cat")  // 指定對 Entity 對應的資料表名
public class Cat1 {

	
  @Id // 指定該列為主鍵。主鍵類型最好不要使用 int 等原始類型(主鍵儘量使用可以為 null 型態的類別、例如Integer、Long、String 等)
  @GeneratedValue(strategy=GenerationType.AUTO) // 主鍵類型 auto 為資料庫自增長類型
  private Integer id;
  
  @Column(name="name")  // 指定屬性對應的資料庫的列為"name"
  private String name;
  
  @Column(name="description")  // @Column 與 name 均可省略
  private String description;
  
  
  @Temporal(TemporalType.TIMESTAMP)  // 日期類別(DATE,TIME 還是 TIMESTEMP)
  private Date createDate;


  /**
   * @return the id
   */
  public Integer getId() {
	return id;
  }


  /**
   * @param id the id to set
   */
  public void setId(Integer id) {
	this.id = id;
  }


  /**
   * @return the name
   */
  public String getName() {
	return name;
  }


  /**
   * @param name the name to set
   */
  public void setName(String name) {
	this.name = name;
  }


  /**
   * @return the description
   */
  public String getDescription() {
	return description;
  }


  /**
   * @param description the description to set
   */
  public void setDescription(String description) {
	this.description = description;
  }


  /**
   * @return the createDate
   */
  public Date getCreateDate() {
	return createDate;
  }


  /**
   * @param createDate the createDate to set
   */
  public void setCreateDate(Date createDate) {
	this.createDate = createDate;
  }
  
  
  
}
