<%@ page language="java" contentType="text/html;charset=UTF-8"  %>

<%@ taglib uri="/struts-tags"      prefix="struts"  %>
<%@ taglib uri="/struts-dojo-tags" prefix="sx"      %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'actionTag.jsp' starting page</title>
    <sx:head/>
    <style type="text/css" >
      <!--
        body,td{
          font-size:12px;
        }
      //-->
    </style>
  </head>
  
  <body>
    <!-- 
      action 標籤：用於存取某個Action，並將結果包含進來，相當於JSP 中的 include。
      參數 ignoreContextParams 表示是否要將本頁面的參數傳遞給被呼叫的 Action。
    -->
    
    <struts:action name="loginAction" executeResult="true" ignoreContextParams="false" />
  </body>
  
</html>