<%@ page language="java" contentType="text/html; charset=UTF-8"  %>

<%@ taglib uri="/struts-tags"       prefix="struts"  %>
<%@ taglib uri="/struts-dojo-tags"  prefix="sx"      %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'includeTag.jsp' starting page</title>
    <sx:head />
  </head>
  
  <body>
  
    <!-- 
      include 標籤：用於包含一個 JSP 頁面，將 JSP 的執行結果包含到本頁面內，
    -->
    <struts:include value="includeContext.jsp" /><br/>
  
  </body>
  
</html>