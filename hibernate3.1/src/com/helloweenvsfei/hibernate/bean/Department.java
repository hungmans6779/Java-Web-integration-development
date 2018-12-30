package com.helloweenvsfei.hibernate.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;




/*
 *  部門實體類別
 *  多個 Employee 員工屬於某個 Department 部門，一個 Department 部門也可以有多個 Employee 員工。
 *  Employee 與 Department 之間是多對一的關係。另外，Department 部門實體類別有一個 lineManager 屬性，
 *  表示該部門的經理，該屬性與 Employee 是一對一的。 
 */


@Entity
@Table(name="tb_department")
public class Department {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;                                           // 主鍵
  
  private String name;                                          // 部門名稱
  
  private String description;                                   // 部門描述
  
  @OneToOne                                               
  @JoinColumn(name="line_manager_id")                           // 關聯的外鍵列
  private Employee lineManager;                                 // 經理屬性
  
  @OneToMany(mappedBy="department")                             // 對應 Employee 的 department 屬性
  private Set<Employee> employees = new HashSet<Employee>();    // 對應員工集合類別

  
  
  
  
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

  public String getDescription() {
	return description; 
  }

  public void setDescription(String description) {
	this.description = description;
  }

  public Employee getLineManager() {
	return lineManager;
  }

  public void setLineManager(Employee lineManager) {
	this.lineManager = lineManager;
  }

  public Set<Employee> getEmployees() {
	return employees;
  }

  public void setEmployees(Set<Employee> employees) {
	this.employees = employees;
  }
	
 
  
}
