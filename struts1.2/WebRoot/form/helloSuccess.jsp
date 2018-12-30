<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ page contentType="text/html; charset=utf-8" %>

<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>helloSuccess.jsp page</title>
  </head>
  
   
  <body>        
           您好,${helloForm.name}.....<br><br>
           您的年齡是：${helloForm.age },<br>
    <c:choose>
      <c:when test="${helloForm.experience}" ><font color='blue' >您以前用過 Struts。</font></c:when>
      <c:otherwise ><font color='red' >您以前沒有用過 Struts。</font></c:otherwise>
    </c:choose><br>           
           您的愛好是：
    <c:forEach items="${helloForm.hobby}"  var="hobby" >
      ${hobby}
    </c:forEach><br>
           日期：${helloForm.date}<br>
           時間：${helloForm.time}<br>
  </body>
  
</html>
