package com.helloweenvsfei.hibernate.bean;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/*
 *  Sailor 水手類別包括3個屬性：id 主鍵、name 姓名、ship 所在的船隻。name 姓名屬性是普通的 String 類型屬性，
 *  設定使用預設設定。ship 是個多對一的屬性、用 @ManyToOne 設定，用@JoinColumn 認定外鍵(也就是兩個表之間的關聯鍵)。
 */


// 水手類別
@Entity
@Table(name="tb_sailor")
public class Sailor {

  @Id                                                // 主鍵設定
  @GeneratedValue(strategy=GenerationType.AUTO)      // 主鍵產生策略設定
  private Integer id;  
  
  
  private String name;                                // 船員姓名(name 使用預設設定)
  
  
  @ManyToOne(cascade=CascadeType.PERSIST)           
  @JoinColumn(name="ship_id")                          // 外鍵為 ship_id
  private Ship ship;                                   // 水手對艦船是多對一
  
  
  @OneToOne(mappedBy="captain")    
  private Ship captainedShip;                          // 船長對艦船是一對一

  
  
  

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

  public Ship getShip() {
	return ship;
  }

  public void setShip(Ship ship) {
	this.ship = ship;
  }

  public Ship getCaptainedShip() {
	return captainedShip;
  }

  public void setCaptainedShip(Ship captainedShip) {
	this.captainedShip = captainedShip;
  }
  
   
  
  
}
