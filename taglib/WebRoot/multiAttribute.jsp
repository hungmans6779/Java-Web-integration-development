<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.helloweenvsfei.com/tags" prefix="taglib" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>taglib multiAttribute.jsp</title>
  </head>
  
  <body>
    <taglib:multiAttribute>
	  <jsp:attribute name="body1">標籤體一, </jsp:attribute>
	  <jsp:attribute name="body2">標籤體二, </jsp:attribute>
     </taglib:multiAttribute>
  </body>
</html>
