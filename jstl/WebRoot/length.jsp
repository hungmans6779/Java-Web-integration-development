<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core"        prefix="c"   %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"         prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"   prefix="fn"  %> 
    

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>JSTL length.jsp</title>
  </head>
  
  <body>
   "${ pageContext.request.requestURL }" 的长度：${ fn:length(pageContext.request.requestURI) } <br/>
   Cookie[] 的长度：${ fn:length(pageContext.request.cookies) } <br/>
   Map header 的长度: ${ fn:length(header) } <br/>
  </body>
</html>
