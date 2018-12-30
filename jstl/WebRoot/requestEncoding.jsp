<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>JSTL requestEncoding.jsp</title>
  </head>
  
  <body>
    <fmt:requestEncoding value="UTF-8" />
    
    <form action="${pageContext.request.requestURI}" method="post" >
               關鍵字:<input name="key" />
      <c:out value="${param.key}" default="請輸入關鍵字" ></c:out><br>
      <input type="submit" />
    </form>
  </body>
</html>
