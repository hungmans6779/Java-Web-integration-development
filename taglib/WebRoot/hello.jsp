<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.helloweenvsfei.com/tags" prefix="taglib" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>TAGLIB hello.jsp</title>
  </head>
  
  <body>
    <taglib:hello name="kevin" /><br>
    <taglib:hello name="${pageContext.request.remoteAddr }" /><br>
    <taglib:hello name="${cookie}" /><br>
    <taglib:hello name="${cookie.JSESSIONID.value}" /><br>
  </body>
</html>
