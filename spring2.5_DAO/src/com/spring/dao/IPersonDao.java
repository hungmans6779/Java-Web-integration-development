package com.spring.dao;

import java.util.List;

import com.spring.entity.Person;

/*
 *  Person 的 DAO 介面
 */
public interface IPersonDao {
 
  // 根據 id 獲得Person 姓名   
  public String getPersonName(Integer id);
	      
  // 增加Person 物件
  public void addPerson(Person person);
		    
  // 傳回所有Person 的數目 
  public int getPersonsCount();
	  
  // 傳回所有的Person 
  public List<Person>listPersons();

  
  public List findAllPersons();
	
  
  public String testTransactions(Integer id);
	
  
  public int sqlUpdate(Integer id,String sex);
	
  
  public int countRows();
  
}
