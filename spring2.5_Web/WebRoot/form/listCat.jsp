<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page import="java.util.*"  %>

<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean"  prefix="bean"   %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html"  prefix="html"   %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic"  %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
    <title>My JSP 'listCat.jsp' starting page</title>
    <style type="text/css" >
	  <!--
	    body, td, th, input { font-size: 12px; }
		table { border-collapse: collapse; border: 1px solid #000000; }
		th, td {border-collapse: collapse; border: 1px solid #000000; padding: 4px; }
      //-->
    </style>  
  </head>
  
  <body> 
    
    <html:form action="/cat" >
    
      <input type="hidden" name="action" value="add" />
      <html:text   property="name" />
      <html:submit value="增加"    />
    </html:form>
     
    <table>
      <tr>
        <td>ID</td>
        <td>Name</td>
        <td>CreateDate</td>
      </tr>
      <logic:iterate id="cat" name="catList" >
        <tr>
          <td><bean:write name="cat" property="id"                                       /></td>
          <td><bean:write name="cat" property="name"                                     /></td>
          <td><bean:write name="cat" property="createDate"  format="yyyy-MM-dd HH:mm:ss" /></td>
        </tr>
      </logic:iterate>
      
    </table> 
     
     
  </body>
  
</html>
