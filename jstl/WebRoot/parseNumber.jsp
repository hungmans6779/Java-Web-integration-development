<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"   %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"   prefix="fmt" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'parseNumber.jsp' starting page</title>
  </head>
  
  <body>
    <fmt:parseNumber value="1,000" ></fmt:parseNumber><br>
    <fmt:parseNumber value="1,000" parseLocale="de" ></fmt:parseNumber><br>
  </body>
</html>
