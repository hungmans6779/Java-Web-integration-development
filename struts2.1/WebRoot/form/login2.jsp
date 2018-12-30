<%@ page language="java" pageEncoding="UTF-8" %>

<!-- 標籤函式庫  taglib 宣告  -->
<%@ taglib uri="/struts-tags"       prefix="struts" %>
<%@ taglib uri="/struts-dojo-tags"  prefix="sx"     %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>login2.jsp</title>
    <sx:head />
  </head>
 
  <body>
    <struts:form action="loginPerson2" >
      <struts:label value="登入系統" />                  <!-- 文字標籤 -->
      <struts:textfield name="account"  label="帳號"  /> <!-- 文字輸入框 -->
      <struts:password  name="password" label="密碼"  /> <!-- 密碼輸入框 -->
      <struts:submit value="登入" />                     <!-- 傳送鈕 -->
    </struts:form>
  </body>
  
</html>