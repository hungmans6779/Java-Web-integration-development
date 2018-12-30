package com.helloweenvsfei.struts2.action.bean;

public class Magazine {
	
	
	private String name;    // 書名
	private double price;  // 價格

	
	public Magazine(){}
	
	
	//  建構函數
	public Magazine(String name,double price){
	  this.name = name;
	  this.price = price;
	} // end Magazine
	
	
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
