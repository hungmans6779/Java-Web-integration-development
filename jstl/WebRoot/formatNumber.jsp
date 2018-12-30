<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.util.Locale"%>
<%@ page import="java.lang.reflect.Field"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Date"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"   %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"   prefix="fmt" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'formatNumber.jsp' starting page</title>
    <style type="text/css">
      body{
	      font-size: 14px; 
      }
      table {
	      border-collapse: collapse;
	      border: 1px solid #000000;
	      margin-top: 5px; 
      }
      td {
      	border: 1px solid #000000;
	      padding: 2px; 
	      text-align: center;
	      font-size: 12px; 
      }
      .title td {
      	background: #EEEEEE; 
	      width: 100px; 
      }
    </style>
  </head>
  
  <body>
    <%
      List <Locale> localeList = new ArrayList<Locale>();
      /*
      Field [] field = Locale.class.getFields();
      for(int i=0; i<field.length; i++){
        System.out.println(field[i]);
        if(field[i].getType().equals(Locale.class)){
          localeList.add((Locale)field[i].get(null));
        }
      }
      */
      for(Field filed:Locale.class.getFields()){
        if(filed.getType().equals(Locale.class)){
         localeList.add((Locale)filed.get(null));
        }
      }
      request.setAttribute("localeList", localeList);
      double [] numbers = { 0, 10000, 55.0, -123.2568 };
      request.setAttribute("numbers", numbers);
    %>
    <fmt:setLocale value="${param.locale}"/>
          當前格式：<c:out value="${param.locale}" default="${pageContext.request.locale} "></c:out>
    <br>
    <c:forEach items="${localeList}" var="locale" >
	  <a href="${pageContext.request.requestURI}?locale=${locale}" >${locale}</a>&nbsp;
    </c:forEach>
    <br> 
    <br>
    <table>
	  <tr class="title">
		<td>數字原值</td>
		<td>數字格式</td>
		<td>貨幣格式</td>
		<td>百分數格式</td>
	  </tr>
	  <c:forEach items="${numbers}" var="number" >
		<tr>
		  <td>${ number }</td>
		  <td>
		    <fmt:formatNumber value="${number}" type="number"
		         maxIntegerDigits="3"  minIntegerDigits="3" 
				 maxFractionDigits="4" minFractionDigits="2"  />
	      </td>
		  <td><fmt:formatNumber value="${number}" type="currency" /></td>
		  <td><fmt:formatNumber value="${number}" type="percent"  /></td>
		</tr>
	  </c:forEach>

</table>


  </body>
</html>
