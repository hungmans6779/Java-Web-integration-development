<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"  %>

<%@ page import="java.util.*" %>

<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'greeting.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   <%
     
      Locale local=request.getLocale();
      Calendar today=Calendar.getInstance(local);
  
      int year=today.get(Calendar.YEAR);
      int month=today.get(Calendar.MONTH);
      int day=today.get(Calendar.DATE);
      out.println(year+" 年 "+(month+1)+" 月 "+day+" 日");


      int hour=today.get(Calendar.HOUR_OF_DAY);
      int minute=today.get(Calendar.MINUTE);
      int second=today.get(Calendar.SECOND);
      String ampm=today.get(Calendar.AM_PM)==Calendar.AM?"AM":"PM";
      out.println(hour+" 時 "+minute+" 分 "+second+" 秒 "+ampm);
   %>
  </body>
</html>


