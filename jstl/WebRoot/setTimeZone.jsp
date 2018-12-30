<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"   %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>JSTL setTimeZone.jsp</title>
    <style type="text/css">
      body,div {font-size: 14px; }
      div{
	    float: left; 
	    width: 200px; 
	    line-height: 22px; 
	    border: 1px solid #000000;
	    padding: 4px; 
	    border-collapse: collapse;
      }
    </style>
  </head>
  
  <body>
   
    <jsp:useBean id="date" class="java.util.Date"></jsp:useBean>
    <fmt:setLocale value="${pageContext.request.locale}" />
          現在時刻：台北時間
    <fmt:formatDate value="${ date }" type="both" /> <br/>
    <c:forEach var="i" begin="0" end="25" >
	  <div style="background: ${ i == 20 ? '#DDDDDD' : '#ffffff' }; ">
		GMT${ i>=12 ? '+' : '' }${ i-12 } : 
		<fmt:timeZone value="GMT${ i>=12 ? '+' : '' }${ i-12 }" >
		  <fmt:formatDate value="${ date }" type="both" />
		</fmt:timeZone>
	  </div>
    </c:forEach>
  </body>
</html>
