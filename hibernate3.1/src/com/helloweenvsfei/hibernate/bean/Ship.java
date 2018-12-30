package com.helloweenvsfei.hibernate.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/*
 *  Ship 艦船實體類別中包含4個屬性：id主鍵、name 船名、captain 船長、sailors 船員。
 *  其中 caption 船長是一對一的關係，一個船長只能一艘船(ship)，一艘船也只有一個船長(caption)。
 *  一對一屬性用 @OneToOne 設定 ，它的外鍵列用@JoinColumn 設定。注意 unique 屬性要設定為 true，
 *  利用資料庫的unique 約束保證一個船長不會被兩艘船使用。sailors 是個一對多屬性，
 *  使用@OneToMany 設定，用 mappedBy="ship" 指定實際設定在對方實體類別(也就是Sailor)的ship 屬性中。
 */

// 艦船類別
@Entity
@Table(name="tb_ship")
public class Ship {

	
  @Id                                                            // 主鍵設定
  @GeneratedValue(strategy=GenerationType.AUTO)                  // 主鍵產生策略設定
  private Integer id;                            
  
  private String name;                                           // 艦船名稱
  
  @OneToOne(cascade={CascadeType.PERSIST,CascadeType.REFRESH}) 
  @JoinColumn(name="captain_id",unique=true)                     // 外鍵為 captain_id(利用資料庫unique 約束保證船長是唯一的) 
  private Sailor captain;                                        // 船長
  
  @OneToMany(mappedBy="ship",cascade=CascadeType.PERSIST)        // 使用反向設定
  private Set<Sailor> sailors = new HashSet();                   // 船員(所有的水手)

  
  
  
  
  
  
  
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

  public Sailor getCaptain() {
	return captain;
  }

  public void setCaptain(Sailor captain) {
	this.captain = captain;
  }

  public Set<Sailor> getSailors() {
	return sailors;
  }

  public void setSailors(Set<Sailor> sailors) {
	this.sailors = sailors;
  }
  
  
  
  
  
  
  
}
