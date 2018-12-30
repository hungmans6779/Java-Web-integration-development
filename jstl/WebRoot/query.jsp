<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core"       prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"        prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql"        prefix="sql" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>JSTL query.jsp</title>
    <style type="text/css">
      table {
      	border-collapse: collapse;
      	border: 1px solid #000000;
      }

      td {
	      border: 1px solid #000000;
	      padding: 2px;
      }

      .title td {
      	text-align: center;
	      background: #DDDDDD;
      }
    </style>
  </head>
  
  <body>
   <sql:setDataSource 
        driver="com.mysql.jdbc.Driver" 
        user="root"
        password="19786779"
        url="jdbc:mysql://localhost:3306/jstl?charachterEncoding=UTF-8"
        var="dataSource"
        scope="page" />

    <sql:query var="rs" dataSource="${ dataSource }" sql="select * from jstl.tb_corporation;" scope="page"  />

    <table>
      <tr class="title" >
        <td>ID</td>
        <td>Name</td>
        <td>Description</td>
      </tr>
      <c:forEach var="row" items="${rs.rows}" >
        <tr>
          <td>${row['ID']}</td>
          <td>${row['Name']}</td>
          <td>${row['Description']}</td>
        </tr>
      </c:forEach>
    </table>
      
  </body>
</html>
