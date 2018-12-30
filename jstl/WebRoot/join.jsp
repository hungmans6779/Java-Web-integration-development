<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core"        prefix="c"   %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"         prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"   prefix="fn"  %>
  

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'join.jsp' starting page</title>
  </head>
  
  <body>
    <%
      request.setAttribute("array",new String[]{"kevin","kent"});
    %> 
    ${fn:join(array,';') }
  </body>
</html>
 