<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"   %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"   prefix="fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'formatDate.jsp' starting page</title>
  </head>
  
  <body>
    <jsp:useBean id="currDate" class="java.util.Date" ></jsp:useBean>
    <fmt:formatDate value="${currDate}" pattern="yyyy/MMdd HH:mm:ss:sss"/>
  </body>
</html>
