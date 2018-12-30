<%@ page language="java" contentType="text/html;charset=UTF-8"  %>

<%@ taglib uri="/struts-tags"        prefix="struts"  %>
<%@ taglib uri="/struts-dojo-tags"   prefix="sx"      %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>攔截器共用登入(檢核帳號及密碼)頁面</title>
    <sx:head debug="false" />
  </head>
  
  <body>
  
    <struts:form action="/tags/loginInterceptor.action" validate="true" >
      <struts:label value="登入系統 " />                  <!-- 文字標籤 -->
      <struts:textfield name="account"  label="帳號" />   <!-- 文字輸入框 -->
      <struts:password  name="password" label="密碼" />   <!-- 密碼輸入框 -->
      <struts:submit value="登入"  />                     <!-- 傳送鈕 -->
    </struts:form>
    
  </body>
  
</html>
