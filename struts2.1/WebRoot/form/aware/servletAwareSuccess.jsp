<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib uri="/struts-tags"       prefix="struts" %>
<%@ taglib uri="/struts-dojo-tags"  prefix="sx" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'servletAwareSuccess.jsp' starting page</title>
    <sx:head />
    <style type="text/css">
      body,td {
	    font-size: 12px;
      }
    </style>
  </head>
  
  <body>
    <struts:property value="servletRequest.remoteAddr" /><br/>
    <struts:property value="servletRequest.authType"   /><br/>
    <struts:property value="servletRequest.serverName" /><br/>
    headers:${headerValues} <br/>
  </body>
  
</html>