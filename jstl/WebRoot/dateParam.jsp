<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core"       prefix="c"   %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"        prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql"        prefix="sql" %>

<jsp:useBean id="date" class="java.util.Date" ></jsp:useBean>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
  <head>
    <title>JSTL dateParam.jsp</title>
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

      <sql:setDataSource driver="com.mysql.jdbc.Driver" 
           user="root" password="19786779" 
           url="jdbc:mysql://localhost:3306/jstl?characterEncoding=UTF-8"
           var="dataSource" />

      <sql:update dataSource="${dataSource}" >
         CREATE TABLE if not exists tb_person(
              id       integer      auto_increment,
              name     varchar(255),
              birthday timestamp    null,
              primary key(id)
         );
      </sql:update>
      
      
      <sql:update dataSource="${dataSource}" >
          insert into tb_person(name,birthday) values (?,?)
          <sql:param value="Helloween" ></sql:param>
          <sql:dateParam value="${date}" type="timestamp" ></sql:dateParam>
      </sql:update>   
      
      
      <sql:query var="rs" dataSource="${dataSource}" >
         select * from tb_person where birthday > (? - 1)
         <sql:param value="${date}" ></sql:param>
      </sql:query>
      
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
      
  </body>
</html>
