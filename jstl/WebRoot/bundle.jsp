<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"   %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" >
<html>
  <head>
    <title>JSTL bundle.jsp</title>
  </head>
  <body>
    <fmt:bundle basename="resources.messages"  >
      <fmt:message key="prompt.hello" >
        <fmt:param value="kevin"></fmt:param>
      </fmt:message>
      <br>
      <fmt:message key="prompt.greeting" >
      </fmt:message>
    </fmt:bundle>
  </body>
</html>
