<%@ page language="java" pageEncoding="UTF-8" %>

<%@ page import="java.util.*" %>

<%@ taglib uri="/struts-tags"       prefix="struts" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>listBook1.jsp</title>
    <style type="text/css" >
      <!--
		table {border-collapse: collapse; border: 1px solid #000000; margin-top: 20px; }
		th, td {border: 1px solid #000000; font-size: 12px; }
		body {font-size: 12px; }
	  //-->
	</style>
  </head>
  
  <body>
  
    <a href="<struts:url action='initAddBook1' />" >增加書籍</a>
    <a href="<struts:url action='listBook1'    />" >書籍列表</a>
    <a href="<struts:url action='clearBook1'   />" >清空書籍列表</a>
    
    <struts:property value="title" escape="false"  />

    <table border="1" >
      <tr>
        <th>書名</th>
        <th>作者</th>
        <th>出版日期</th>
      </tr>
      <struts:iterator id="book" value="bookList" >
        <tr>
          <td>${book.name}</td>           <!-- 書名 -->
          <td>${book.author}</td>         <!-- 作者 -->
          <td>${book.publishedDate}</td>  <!-- 出版日期 -->
        </tr>
      </struts:iterator>
    </table>
    
  </body>
  
</html>