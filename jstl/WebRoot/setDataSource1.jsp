<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core"       prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"        prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql"        prefix="sql" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>JSTL setDataSource.jsp</title>
  </head>
  
  <body>
    <%-- \WEB-INF\context.xml --%>
   <sql:setDataSource dataSource="jdbc/jstl" var="serverDataSource" />
        資料來源：${serverDataSource}<br>
  </body>
</html>
