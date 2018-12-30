package com.helloweenvsfei.hibernate.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/*
 *     Address 位址實體類別具有id 主鍵、Customer 客戶屬性以及address 位址、zip 郵遞區號、telephone 電話號碼等3個普通屬性。
 *  id 主鍵用 @Id 標記。因為實體間使用相同的id ，因此不能使用任何的主鍵產生策略。Customer 屬性上用@OneToOne 指定為一對一屬性，
 *  並用 @PrimaryKeyJoinColumn 宣告使用相同主鍵。 
 */

@Entity
@Table(name = "tb_address")
public class Address {

	@Id                                                 // 主鍵
	// @GeneratedValue(strategy = GenerationType.AUTO)  // 不能使用資料庫自動分配 id
	private Integer id;

	@OneToOne                                           // 一對一關聯性
	@PrimaryKeyJoinColumn                               // 一對一實體的主鍵相同 
	private Customer customer;

	// 位址，使用預設設定
	private String address;

	// 郵遞區號，使用預設設定
	private String zip;

	// 電話號碼，使用預設設定
	private String telephone;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

}
