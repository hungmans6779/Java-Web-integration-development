package com.helloweenvsfei.hibernate.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
/*
 *  Clazz 類別中有一個 id 主鍵，一個 name 屬性、另外還有一個List<Student> 類別的集合屬性，代表班級內的學生。
 *  班級與學生的關係是一對多的，這裡使用 @OneToMany 設定，並用 mappedBy 屬性設定與該 List<Student>屬性對應的是 Student 類別中的 clazz 屬性。
 *  實際上的關聯設定都在 Student 的 clazz 屬性上。 
 */


@Entity                     // Entity 設定
@Table(name = "tb_class")   // Table 設定
public class Clazz {

	
	// id 設定
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	
	// 班級名，使用預設設定
	private String name;

	
	// 所有學生
	// 班級與學生的關係是一對一
	@OneToMany(mappedBy = "clazz")  // OneToMany,使用反向設定
	@Cascade(value = CascadeType.DELETE_ORPHAN)
	private List<Student> students = new ArrayList<Student>();
    
	
	/*
	@OneToMany(mappedBy="clazz")
	@MapKey(name="name")
	private Map<String,Student> students = new HashMap<String,Student>();
	*/
	
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

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	
}
