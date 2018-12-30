<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>

<%@ taglib uri="/struts-tags"       prefix="struts" %>
<%@ taglib uri="/struts-dojo-tags"  prefix="sx" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>convertorSuccess1.jsp</title>
    <sx:head />
    <style type="text/css">
      body,td {
	    font-size: 12px;
      }
    </style>
  </head>
  
  <body>
  
    java.sql.Date:<struts:property value="sqlDate"   /><br/>
    java.sql.Time:<struts:property value="sqlTime"   /><br/>
    java.util.Date:<struts:property value="utilDate" /><br/>
    
    <a href="convertor1.action" >&lt;&lt;重新轉換</a>
    
  </body>
  
</html>