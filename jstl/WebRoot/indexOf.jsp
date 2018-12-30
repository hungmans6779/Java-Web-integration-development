<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core"        prefix="c"   %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"         prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"   prefix="fn"  %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>JSTL indexOf.jsp</title>
  </head>
  
  <body>
     fn:indexOf('filename.txt', '.') = ${ fn:indexOf('filename.txt', '.') }
  </body>
</html>
