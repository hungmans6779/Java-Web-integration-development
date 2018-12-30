package com.helloweenvsfei.hibernate.bean;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/*
 *  Student 類別中有一個id 主鍵，以及 name 姓名、sex 性別等兩個普通屬性，還有一個 Clazz 類別的屬性clazz ，代表所在的班級。
 *  該屬性與 Clazz 中的List<Student>集合屬性是對應的。從邏輯上講，某student 的 clazz 屬性為某clazz ，則該clazz 的 List<Student>中必定含有該student。
 *  設定了mappedBy 後，Hibernate 能自動維護這種關係。
 *  
 *  Student 與 Clazz 是一對多的關係，一個多使用@ManyToOne 設定，另外用@JoinColumn 設定關聯的列名。
 *  這裡用 tb_student 表的class_id 列與 tb_class 的 id 主鍵列連接。這裡同時設定了串聯儲存類型為PERSIST，
 *  建立student 時，會自動將clazz 也寫進資料庫。
 *   
 */

@Entity                                               // Entity
@Table(name = "tb_student")                           // Table
public class Student {

	@Id                                               // ID
	@GeneratedValue(strategy = GenerationType.AUTO)   // GeneratedValue 設定
	private Integer id;

	
	// 班級屬性
	@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "class_id")  // 外鍵的屬性。(這裡把控制權交給了多方，也可以交給一方。當一方控制時，一方的設定同單邊的一對多關聯性設定完全相同。)
	private Clazz clazz;
	
	
	// 姓名
	private String name;

	
	// 性別
	private String sex;

	
	
	
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Clazz getClazz() {
		return clazz;
	}

	public void setClazz(Clazz clazz) {
		this.clazz = clazz;
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
	
	

}
