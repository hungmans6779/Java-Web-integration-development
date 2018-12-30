<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>JSTL forEach</title>
    <style>
      <!--
        div{
          float:left;
          padding:3px;
          width:50px;
          text-align:center;
          border:1px solid #000000;
        }
      //-->
    </style>
  </head>
  
  <body>
    <c:forEach var="num" begin="2" end="100" step="2" >
       <div>${num}</div>
    </c:forEach>
  </body>
</html>
