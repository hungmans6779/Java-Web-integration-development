package com.helloweenvsfei.hibernate.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/*
 *      Customer 客戶實體類別中有一個id 主鍵、一個name 姓名屬性 以及一個Adress 位址屬性。其中 Adress 屬性位址與Customer 客戶實體類別之間是一對一的屬性，
 *  兩者之間使用相同的主鍵，而沒有使用傳統外鍵約束。用@OneToOne 指定  adress 屬性為一對一的，用@PrimaryKeyJoinColumn 指定兩個實體使用相同的主鍵。
 */

@Entity
@Table(name="tb_customer")
public class Customer {

  @Id                                            // id 設定
  @GeneratedValue(strategy=GenerationType.AUTO)  // 主鍵產生規則設定
  private Integer id;                                   
  
  
  private String name;                            // name 使用預設設定
  
  
  @OneToOne                                       // 宣告一對一關聯性
  @PrimaryKeyJoinColumn                           // 一對一實體的主鍵相同
  private Address address;                        // 位址屬性


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


  public Address getAddress() {
	return address;
  }


  public void setAddress(Address address) {
	this.address = address;
  }
  
  
  
  
  
  
}
