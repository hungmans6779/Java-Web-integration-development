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
  person.setAddress("北京市海淀区上地软件园");
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
   
  Person person3 = new Person();
  person3.setId(3);
  person3.setName("大刀王五");
  person3.setAge(10);
  person3.setSex("男");
  person3.setAddress("北京市东皇城根锡拉胡同");
  person3.setBirthday("2008-01-01");
  person3.setMobile("13820080808");
  person3.setTelephone("20054879");
  person3.setCity("北京");
  personList.add(person3);   
    
  Person person4 = new Person();
  person4.setId(4);
  person4.setName("小六");
  person4.setAge(18);
  person4.setSex("男");
  person4.setAddress("北京市东皇城根锡拉胡同");
  person4.setBirthday("2008-01-01");
  person4.setMobile("13820080808");
  person4.setTelephone("20054879");
  person4.setCity("北京");
  personList.add(person4);     
  request.setAttribute("personList",personList);
      
%> 
     
<html>
  <head>
    <title>JSTL forEachWithList1.jsp</title>
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
       <c:forEach items="${personList}" var="person" varStatus="varStatus" >
         <tr bgcolor="${varStatus.index%2==1?'#EFEFEF':'#FFFFFF' }" >
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
