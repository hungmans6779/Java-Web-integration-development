<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core"       prefix="c"   %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"        prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql"        prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml"        prefix="x"   %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>JSTL x_forEach.jsp</title>
  </head>
  
  <body>
    
    <c:import var="file" url="http://rss.sina.com.cn/news/marquee/ddt.xml"  charEncoding="UTF-8" ></c:import>
    <x:parse var="doc" doc="${file}" ></x:parse>  
    <x:forEach var="node" select="$doc/rss/channel/item" varStatus="status" >
      ${status.count}.
      <a href="<x:out select="$node/link"/>" target="_blank" >
        <x:out select="$node/title" />
      </a>
      <x:out select="$node/pubDate" /><br>
      <x:out select="$node/description" /><br>
    </x:forEach>   

  </body>
</html>
