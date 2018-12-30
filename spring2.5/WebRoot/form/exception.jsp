<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>exception page</title>
  </head>
  
  <body>
               發生錯誤,原因：
      ${ requestScope['org.apache.struts.action.EXCEPTION'].message}   <!-- EL 輸出例外資訊 -->
      <input type="button" value="傳回" onclick="history.go(-1)" />
  </body>
  
</html>
