<%@ page language="java" contentType="text/html;charset=UTF-8" %>

<%@ taglib uri="/struts-tags"      prefix="struts"  %>
<%@ taglib uri="/struts-dojo-tags" prefix="sx"      %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'debugTag.jsp' starting page</title>
    <sx:head />
  </head>
  
  <body> 
    <%--
      debug 標籤：用於顯示伺服器、Action 的資訊，一般偵錯工具時使用。
    --%>
    
     <struts:debug />  <!-- 輸出偵錯資訊 -->
     
  </body>
  
</html>