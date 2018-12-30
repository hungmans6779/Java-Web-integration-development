<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core"       prefix="c"   %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"        prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql"        prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml"        prefix="x"   %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>JSTL x_if.jsp</title>
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
    </style>
  </head>
  
  <body>
  
    <c:import var="file" url="/META-INF/context.xml" ></c:import>
    <div class="source">
      <c:out value="${file}" ></c:out>
    </div>   
    <x:parse var="doc" doc="${file}" ></x:parse>  
    <x:if select="$doc/Context/Resource/@driverClassName" var="exists" >
                屬性 Driver Class Name 存在：<x:out select="$doc/Context/Resource/@driverClassName" /><br>
    </x:if>
    <c:if test="${!exists}" >
               屬性 Driver Class Name 不存在
    </c:if>
         
  </body>
</html>