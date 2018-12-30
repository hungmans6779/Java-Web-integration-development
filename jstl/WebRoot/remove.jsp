<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>JSTL remove.jsp </title>
  </head>
  
  <body>
   <%
     request.setAttribute("somemap",new HashMap());
   %>
   <c:remove var="somemap" scope="request" ></c:remove>
   ${ somemap==null?"somemap 已經被刪除":"somemap 沒有被刪除"}<br>
  </body>
</html>
