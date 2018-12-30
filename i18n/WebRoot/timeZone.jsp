<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<jsp.directive.page import="java.util.TimeZone" />
<jsp.directive.page import="java.util.Map"      />
<jsp.directive.page import="java.util.HashMap"  />

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<jsp:useBean id="date" class="java.util.Date" />

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%
  Map <String,TimeZone> hashMap=new HashMap<String,TimeZone>();
  for(String ID:TimeZone.getAvailableIDs()){
    hashMap.put(ID,TimeZone.getTimeZone(ID));
  } // end for(String ID:TimeZone.getAvailableIDs()){
  
  request.setAttribute("timeZoneIds",TimeZone.getAvailableIDs());
  request.setAttribute("timeZone",hashMap);
%>

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
    <fmt:setLocale value="zh_TW" />
           現在時刻：<%= TimeZone.getDefault().getDisplayName() %>   
    <fmt:formatDate value="${date}" type="both" /><br>
    
    
    <table>
	  <tr>
		<th>時區ID</th>
		<th>時區</th>
		<th>現在時間</th>
		<th>時差</th>
	  </tr>
      <c:forEach var="ID" items="${ timeZoneIds }" varStatus="status" >
	    <tr>
		  <td>${ ID }</td>
		  <td>${ timeZone[ID].displayName }</td>
		  <td>
			<fmt:timeZone value="${ID}" >
				<fmt:formatDate value="${date}" type="both" timeZone="${ID}"/>
			</fmt:timeZone>
		  </td>
		  <td>${ timeZone[ID].rawOffset / 60 / 60 / 1000 }</td>
	    </tr>
      </c:forEach>
    </table>
  </body>
</html>
