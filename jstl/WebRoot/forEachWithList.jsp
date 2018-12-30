<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ page import="com.helloweenvsfei.jstl.bean.Person"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%
  List<Person>personList=new ArrayList<Person>();
    
  Person person=new Person();
  person.setId(1);
  person.setName("張三");
  person.setAge(20);
  person.setSex("男");
  person.setAddress("台北市民生東路三段49號");
  person.setBirthday("2008-08-08");
  person.setMobile("13820080808");
  person.setTelephone("69653234");
  person.setCity("北京");
  personList.add(person);
      
      
  Person person2 = new Person();
  person2.setId(2);
  person2.setName("李四");
  person2.setAge(20);
  person2.setSex("男");
  person2.setAddress("北京市东皇城根锡拉胡同");
  person2.setBirthday("2008-01-01");
  person2.setMobile("13820080808");
  person2.setTelephone("20054879");
  person2.setCity("北京");
  personList.add(person2);
      
      
  request.setAttribute("personList",personList);
      
%> 
     
<html>
  <head>
    <title>JSTL forEach</title>
    <style>
      table {
	      border-collapse: collapse;
	      border: 1px solid #000000;
      }
      td {
	      border: 1px solid #000000; 
	      font-size: 12px; 
	      padding: 2px; 
      }
      .title td {
	      text-align: center;
	      background: #cccccc; 
      }
    </style>
  </head>
  
  <body>
 
     
     <table>
       <tr class="title" >
         <td>編號</td>
         <td>姓名</td>
         <td>年齡</td>
         <td>性別</td>
         <td>城市</td>
         <td>地址</td>
         <td>生日</td>
         <td>手機</td>
         <td>電話</td>
       <tr>
       <c:forEach items="${personList}" var="person" >
         <tr>
           <td>${person.id}</td>
           <td>${person.name}</td>
           <td>${person.age}</td>
           <td>${person.sex}</td>
           <td>${person.city}</td>
           <td>${person.address}</td>
           <td>${person.birthday}</td>
           <td>${person.mobile}</td>
           <td>${person.telephone}</td>
         </tr> 
       </c:forEach> 
     </table>
  </body>
</html>
