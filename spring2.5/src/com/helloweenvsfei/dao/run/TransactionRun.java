package com.helloweenvsfei.dao.run;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.helloweenvsfei.dao.bean.Person;
import com.helloweenvsfei.dao.dao.IPersonDAO;

public class TransactionRun {
  
  private IPersonDAO personDao;	
  
  public IPersonDAO getPersonDao() {
	return personDao;
  }

  public void setPersonDao(IPersonDAO personDao) {
	this.personDao = personDao;
  }

  
  
  
  public void run(){
    
	Person person = new Person();
    person.setName("交易導回");
    person.setAge(999);
    person.setSex("第3性");
    person.setBirthday(new Date());
    
    personDao.addPerson(person);                                        // 儲存
    System.out.println("取得總筆數  Count:"+personDao.getPersonsCount()); // 取得總筆數
    
    // 會因資料庫沒有該筆紀錄而拋出例外的地方，中止transaction 交易
    System.out.println(personDao.getPersonName(Integer.MAX_VALUE));
    
    List<Person>personList = personDao.findAllPersons();
    for(Person p:personList){
      System.out.println("Name = "+p.getName());	
    } // end for(Person p:personList){ 
    
  } // end public void run(){
  

  
  
  
  // Spring 使用 DataSourceTransactionManager 作為JDBC 的交易管理者，同時把被管理的物件使用 TransactionProxyFactoryBean 設定。
  // 這是一個交易代理Bean，能夠使用IoC、AOP 等植入交易管理程式碼。例如為  TransactionRun 的 run() 方法設定交易。
  public static void main(String[] args) {
	  
    /*
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-dao.xml");		
    TransactionRun tr = (TransactionRun)context.getBean("transactionRun");
    */
	  
    // 載入設定檔
    XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext-dao.xml"));
    // 從設定檔中獲得物件
    TransactionRun tr = (TransactionRun)factory.getBean("transactionRun");
   
    tr.run();    // 執行 run。該方法已經被加上交易
  } // end run

  
  
  
  
}
