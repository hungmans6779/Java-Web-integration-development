<%@ page language="java" import="java.util.*" pageEncoding="BIG5"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'elTest06.jsp' starting page</title>
  </head>
  
  <body>
    <%
      Cookie c1=new Cookie("kevin","33");
      response.addCookie(c1);
    %>
    ${cookie.kevin.value }<br>
    
  </body>
</html>
