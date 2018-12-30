<%@ page language="java" contentType="text/html;charset=UTF-8"  %>

<%@ page import="java.util.*" %>

<%@ taglib uri="/struts-tags"       prefix="struts" %>
<%@ taglib uri="/struts-dojo-tags"  prefix="sx" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'formTag.jsp' starting page</title>
    <sx:head />
  </head>
  
  <body>
  
    <!-- 
       form 標籤通常用於產生 HTML 裡的<form> 標籤。一定要記住，Struts2.x 裡的 form 標籤不僅會產生 <form> 標籤，
       還會產生 <table> 標籤等版面配置程式碼。因為Struts2.x 具有主題功能。
    -->
     
    <struts:form action="addBookForm" validate="true" >
      <struts:label value="form 標籤" ></struts:label>
      <struts:textfield name="name"     label="書名" />  <!-- 文字域標籤 -->
      <struts:textfield name="author"   label="作者" />  <!-- 文字域標籤 -->
      <struts:submit value="提 交" align="center" />     <!-- 傳送扭鈕 -->    
    </struts:form>
    
  </body>
  
</html>