<%@ page language="java" pageEncoding="UTF-8" %>

<%@ page import="java.util.*" %>

<%@ taglib uri="/struts-tags"       prefix="struts" %>
<%@ taglib uri="/struts-dojo-tags"  prefix="sx"     %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>/form/book/initBook1.jsp</title>
    <sx:head />
    <style type="text/css" >
      <!--
		body, th, td {font-size: 12px; }
	  //-->	
	</style>
  </head>
  
  <body>

    <a href="<struts:url action='initAddBook1' />" >增加書籍</a>
    <a href="<struts:url action='listBook1'    />" >書籍列表</a>
    <a href="<struts:url action='clearBook1'   />" >清空書籍列表</a>


    <!-- 資料傳送給 addBook.action  -->
    <struts:form action="addBook1" validate="true" >
      <struts:label value="增加書籍" />
      <struts:textfield name="book.name"          label="書名"      /> <!-- 屬性的屬性  -->
      <struts:textfield name="book.author"        label="作者"      /> <!-- 文字輸入框 -->
      <struts:textfield name="book.publishedDate" label="出版日期"  /> <!-- 日期類型 -->
      <struts:submit value="增加"  /><!-- 傳送按鈕  --> 
    </struts:form>
    
  </body>
  
</html>