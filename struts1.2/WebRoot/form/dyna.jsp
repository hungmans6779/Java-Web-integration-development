<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean"  prefix="bean" %> 
<%@ taglib uri="http://struts.apache.org/tags-html"  prefix="html" %>
 
<html> 
  <head>
	<title>dyna.jsp</title>
  </head>
  <body>
	<html:form action="/dyna" >
	      年齡：<html:text property="age"      /><html:errors property="age"      /><br>
	      姓名：<html:text property="name"     /><html:errors property="name"     /><br>
	      生日：<html:text property="birthday" /><html:errors property="birthday" /><br>
	  <html:submit/><html:cancel/>
	</html:form>
  </body>
  
</html>