package com.spring.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.object.MappingSqlQuery;

import com.spring.entity.Person;

/*
 *  MappingSqlQuery 是一個抽象類別，開發者需要實它的 mapRow(ResultSet,int) 方法實現從 ResultSet 到 Java 物件的映射。
 *  該方法直接傳回實體類別物件。 
 */
public class PersonMappingQuery extends MappingSqlQuery{

  // 封裝
  @Override
  protected Object mapRow(ResultSet rs,int columnIndex) throws SQLException {
	  
    Person person = new Person();                     // 產生實體一個 Person  
	person.setId(rs.getInt("id"));                    // 設定 id
	person.setName(rs.getString("name"));             // 姓名
	person.setSex(rs.getString("sex"));               // 性別
	person.setAge(rs.getInt("age"));                  // 年齡
	person.setBirthday(rs.getTimestamp("birthday"));  // 出生日期
	
	return person;
  } // end mapRow

  	
	
}
