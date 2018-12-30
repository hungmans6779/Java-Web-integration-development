
 CREATE DATABASE spring2_mvc DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

 DROP DATABASE spring2_mvc;

 use spring2_mvc;

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


 select name from tb_cat   
   where id = 1;  


/* ---------------------------------------------------------------------------------  */