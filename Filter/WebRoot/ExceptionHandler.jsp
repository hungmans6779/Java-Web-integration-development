<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ page import="com.helloweenvsfei.exception.AccountException"  %>
<%@ page import="com.helloweenvsfei.exception.BusinessException"  %>

<%
  String action=request.getParameter("action");
  
  if("businessException".equals(action)){
    throw new BusinessException("業務操作失敗 .");
  }else if("accountException".equals(action)){
    throw new AccountException("您需要登入後再進行此項操作 .");
  }else if("exception".equals(action)){
    Integer.parseInt("");
  }else{}

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'ExceptionHandler.jsp' starting page</title>
  </head>
  
  <body>
    This is my JSP page. <br>
  </body>
</html>

<a href="ExceptionHandler.jsp?action=businessException" >test BusinessException</a><br>
<a href="ExceptionHandler.jsp?action=accountException" >test AccountException</a><br>
<a href="ExceptionHandler.jsp?action=exception" >test Exception</a><br>
