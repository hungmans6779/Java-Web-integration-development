<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"   %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"   prefix="fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>JSTL setBundle.jsp</title>
  </head>
  <body>
    <fmt:setBundle basename="resources.messages" var="resource" />
    <fmt:message bundle="${resource}" key="prompt.hello" >
	  <fmt:param>Hungmans6779</fmt:param>
    </fmt:message> <br/>
    <fmt:message bundle="${ resource }" key="prompt.greeting"></fmt:message>
  </body>
</html>
