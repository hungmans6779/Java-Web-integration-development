<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"   %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"   prefix="fmt" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'parseDate.jsp' starting page</title>
  </head>
  
  <body>
    <fmt:parseDate var="date" value="2011-09-01 23:18:00" pattern="yyyy-MM-dd HH:mm:ss" parseLocale="zh_TW" ></fmt:parseDate>
	<fmt:formatDate value="${date}" type="both" dateStyle="full" timeStyle="full" timeZone="Asia/Taipei"  />
  </body>
</html>
