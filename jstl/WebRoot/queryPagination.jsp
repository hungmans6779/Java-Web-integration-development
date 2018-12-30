<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ page import="com.helloweenvsfei.util.Pagination" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core"       prefix="c"   %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"        prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql"        prefix="sql" %>

<%
	request.setAttribute("pagination", new Pagination(request,response));
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>JSTL queryPagination.jsp</title>
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
        url="jdbc:mysql://localhost:3306/mysql?charachterEncoding=UTF-8"
        var="dataSource"
        scope="page" />

    <sql:query var="rs" dataSource="${ dataSource }" sql="select count(*) as count from help_topic" scope="page"  />

    <c:forEach var="row" items="${rs.rows}" >
       <jsp:setProperty name="pagination" property="recordCount" value="${row.count}" />
    </c:forEach>

    <sql:query var="rs" dataSource="${dataSource}" 
               startRow="${pagination.firstResult}" maxRows="${pagination.pageSize}"
               sql="select * from help_topic"  scope="page"  /> 
    
    <table>
      <tr class="title" >
        <td>Help_ID</td>
        <td>Name</td>
        <td>Description</td>
      </tr>
      <c:forEach var="row" items="${rs.rows}" >
        <tr>
          <td>${row['help_topic_id']}</td>
          <td>${row['name']}</td>
          <td>${row['description']}</td>
        </tr>
      </c:forEach>
    </table>
    <br>
    ${pagination}  
  </body>
</html>
