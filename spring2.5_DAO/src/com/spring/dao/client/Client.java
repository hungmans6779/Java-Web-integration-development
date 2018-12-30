package com.spring.dao.client;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.spring.dao.IPersonDao;
import com.spring.entity.Person;


public class Client {

	
  public static void main(String[] args) {
	
	// 載入設定檔
	XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
	
	// 獲得 Peson DAO 物件
	IPersonDao personDao = (IPersonDao)factory.getBean("personDao");

	// 產生 Peson 物件
	Person person  = new Person();
	person.setName("kevin"); 
	person.setAge(35);
	person.setSex("男");
	person.setBirthday(new Date());
	
	
	// 增加到資料庫
	personDao.addPerson(person);
	
	
	// 傳回所有Person 的數目 
	int count = personDao.getPersonsCount();
	System.out.println("傳回所有Person 的數目,count = "+count);

	
	// 根據 id 獲得Person 姓名   
	String name = personDao.getPersonName(1);
	System.out.println("根據 id 獲得Person 姓名,name = "+name);

	
	// 傳回所有的Person 
	List<Person> personList = personDao.listPersons();
	System.out.println("傳回所有的personList    \n");
	for(Person p:personList){
	  System.out.println("Name："+p.getName());	
	} // end for(Person p:personList){
	
	
	
	System.out.println("\n");
	List<Person> personList1 = personDao.findAllPersons();
	System.out.println("傳回所有的personList1    \n");
	for(Person p:personList1){
	  System.out.println("Name："+p.getName());	
    } // end for(Person p:personList){
		
	
	
	System.out.println("\n");
	int count1 = personDao.sqlUpdate(8,"女");
	System.out.println("count1 = "+count1);
	
	
	
	System.out.println("\n");
	String name1 = personDao.testTransactions(15);
	System.out.println("name1 = "+name1);
	
  } // end main

   
}