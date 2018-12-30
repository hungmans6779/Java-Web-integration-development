<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>

<%@ taglib uri="http://struts.apache.org/tags-html"  prefix="html"  %>
<%@ taglib uri="http://struts.apache.org/tags-bean"  prefix="bean"  %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>nestedTagListPerson.jsp</title>
    <style type="text/css">
      <!--
		body, th, td {font-size: 12px; }
		table {border-collapse: collapse; border: 1px solid #000000; }
		th, td {border: 1px solid #000000; padding: 2px; }
	  -->	
	</style>
  </head>
  
  <body>
   	<table>
	  <tr>
		<th>ID</th>
		<th>帳號</th>
		<th>姓名</th>
		<th>生日</th>
		<th>愛好</th>
		<th>是否隱藏姓名</th>
	  </tr>
	  <logic:iterate id="person" name="personList" >
	    <tr>
	      <td><beah:write name="person" property="id" /></td>
	      <td><bean:write name="person" property="account" /></td>
	      <td>
	        <logic:equal value="false" name="person" property="secret" >
	          <bean:write name="person" property="name" />
	        </logic:equal>
	        <logic:equal value="true" name="person" property="secret" >***</logic:equal>
	      </td>
	      <td><bean:write name="person" property="birthday" /></td>
	      <td>
	        <logic:iterate id="hobby" name="person" property="hobby" >
	          <bean:write name="hobby" />
	        </logic:iterate>
	      </td>
	      <td><bean:write name="person" property="secret" /></td>
	    </tr>
	  </logic:iterate>
	</table>
	<br/>	
    <a href="${pageContext.request.contextPath}/nestedTag.do">添加人员</a>
   
  </body>
  
</html>