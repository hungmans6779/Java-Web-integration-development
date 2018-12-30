<%@ page language="java" import="java.util.*" pageEncoding="BIG5" %>

<%@ page isErrorPage="true" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'error.jsp' starting page</title>
  </head>
  
  <body>
    <%
      out.println("程式拋出一個例外："+exception);
    %>
  </body>
</html>
