package com.helloweenvsfei.dao.dao.impl;


import java.util.ArrayList;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.object.SqlFunction;

import com.helloweenvsfei.dao.dao.IPersonDAO;
import com.helloweenvsfei.dao.dao.PersonMappingQuery;
import com.helloweenvsfei.dao.dao.UpdateCreditRating;
import com.helloweenvsfei.dao.bean.Person;



public class PersonDAOImpl extends JdbcDaoSupport implements IPersonDAO {

	
	// 初始化資料表
	public void initDatabase(){
	  StringBuffer sqlStr = new StringBuffer();
	  sqlStr.append(" create table if not exists tb_person      \n");  
	  sqlStr.append("  (                                        \n");  
	  sqlStr.append("    id int auto_increment,                 \n");
	  sqlStr.append("    name varchar(255),                     \n");  
	  sqlStr.append("    sex varchar(10),                       \n");  
	  sqlStr.append("    age int,                               \n");  
	  sqlStr.append("    birthday timestamp,                    \n");  
	  sqlStr.append("    primary key (id)                       \n");  
	  sqlStr.append("  )                                        \n");  

	  getJdbcTemplate().execute(sqlStr.toString());	
	} // end public void initDatabase(){
	
	

	
	
	
	// 增加 Person 物件
	public void addPerson(Person person) {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("  insert into tb_person               \n");
      sqlStr.append("    (name, sex,  age,  birthday)      \n");
      sqlStr.append("    values                            \n");
      sqlStr.append("    (?,    ?,    ?,    ?)             \n");
      

      getJdbcTemplate().update(sqlStr.toString(),
    		                   new Object[]{
    	                                     person.getName(),
    	                                     person.getSex(),
    	                                     person.getAge(),
    	                                     person.getBirthday()
    	                                   });
      
	} // end public void addPerson(Person person) {
	
	
	

	
	// 傳回所有Person 的數目 
	public int getPersonsCount() {
      String sql = " select count(*) from tb_person  ";
	  return getJdbcTemplate().queryForInt(sql);
	}

	
	
	
	
	// 根據 id 獲得Person 姓名  
	public String getPersonName(Integer id) {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("  select name from tb_person   \n");
      sqlStr.append("    where id = ?               \n");
       
	  return (String)getJdbcTemplate().queryForObject(sqlStr.toString(),new Object[]{id},String.class);
	} // end public String getPersonName(Integer id) {
	
	
	

	
	
	// 傳回所有的Person 
	public List<Person> listPersons() {

	  StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("  select id,name,sex,age,birthday    \n");
      sqlStr.append("    from tb_person                   \n");
     
      List<Map<String,Object>> list = getJdbcTemplate().queryForList(sqlStr.toString());
	  List<Person> personList = new ArrayList<Person>();
      for(Map <String,Object> row : list){
    	Person person = new Person();
    	person.setId((Integer)row.get("id"));
    	person.setName((String)row.get("name"));
        person.setSex((String)row.get("sex"));
    	person.setAge((Integer)row.get("age"));
    	person.setBirthday((Date)row.get("birthday"));  
    	
    	personList.add(person);       // 增加到list
      } // end for(Map<String,Object>row:list){
      
	  return personList;  // 傳回 list
	} // end public List<Person> listPersons()

	
	
	
	
	
	
	
	
	
	// 實作使用 MappingSqlQuery 的抽象類別封裝 Java 物件
	public List findAllPersons() {

	  PersonMappingQuery personQuery = new PersonMappingQuery();                 // 使用封裝查詢
	  
	  personQuery.setDataSource(getDataSource());                                // 設定資料來源
	  personQuery.setSql("select * from tb_person  ");                           // 設定 SQL
	  // personQuery.declareParameter(new SqlParameter(java.sql.Types.NUMERIC)); // 設定參數
	  personQuery.compile();                                                     // 檢查 SQL
	
	  return personQuery.execute(new Object[]{});                                // 直接封裝後的List
	} // end public List findAllPersons() {

	
	
	
    	
	public String testTransactions(Integer id) {
	  Person person = new Person();
	  person.setName("P.J.");
	  person.setSex("");
	  addPerson(person);
	  
	  return getPersonName(id);
	} // end public void testTransactions() {

	
	
	
	
	// 實作使用 SqlUpdate
	public int sqlUpdate(Integer id,String sex){
	  UpdateCreditRating ucr = new UpdateCreditRating(getDataSource());
	  
	  return ucr.run(id,sex);	
	}

	
	public int countRows(){
	  SqlFunction sf = new SqlFunction(getDataSource(),"select count(*) from tb_person ");
	  sf.compile();
	  return sf.run();
	}
	
}
