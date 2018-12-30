<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.helloweenvsfei.listener.PersonInfo" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'active.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
  <body>
    <%
       PersonInfo personInfo=(PersonInfo)session.getAttribute("personInfo");
       if(personInfo==null){
         personInfo=new PersonInfo();
         personInfo.setName("Helloween"); 
         session.setAttribute("personInfo",personInfo);
         out.println("PersonInfo 物件不存在，已經成功新增。sessionId:"+session.getId());
         
       }else{
         out.println("PersonInfo 物件存在。無須新增。sessionId:"+session.getId());
       }
    %>
    
    
  </body>
</html>
