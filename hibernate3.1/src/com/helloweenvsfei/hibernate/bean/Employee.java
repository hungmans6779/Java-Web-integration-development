package com.helloweenvsfei.hibernate.bean;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/*
 * 注意：birthday 屬性是 java.sql.Date 類型的，已經很明確只有年 月 日 資訊，因此不需要再用 @Temporal(TemporalType.DATE) 特別宣告。
 * 同理，startTime、endTime 也不需要特別宣告。但是 dateCreated 屬性是 java.util.Date 類型，需要使用 @Temporal(TemploralType.TIMESTAMP) 宣告。 
 */

@Entity
@Table(name="tb_employee")
public class Employee {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)                 // 主鍵策略，自動產生
  private Integer id;                                           // 主鍵
  
  private String name;                                          // 姓名
  
  private String sex;                                           // 性別
  
  private Integer age;                                          // 年齡
  
  private Date birthday;                                        // 生日， java.sql.Date 類型
  
  private Time startTime;                                       // 上班時間，Time 類型
  
  private Time endTime;                                         // 下班時間，Time 類型
  
  private double salary;                                        // 薪水，double 類型
  
  @Basic(fetch=FetchType.LAZY)                                  // 備註，大欄位延遲載入
  @Column(columnDefinition="longtext")                          // 資料庫使用 LONGTEXT 類型
  private String description;                                   // 備註
  
  @Temporal(TemporalType.TIMESTAMP)                             // 時間戳記類型
  private java.util.Date dateCreated;                           // 建立時間，java.util.Date 類型
  
  private boolean disabled;                                     // 是否被阻止，boolean 類型

  
  @ManyToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE})
  @JoinColumn(name="department_id")                             // 關聯外鍵列
  private Department department;                                // 部門屬性
  
  
  
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

  public String getSex() {
	return sex;
  }

  public void setSex(String sex) {
	this.sex = sex;
  }

  public Integer getAge() {
	return age;
  }

  public void setAge(Integer age) {
	this.age = age;
  }

  public Date getBirthday() {
	return birthday;
  }

  public void setBirthday(Date birthday) {
	this.birthday = birthday;
  }

  public Time getStartTime() {
	return startTime;
  }

  public void setStartTime(Time startTime) {
	this.startTime = startTime;
  }

  public Time getEndTime() {
	return endTime;
  }

  public void setEndTime(Time endTime) {
	this.endTime = endTime;
  }

  public double getSalary() {
	return salary;
  }

  public void setSalary(double salary) {
	this.salary = salary;
  }

  public String getDescription() {
	return description;
  }

  public void setDescription(String description) {
	this.description = description;
  }

  public java.util.Date getDateCreated() {
	return dateCreated;
  }

  public void setDateCreated(java.util.Date dateCreated) {
	this.dateCreated = dateCreated;
  }

  public boolean isDisabled() {
	return disabled;
  }

  public void setDisabled(boolean disabled) {
	this.disabled = disabled;
  }

  public Department getDepartment() {
	return department;
  }

  public void setDepartment(Department department) {
	this.department = department;
  }
  

  
}
