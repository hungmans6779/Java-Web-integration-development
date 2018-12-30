package com.helloweenvsfei.orm.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity                 // 實體類別設定
@Table(name="tb_cat")   // 資料表設定
public class Cat {

  @Id	                                         // 主鍵設定
  @GeneratedValue(strategy=GenerationType.AUTO)  // 主鍵規則設定
  private Integer id;
  
  private String name;                           // 使用預設設定
 
  @Temporal(value = TemporalType.TIMESTAMP)      // 列類型為 timestamp
  private Date createDate;


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


  public Date getCreateDate() {
	return createDate;
  }


  public void setCreateDate(Date createDate) {
	this.createDate = createDate;
  }
  
  
  
}
