<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>JSTL import.jsp</title>
  </head>
  
  <body>
    <c:import var="baidu" url="http://www.baidu.com" charEncoding="gbk" scope="request" ></c:import>
    Baidu 的源代码为：<c:out value="${ baidu }" escapeXml="true"/>
  </body>
</html>
