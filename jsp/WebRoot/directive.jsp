<%@ page language="java"  pageEncoding="BIG5"%>
<jsp:directive.page import="java.util.Date" />
<jsp:directive.include file="head.txt" />


<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'directive.jsp' starting page</title>
  </head>
  
  <body>
   <%
      Date today=new Date();
      out.println(today);
   %>
  </body>
</html>
