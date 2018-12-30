


/*
  MySQL 中文亂碼處理方式
  參考網址 
  http://avrilnote.pixnet.net/blog/post/4652705-mysql%E4%B8%AD%E6%96%87%E4%BA%82%E7%A2%BC%E7%9A%84%E5%8E%9F%E5%9B%A0


  DateBase 設定：
  Connection URL： jdbc:mysql://localhost:3306/spring2_dao?characterEncoding=UTF-8
  Driver Class： com.mysql.jdbc.Driver

*/

 


 CREATE DATABASE spring2_orm DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;



 use spring2_orm;

 show variables like '%character%';

 show tables;

/* ---------------------------------------------------------------------------------  */


  create table if not exists tb_cat       
  (                                      
    id int auto_increment,             
    name varchar(255),                   
    createDate timestamp,
    primary key (id)                     
  )                             



select * from tb_cat;


 select name        
    from tb_cat   
   where id = 1;  


/* ---------------------------------------------------------------------------------  */



/* ---------------------------------------------------------------------------------  */