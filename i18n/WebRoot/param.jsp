<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
  <head>
    <title>My JSP 'param.jsp' starting page</title>
  </head>
  
  <body>
    <fmt:bundle basename="com.helloweenvsfei.i18n.param" >
      <fmt:message key="hello" >
        <fmt:param value="${pageContext.request.remoteAddr }" ></fmt:param>
        <fmt:param value="${pageContext.request.locale }" ></fmt:param>
        <fmt:param value="${pageContext.request.locale.displayLanguage }" ></fmt:param>
      </fmt:message>
    </fmt:bundle>
  </body>
</html>
