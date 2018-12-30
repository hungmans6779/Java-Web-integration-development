package com.hibernate.bean;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
// @Entity 表示該類別能被 Hibernate 持久化
@Table(name = "tb_cat")
// 指定該 Entity 對應的資料表名
public class Cat {

	
	@Id
	// 指定該列為主鍵
	@GeneratedValue(strategy = GenerationType.AUTO)
	// 主鍵類型，auto 為自動增長類型
	private Integer id;

	
	
	@Column(name = "name")
	// 指定屬性對應的資料庫表的列為 name
	private String name;

	
	
	
	@Column(name = "description")
	// 指定屬性對應的資料庫表的列為 description
	private String description;

	
	
	@ManyToOne
	// 指定實體類別之間的關係，本例為多對一關係
	@JoinColumn(name = "mother_id")
	// 該屬性對應的列
	private Cat mother;

	
	
	@Temporal(TemporalType.TIMESTAMP)
	// 日期類型(DATE，TIME 還是TIMESTEMP)
	@Column(name = "createDate")
	private Date createDate;

	
	
	
	
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the mother
	 */
	public Cat getMother() {
		return mother;
	}

	/**
	 * @param mother
	 *            the mother to set
	 */
	public void setMother(Cat mother) {
		this.mother = mother;
	}

	/**
	 * @return the createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate
	 *            the createDate to set
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}
