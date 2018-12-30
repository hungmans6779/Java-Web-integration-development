<%@ page language="java" pageEncoding="UTF-8"  %>

<%@ page import="java.util.Date" %>

<%@ taglib uri="/struts-tags"       prefix="struts"  %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'exception.jsp' starting page</title>
    <style type="text/css" >
	  <!--
	    body, td, th, input { font-size: 12px; }
		table { border-collapse: collapse; border: 1px solid #000000; }
		th, td {border-collapse: collapse; border: 1px solid #000000; padding: 4px; }
      //-->
    </style>      
  </head>
  
  
  
  <body>
  
    <struts:form action="add_cat" >
      <struts:textfield name="cat.name"        label="名字" value=""       /> 
      <struts:submit value="增加" />
    </struts:form>
    <table>
      <tr>
        <th>ID</th>
        <th>Name</th>
        <th>CreateDate</th>
      </tr>
      <struts:iterator value="catList" >
        <tr>
          <td><struts:property value="id"         /></td>
          <td><struts:property value="name"       /></td>
          <td><struts:property value="createDate" /></td>
        </tr>
      </struts:iterator>

    </table>

  </body>

</html>