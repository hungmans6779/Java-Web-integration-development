<%@ page language="java" import="java.util.*" pageEncoding="BIG5"%>
<jsp:directive.page errorPage="error.jsp" />

<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'exception.jsp' starting page</title>
  </head>
  
  <body>
   <%
     String str=null;
     int len=str.length();
   %>
  </body>
</html>
