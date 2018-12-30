<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>

<jsp:useBean id="date" class="java.util.Date"></jsp:useBean>

<%
  request.setAttribute("localeList",Locale.getAvailableLocales()); 
%>
    
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>i18n setLocale.jsp</title>
    <style type="text/css">
      table, td, tr {font-size: 12px; }
      table {
	      border-collapse: collapse;
	      border: 1px solid #000000;
      }
      td, th {
	      border: 1px solid #000000;
	      padding: 2px; 
      	padding-left: 10px; 
	      padding-right: 10px; 
      }
      .title {
      	background: #EEEEEE; 
      }
      .title td {
      	text-align: center;
      }
    </style>
  </head>
  
  <body>
  
    <table>
	  <tr class="title">
		<th>Locale</th>
		<th>Language</th>
		<th>Date and Time</th>
		<th>Number</th>
		<th>Currency</th>
		<th>Percent</th>
	  </tr>	
	  <c:forEach var="locale" items="${ localeList }">
		<fmt:setLocale value="${ locale }" />
		<tr>
			<td align="left">${ locale.displayName }</td>
			<td align="left">${ locale.displayLanguage }</td>
			<td><fmt:formatDate value="${ date }" type="both"/></td>
			<td><fmt:formatNumber value="10000.5" /></td>
			<td><fmt:formatNumber value="10000.5" type="currency" /> </td>
			<td><fmt:formatNumber value="10000.5" type="percent" /> </td>
		</tr>	
	  </c:forEach>
    </table>
    
  </body>
</html>
