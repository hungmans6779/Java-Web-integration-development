package com.helloweenvsfei.hibernate.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 *  Email 實體類別比較簡單，由於是單邊關係映射，Email 中沒有使用者實體的參考，只是一個簡單的POJO。
 *  但注意，與使用者的映射關係實際上儲存在該表上的 person_id 列中。 
 */


@Entity                                                  // 實體類別設定
@Table(name = "tb_email")                                // 對應的資料表
public class Email {                     

	@Id                                                  // 主鍵
	@GeneratedValue(strategy=GenerationType.AUTO)        // 自增長策略
	private Integer id;

	private String email;                                // 電子郵件

	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	


}
