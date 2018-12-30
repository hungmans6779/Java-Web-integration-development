package com.hibernate.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity                   // 實體類別設定
@Table(name="tb_email")   // 對應的資料表
public class Email {      // Email 類別

  @Id                                            // 主鍵
  @GeneratedValue(strategy=GenerationType.AUTO)  // 自增長策略
  private Integer id;
 
  private String email;                          // 電子郵件

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
   * @return the email
   */
  public String getEmail() {
	return email;
  }

  /**
   * @param email the email to set
   */
  public void setEmail(String email) {
	this.email = email;
  }
  
  
}
