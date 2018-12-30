<%@ page language="java" pageEncoding="UTF-8" %>

<%@ page import="java.util.*" %>

<%@ taglib uri="/struts-tags"       prefix="struts"  %>
<%@ taglib uri="/struts-dojo-tags"  prefix="sx"      %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>/form/book/successBook.jsp</title>
    <sx:head />
    <style type="text/css" >
	  table {border-collapse: collapse; border: 1px solid #000000; margin-top: 20px; }
	  th, td {border: 1px solid #000000; font-size: 12px; }
	  body {font-size: 12px; }
	</style>
  </head>
  
  <body>
   	<a href="<struts:url action="initAddBook" />"  >增加書籍</a>
    <a href="<struts:url action="listBook"    />"  >書籍列表</a>
  	<a href="<struts:url action="clearBook"   />"  >清空書籍列表</a>
  	<struts:property value="title" escape="false" />
  </body>
  
</html>