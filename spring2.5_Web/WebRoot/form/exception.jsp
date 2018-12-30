<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page import="java.util.*"  %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
  <head>
    <title>My JSP 'exception.jsp' starting page</title>
  </head>
  
  <body>
  
     <!-- 輸出錯誤原因 -->
     發生錯誤的原因：${ requestScope['org.apache.struts.action.EXCEPTION'].message}
   
     <!-- 傳回按鈕 -->
     <input type="button" value="傳回" onclick="history.go(-1);" />       
    
  </body>
  
</html>
