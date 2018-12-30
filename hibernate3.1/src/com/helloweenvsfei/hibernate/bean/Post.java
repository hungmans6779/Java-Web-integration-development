package com.helloweenvsfei.hibernate.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


/*
 *      Post 帖子實體類別中有 id 主鍵，標題、內容等普通屬性，還有一個Set <Tag> 類型的多對多集合屬性tags。從 Java 程式碼上看，
 *  一對多屬性與多對多屬性沒什麼區別，都是Set 或者是List 類型的集合物件屬性。但是它們的Hibernate 設定是完全不一樣的，儲存機制也是完全不一樣的。
 *      id 主鍵使用資料庫自增長類型，標題title 使用Hibernate 預設設定，內容 content 使用 @Column 的 columnDefinition 指定在資料庫中使用 text 大文字類型。
 *      而在多對多屬性 tags 上，使用 @ManyToMany 指定該列為多對多屬性，fetch 設定載入方式，cascade 設定多聯儲存屬性。多對多屬性必然使用 @JoinTable 指定中間表的設定，
 *  其中 name 指定表名，joinColumn 指定該表(也就是Post 對應的表)
 *  與中間表的對應關係，inverseJoinColumns 指定另一端(也就是Tag 對應的表)與中間表的對應關係。
 */

@Entity                                                 // 實體類別設定
@Table(name = "tb_post")                                // Table 設定
public class Post {

	
	@Id                                                 // id 設定
	@GeneratedValue(strategy = GenerationType.AUTO) 	// 自增長
	private Integer id;

	
	@ManyToMany(fetch=FetchType.EAGER,cascade={CascadeType.PERSIST})
	@JoinTable(                                         // 中間表關係
	  name="tb_tag_post",
	  joinColumns = @JoinColumn(name = "post_id",referencedColumnName="id"),
	  inverseJoinColumns = @JoinColumn(name="tag_id",referencedColumnName="id")
	)
	private Set<Tag> tags = new HashSet<Tag>();

		
 	private String tilte;                               // 標題，使用預設設定                         

	@Column(columnDefinition = "text")                  // 資料庫中該列為 text 類型
	private String content;                             // 內容

	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Set<Tag> getTags() {
		return tags;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}

	public String getTilte() {
		return tilte;
	}

	public void setTilte(String tilte) {
		this.tilte = tilte;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
