<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
  
<html>
  <head>
    <title>JSTL forEachWithList</title>
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
