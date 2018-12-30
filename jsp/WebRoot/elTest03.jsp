<%@ page language="java" import="java.util.*" pageEncoding="BIG5"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
    <title>My JSP 'elTest03.jsp' starting page</title>
  </head>
  
  <body>
    <%
       Enumeration ee=request.getHeaderNames();
       while(ee.hasMoreElements()){
         String name=(String)ee.nextElement();
         out.println(name+" = "+request.getHeader(name)+"<br>");
       }
    %>
    <hr>
    host:${header.host}<br>
    cookie:${header.cookie }<br>
  </body>
</html>
