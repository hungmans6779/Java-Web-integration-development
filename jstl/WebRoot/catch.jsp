<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
  <head>
    <title>JSTL catch.jsp</title>
  </head>
  
  <body>
  <c:catch var="e">
     <c:set target="someBean" property="somePropery" value="Some Value" ></c:set>
  </c:catch>
  <c:if test="${e!=null}" >
         程式拋出了例外${e.class.name},原因:${e.message}
  </c:if>
  
 
  </body>
</html>
