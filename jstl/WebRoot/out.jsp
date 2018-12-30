<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">


<html>
  <head>
     <title>JSTL out</title>
  </head>
  
  <body>
    JSTL 呼叫  action 參數為:<c:out value="${param.action}" default="無參數" ></c:out><br>
    EL 呼叫 action 參數為:${param.action}<br>
    
    JSTL:<c:out value='${"<>"}' /><br>
    EL:${"<>"}<br>
    
  </body>
</html>
