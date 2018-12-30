<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core"       prefix="c"   %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"        prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql"        prefix="sql" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'transaction.jsp' starting page</title>
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
           
           
      <c:catch var="e">
        <sql:transaction dataSource="${dataSource}" >
           
            <%-- 插入三條資料  --%>
           <c:forEach var="i" begin="1" end="3" >
             <sql:update var="result" >
               insert into tb_corporation (name,description) values('交易測試','交易測試');
             </sql:update>
                                   已插入一條<br> 
           </c:forEach>
           
           <%-- 插入一條資料，因為主鍵1已經存在，該SQL將執行失敗，導致交易失敗 --%>
           <sql:update var="result" >
             insert into tb_corporation (id,name,description) values(1,'交易測試','交易測試');
           </sql:update>

        </sql:transaction>
      </c:catch>     
     
      <c:if test="${e!=null}" >
        <div style="color:red" >操作例外，原因:${e.message}。交易已返回</div>
      </c:if>
       
      
      <br>
      
      <sql:query var="rs" dataSource="${dataSource}" >
         select * from tb_corporation
      </sql:query>
  
      <table>
        <tr class="title">
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
