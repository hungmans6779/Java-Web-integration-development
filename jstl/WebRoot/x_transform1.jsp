<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core"       prefix="c"   %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"        prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql"        prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml"        prefix="x"   %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>JSTL x_transform1.jsp</title>
    <style>
      body, td, div {
      	font-size: 12px; 
      }
      .source {
      	white-space: pre;
      	width: 100%; 
	      height: 200px; 
	      overflow: scroll;
	      border: 1px solid #999999; 
	      padding: 2px; 
	      margin-bottom: 20px; 
      }
      table {
	      border-collapse: collapse;
	      border: 1px solid #999999; 
      }
      th {
	      border: 1px solid #999999; 
	      padding: 2px; 
	      text-align: center;
	      padding-left: 10px; 
	      padding-right: 10px; 
	      background: #CCCCCC;
      }
      td {
	      border: 1px solid #999999; 
	      padding: 2px; 
	      text-align: center;
	      padding-left: 10px; 
	      padding-right: 10px; 
      }
    </style>
  </head>
  
  <body>
  
    <c:set var="data" >
      <c:import url="/WEB-INF/classes/xml/students.xml" />
    </c:set>
    <div class="source">
      <c:out value="${data}" />
    </div>
     
    <c:set var="template" >
      <c:import url="/WEB-INF/classes/xsl/studentsXSL.xml" />
    </c:set>  

    <x:transform doc="${ data }" xslt="${ template }"></x:transform>
    
  </body>
  
</html>
