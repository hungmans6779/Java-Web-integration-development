package com.helloweenvsfei.hibernate.bean;

import java.util.Date;

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

@Entity
@Table(name = "tb_event")
public class Event {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  
  private String description;

  
  @Temporal(TemporalType.TIMESTAMP)
  private Date createDate;

  
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "cat_id")
  private Cat cat;
  
  
  public Integer getId() {
	return id;
  }

  public void setId(Integer id) {
	this.id = id;
  }

  public String getDescription() {
	return description;
  }

  public void setDescription(String description) {
	this.description = description;
  }

  public Date getCreateDate() {
	return createDate;
  }

  public void setCreateDate(Date createDate) {
	this.createDate = createDate;
  }

  public Cat getCat() {
	return cat;
  }

  public void setCat(Cat cat) {
	this.cat = cat;
  }
  
  
}
