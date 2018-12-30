package com.helloweenvsfei.hibernate.bean;

import java.util.ArrayList;
import java.util.List;

public class Person3 {

	private Integer id; 
	private String name;                                     // 姓名
	private List<String> emails = new ArrayList<String>();   // List 屬性，直接存放郵寄地址

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

	public List<String> getEmails() {
		return emails;
	}

	public void setEmails(List<String> emails) {
		this.emails = emails;
	}

}
