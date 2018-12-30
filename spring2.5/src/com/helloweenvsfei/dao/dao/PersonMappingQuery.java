package com.helloweenvsfei.dao.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.object.MappingSqlQuery;

import com.helloweenvsfei.dao.bean.Person;

// MappingSqlQuery 是一個抽象類別，開發者需要實現它的mapRow(ResultSet,int) 方法實現從ResultSet 到 Java 物件的映射。
// 該方法是傳回實體的類別物件。
public class PersonMappingQuery extends MappingSqlQuery {
  
  @Override
  protected Object mapRow(ResultSet rs,int columnIndex) throws SQLException{
	Person person = new Person();                    // 產生實䯤一個Person
	
	person.setId(rs.getInt("id"));                   // 設定id
	person.setName(rs.getString("name"));            // 設定name
	person.setSex(rs.getString("sex"));              // 設定 sex
	person.setAge(rs.getInt("age"));                 // 設定 age
	person.setBirthday(rs.getTimestamp("birthday")); // 設定 birthday
	
	return person;
  }
  
}
