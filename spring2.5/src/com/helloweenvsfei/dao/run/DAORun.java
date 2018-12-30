package com.helloweenvsfei.dao.run;

import java.util.Date;

import java.util.List;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.helloweenvsfei.dao.dao.IPersonDAO;
import com.helloweenvsfei.dao.bean.Person;

public class DAORun {

	 
	/**
	 * @param args
	 */
	public static void main(String[] args){
	  
	  XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext-dao.xml"));	
	  
	  IPersonDAO personDao = (IPersonDAO)factory.getBean("personDAO");
	  
	  Person person = new Person();
	  person.setName("kevin - "+(personDao.getPersonsCount()+1));
	  person.setAge(35);
	  person.setSex("男");
	  person.setBirthday(new Date());
	  
	  personDao.addPerson(person);  // 增加到資料庫
	  System.out.println("Count："+personDao.getPersonsCount());
	  System.out.println(personDao.getPersonName(1)); // 查詢Person 姓名
	  
	  List <Person> personList = personDao.listPersons();
	  int count = 0;
	  for(Person p:personList){
		System.out.println("第 "+(++count)+"筆 , Name："+p.getName());  
	  }
	  
	  
	  
	  // 實作使用 MappingSqlQuery 的抽象類別封裝 Java 物件
	  System.out.println("實作使用 MappingSqlQuery 的抽象類別封裝 Java 物件");  
	  List<Person>personList1 = personDao.findAllPersons();
	  for(Person p:personList1){
		System.out.println("Names = "+p.getName());  
	  }
	  
	  System.out.println("testTransactions(1) = "+personDao.testTransactions(1));
	 
	  
	  // 實作使用 SqlUpdate
	  int updateResult = personDao.sqlUpdate(1,"大美女");
	  
	  
	  // 使用 SqlFunction 類別
	  int countRows = personDao.countRows();
	  System.out.println("總筆數 countRows = "+countRows);
	}
	

}
