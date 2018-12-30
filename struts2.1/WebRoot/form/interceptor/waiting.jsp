<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/struts-tags"        prefix="struts"  %>
<%@ taglib uri="/struts-dojo-tags"   prefix="sx"      %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'wait.jsp' starting page</title>
    <sx:head debug="false" />
  </head>
  
  <body>
    
    頁面傳送(下載)中。。。 請等待。。。
    
    <script type="text/javascript" >
      <!--
        setTimeout("location = location;",1000);  // 1秒鐘後更新本頁
      //-->
    </script>
    
  </body>
  
</html>