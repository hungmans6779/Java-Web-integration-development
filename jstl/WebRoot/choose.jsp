<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head dir="">
    <title dir="">JSTL choose</title>
  </head>
  
  <body>
    <fieldset>
      <legend> action1 參數</legend>
      <c:choose>
        <c:when test="${param.action1}">when 標籤輸出</c:when>
        <c:otherwise>otherwise 標籤輸出</c:otherwise>
      </c:choose>
    </fieldset>
    <br>
    <fieldset>
      <legend> action2 參數</legend>
      <c:choose>
        <c:when test="${param.action2=='1' }" >1</c:when>
        <c:when test="${param.action2=='2' }" >2</c:when>
        <c:when test="${param.action2=='3' }" >3</c:when>
        <c:otherwise>其它值</c:otherwise>
      </c:choose>
    </fieldset>
  </body>
</html>
