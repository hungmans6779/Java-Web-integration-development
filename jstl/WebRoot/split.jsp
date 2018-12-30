<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core"        prefix="c"   %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"         prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"   prefix="fn"  %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>JSTL split.jsp </title>
  </head>
  
  <body>
    ${ header['accept'] }
    <c:set value="${ fn:split(header['accept'], ',') }" var="names" />
    header['accept']: <br/><br/>
    <c:forEach items="${ names }" var="name">
	  ${ name } <br/>
    </c:forEach>
  </body>
</html>
