package com.helloweenvsfei.hibernate.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity                      // 設定實體類別
@Table(name = "tb_type")     // 資料表名稱
public class Type {          

	@Id                                                // id 主鍵                              
	@GeneratedValue(strategy = GenerationType.AUTO)    // 自動
	private Integer id;

	
	// @Column(unique = true)                             // 利用 unique 約束禁止重覆資料
	private String name;                               // name 屬性

	
	
	
	
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

}
