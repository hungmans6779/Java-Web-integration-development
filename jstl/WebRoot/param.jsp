<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>JSTL param.jsp</title>
  </head>
  
  <body>
    <c:redirect url="http://www.baidu.com/s">
	  <c:param name="wd" value="音樂" ></c:param>
	  <c:param name="cl" value="3"></c:param>
    </c:redirect>
  </body>
</html>
