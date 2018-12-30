<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core"       prefix="c"   %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"        prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql"        prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml"        prefix="x"   %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>JSTL x_choose.jsp</title>
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
    <x:choose>
      <x:when select="$doc/Context/Resource/@jndi">
                      使用了JNDI 屬性
      </x:when>
      <x:otherwise>
                       沒有使用JNDI 屬性
      </x:otherwise> 
    </x:choose>
  </body>
</html>
