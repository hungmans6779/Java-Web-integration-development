<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core"        prefix="c"   %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"         prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"   prefix="fn"  %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>JSTL escapeXml.jsp</title>
  </head>
  
  <body>   
    <c:import var="source" url="http://www.baidu.com" charEncoding="gbk"></c:import>
    <c:out value="${source}" escapeXml="true"></c:out>
    <hr/>
    ${ fn:escapeXml(source) }
<hr>
  </body>
</html>
