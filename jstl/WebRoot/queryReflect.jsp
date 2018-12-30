<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core"       prefix="c"   %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"        prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql"        prefix="sql" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>JSTL queryReflect.jsp</title>    
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
    <form method="get" action="${pageContext.request.requestURI}" >
      <textarea name="sql" cols="100" rows="10" >${param.sql}</textarea><br>
      <input type="submit" />
    </form>
    
    <sql:setDataSource driver="com.mysql.jdbc.Driver" 
         user="root" password="19786779" 
         url="jdbc:mysql://localhost:3306/mysql?characterEncoding=UTF-8"
         var="dataSource" />
         
         
    <c:catch var="e" >
      <sql:query var="rs" dataSource="${dataSource}" sql="${param.sql}" />
        
      <table>
        <tr class="title" >
          <c:forEach var="columnName" items="${rs.columnNames}" >
            <td>${columnName}</td>
          </c:forEach>
        </tr>
        
        <c:forEach var="row" items="${rs.rows}" >
          <tr>
            <c:forEach var="columnName" items="${rs.columnNames}" >
              <td>${row[columnName]}</td>
            </c:forEach>
          </tr>
        </c:forEach>
        
      </table>
      
      
    </c:catch>
    
    
    <c:if test="${e!=null}" >
      <div style="color:#FF0000;" >出現 Exception：${e.message}</div>
    </c:if>
         
  </body>
</html>
