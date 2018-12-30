<%@ page language="java" contentType="text/html;charset=UTF-8"  %>

<%@ taglib uri="/struts-tags"        prefix="struts"  %>
<%@ taglib uri="/struts-dojo-tags"   prefix="sx"      %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>authenticationSuccess.jsp</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <sx:head debug="false" />
    <style type="text/css">
      body,td {
	    font-size: 12px;
      }
    </style>
  </head>
  
  <body>
  
    許可權驗證成功頁面，訊息：<struts:property value="message" />
    
  </body>
  
</html>
