<%@ page language="java" import="java.util.*" pageEncoding="BIG5" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>



<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'while.jsp' starting page</title>
    
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
       List <String> lt=new ArrayList<String>();
       lt.add("煢煢白兔");
       lt.add("東走西顧");
       lt.add("衣不如新");
       lt.add("人不如故");
       
       Iterator it=lt.iterator();
       while(it.hasNext()){
         out.println((String)it.next()+"<br>");
       } 
   %>
  </body>
</html>
