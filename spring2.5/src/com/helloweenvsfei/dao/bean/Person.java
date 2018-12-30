package com.helloweenvsfei.dao.bean;

import java.util.Date;

// POJO 實體類別
public class Person {
	
	private Integer id;       // id
	private String name;      // 姓名
	private String sex;       // 性別
	private int age;          // 年齡
	private Date birthday;    // 生日

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

}
