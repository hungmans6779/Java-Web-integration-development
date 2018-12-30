<%@ page language="java" import="java.util.*" pageEncoding="BIG5" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'elTest02.jsp' starting page</title>
  </head>
  
  <body>
    <%
       request.setAttribute("userName","kevin");
       session.setAttribute("age","33");
    %>
    name:${userName}<br>
    age:${age}<br> 
  </body>
</html>
