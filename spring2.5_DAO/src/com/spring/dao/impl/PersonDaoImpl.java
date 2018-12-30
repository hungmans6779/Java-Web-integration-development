package com.spring.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.object.SqlFunction;

import com.spring.dao.IPersonDao;
import com.spring.entity.Person;


/*
 *  實作 Person 的 DAO 介面
 *  
 *  繼承 Spring 的 DAO 模組中的  JdbcDaoSupport 類別。  JdbcDaoSupport 提供了 JdbcTemplate 物件，封裝了常用的 JDBC 操作。
 *  PersonDaoImpl 中還定義了一個初始化方法，用於初始化表結構(如果不存在則建立)。
 *  
 *  由於程式碼直接繼承了 Spring 提供的 JdbcDaoSupport，因此沒有使用 Connection、 Statement 等 JDBC API，也不用關閉這些資源。
 *  JdbcDaoSupport 會自動維護這些資源。
 *  程式碼中用 Spring 封裝好的 JdbcTemplate 來執行 SQL、查詢 Person 清單、查詢單一 Person 屬性值、查詢 Person 的總數。
 *  查詢 Person 列表時傳回的是一個 List<Map<String,Object>> 類型資料。  
 */
public class PersonDaoImpl extends JdbcDaoSupport implements IPersonDao {


  // 初始化資料庫
  public void initDataBase(){
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
	
	System.out.println(PersonDaoImpl.class.getName()+",initDataBase()  execute...");
	System.out.println("sqlStr = "+sqlStr.toString());
	
	getJdbcTemplate().execute(sqlStr.toString());
  } // end initDataBase()
  
  
  
  
  
  

  // 增加Person 物件
  public void addPerson(Person person) {
	StringBuffer sqlStr = new StringBuffer();
    sqlStr.append("  insert into tb_person               \n");
    sqlStr.append("    (name, sex,  age,  birthday)      \n");
    sqlStr.append("    values                            \n");
    sqlStr.append("    (?,    ?,    ?,    ?)             \n");
   
    System.out.println(PersonDaoImpl.class.getName()+",addPerson(Person person) execute...");
	System.out.println("sqlStr = "+sqlStr.toString());
	
    
    getJdbcTemplate().update(sqlStr.toString(),new Object[]{
    	                                                      person.getName(),
    	                                                      person.getSex(),
    	                                                      person.getAge(),
    	                                                      person.getBirthday()});                                                
  } // end addPerson
  
  
  
  
  
  
  

  // 傳回所有Person 的數目 
  public int getPersonsCount() {
	StringBuffer sqlStr = new StringBuffer("select count(*) from tb_person ");
	  
	System.out.println(PersonDaoImpl.class.getName()+",getPersonsCount() execute...");
	System.out.println("sqlStr = "+sqlStr.toString());
	
	return getJdbcTemplate().queryForInt(sqlStr.toString());
  } // end  getPersonsCount()
  
  
  
  
  
  
  

  // 根據 id 獲得Person 姓名   
  public String getPersonName(Integer id){
	StringBuffer sqlStr = new StringBuffer();
	sqlStr.append("  select name        \n");
	sqlStr.append("    from tb_person   \n");
	sqlStr.append("   where id = ?      \n");
	 
	System.out.println(PersonDaoImpl.class.getName()+",getPersonName(Integer id)  execute...");
	System.out.println("sqlStr = "+sqlStr.toString());
	
	return (String)getJdbcTemplate().queryForObject(sqlStr.toString(),new Object[]{id},String.class);
  } // end getPersonName
  
  
  
  
  
  
  

  // 傳回所有的Person 
  @SuppressWarnings("all")
  public List<Person> listPersons(){
	StringBuffer sqlStr = new StringBuffer();
    sqlStr.append("  select id,name,sex,age,birthday    \n");
    sqlStr.append("    from tb_person                   \n");
   
	System.out.println(PersonDaoImpl.class.getName()+",listPersonss()  execute...");
	System.out.println("sqlStr = "+sqlStr.toString());

    List<Map<String,Object>> list = getJdbcTemplate().queryForList(sqlStr.toString());
        
    List <Person> personList = new ArrayList<Person>();
    Person person = null;
	for(Map<String,Object> row:list){
	  person = new Person();
	  person.setId((Integer)row.get("id"));
	  person.setName((String)row.get("name"));
	  person.setSex((String)row.get("sex"));
	  person.setBirthday((Date)row.get("birthday"));

	  personList.add(person);
	} // end for(Map<String,Object> row:list){
    
	return personList;
  } // end listPersons()
  
  
  
  
  
  
  

  // 傳回所有的Person(採用MappingSqlQuery 的)
  public List findAllPersons(){

    StringBuffer sqlStr = new StringBuffer();
	sqlStr.append("select * from tb_person   \n");
	  
	System.out.println(PersonDaoImpl.class.getName()+",findAllPersons() execute...");
	System.out.println("sqlStr = "+sqlStr.toString());
	
	/*
	 *  MappingSqlQuery 是一個抽象類別，開發者需要實它的 mapRow(ResultSet,int) 方法實現從 ResultSet 到 Java 物件的映射。
     *  該方法直接傳回實體類別物件。  
	 */
	PersonMappingQuery personQuery = new PersonMappingQuery();
	personQuery.setDataSource(getDataSource());       // 設定資料來源
	personQuery.setSql(sqlStr.toString());            // 設定 SQL
	personQuery.compile();
	  
	return personQuery.execute(new Object[]{});      // 直接封裝後的List 
  } // end findAllPersons()
  
  
  
  
  
  
  

  // 實作使用 SqlUpdate
  public int sqlUpdate(Integer id,String sex){
	
	/*
	 *  SqlUpdate 用來執行SQL 更新敘述，可以設定參數。可能與 JdbcDaoSupport 是一樣的。
     *  SqlUpdate 可以將某個功能模組化。
	 */
	UpdateCreditRating ucr = new UpdateCreditRating(getDataSource());
	
	return ucr.run(id,sex); 
  } // end sqlUpdate
  
  
  
  
  
  
  

  // 執行 SpringFramework SqlFunction 
  public int countRows() {
	  
	/*
	 *  SqlFunction 傳回單一行的查詢結果，預設傳回 int 類型。
	 *  開發者可以重載回其他類型的資料、功能相當於 JdbcTemplate 的 queryForInt()、queryForString()、queryForObject() 等。
	 *  
	 */
    SqlFunction sf = new SqlFunction(getDataSource(),"select count(*) from tb_person ")	;
    
    sf.compile();
    int count = sf.run();
    
	return count;
  } // end countRows()
  
  
  
  
  
  
  

  // 測試用的
  public String testTransactions(Integer id) {
	Person person = new Person();
	person.setName("B.J.");
	person.setSex("");
	addPerson(person);
	  
	return getPersonName(id);  
  } // end testTransactions
  
  
  
  
  
  
  


  
  
  
  
  


}
