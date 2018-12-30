<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core"       prefix="c"   %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"        prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql"        prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml"        prefix="x"   %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'parse.jsp' starting page</title>
  </head>
  
  <body>
  
    <x:parse var="content" >
      <student description="Software Engineer" >
        <name>Helloween</name>
        <age>20</age>
      </student>
    </x:parse>
    
    content:${content}<br>
    
    Description:<x:out select="$content/student/@description" /><br>
    Name:<x:out select="$content/student/name" /><br>  
    age:<x:out select="$content/student/age" /><br> 
  </body>
</html>
