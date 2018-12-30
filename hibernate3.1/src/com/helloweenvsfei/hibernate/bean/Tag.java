package com.helloweenvsfei.hibernate.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/*
 *      Tag 標籤實體類別只有一個id 主鍵及String 類型的name 普通屬性。Tag 對應的表為 tb_tag，
 *  主鍵使用資料庫自增長類型。name 表示為該Tag 的名稱， @Basic、@Column 等標籤都被省略，
 *  使用預設的設定(預設的列名為name)。因為某個流行的Tag 可能有非常多的帖子，因此出於效率考慮，
 *  Tag 中沒有設定對帖子的多對多屬性。
 */


@Entity                        // Entity 設定
@Table(name = "tb_tag")        // Table 設定
public class Tag {             // 標籤類別

	@Id                        // id 設定
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;        // 主鍵

	private String name;       // 標籤名稱,使用預設設定

	@ManyToMany(mappedBy="tags")
	private Set<Post> posts = new HashSet<Post>();

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

	public Set<Post> getPosts() {
		return posts;
	}

	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}

}
