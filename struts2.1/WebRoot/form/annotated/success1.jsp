<%@ page language="java" pageEncoding="UTF-8" %>

<%@ page import="java.util.*" %>

<%@ taglib uri="/struts-tags"      prefix="struts" %>
<%@ taglib uri="/struts-dojo-tags" prefix="sx" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>/form/annotated/success1.jsp</title>
    <sx:head />
  </head>
  
  <body>
           登入成功1，歡迎您，<struts:property value="account" /> <!-- 顯示 Action 裡的  account 屬性  -->
  </body>
  
</html>