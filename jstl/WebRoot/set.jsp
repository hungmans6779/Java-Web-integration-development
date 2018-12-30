<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ page import="com.helloweenvsfei.jstl.bean.Person" %>
<%@ page import="java.util.HashMap" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>JSTL set.jsp</title>
  </head>
  
  <body>
   <c:set var="totalCount" value="${totalCount+1}" scope="application" ></c:set>
   <c:set var="count"  value="${count+1}" scope="session" ></c:set>
        本網站總存取人次：${totalCount }<br>
        其中你的存取次數：${count}<br>
        
        
   <c:set var="test" value="by value property" ></c:set>
   <c:set var="test" >by body</c:set>
   <c:out value="${test}" > </c:out><br>
   
   
   <%
     request.setAttribute("person",new Person());
     request.setAttribute("map",new HashMap());
   %>
   <c:set target="${person}" property="name" value="${param.name}" ></c:set>
    ${person.name}<br>
   <c:set target="${map}" property="name" value="${param.name}" ></c:set>
    ${map.name}<br>
  </body>
</html>
