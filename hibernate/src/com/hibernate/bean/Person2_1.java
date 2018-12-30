package com.hibernate.bean;

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


@Entity
// 宣告為實體類別
@Table(name = "tb_person2")
// 宣告資料表名
public class Person2_1 {

	@Id                                               // 宣告主鍵
	@GeneratedValue(strategy = GenerationType.AUTO)   // 宣告主鍵產生規則
	private Integer id;

	
	
	private String name; // name 屬性使用預設設定

	
	// 一對多的設定，並設定並列關係
	// fetch = FetchType.EAGER 實體載入
	// fetch = FetchType.LAZY 延遲載入
	@OneToMany(fetch = FetchType.LAZY,targetEntity = Email.class,			
			   cascade = {
			               CascadeType.PERSIST, 
			               CascadeType.REMOVE, 
		   	               CascadeType.MERGE,
			               CascadeType.REFRESH 
			             }
               )			
	@JoinColumns(value = { @JoinColumn(name = "person_id",referencedColumnName = "id") })
	@OrderBy(value = "email desc")  // 設定排序方式
	private List<Email> emails = new ArrayList<Email>();

	
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
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
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the emails
	 */
	public List<Email> getEmails() {
		return emails;
	}

	/**
	 * @param emails
	 *            the emails to set
	 */
	public void setEmails(List<Email> emails) {
		this.emails = emails;
	}

}