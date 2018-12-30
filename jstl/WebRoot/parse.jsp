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
  
    <c:import var="file" url="http://rss.sina.com.cn/news/marquee/ddt.xml"  charEncoding="UTF-8" ></c:import>
    <div class="source">
      <c:out value="${file}" ></c:out>
    </div>
    
    <x:parse var="doc" doc="${file}" ></x:parse>  
    
          新浪 RSS<br>
          版本：<x:out select="$doc/rss/@version" /><br>
         標題：<x:out select="$doc/rss/channel/title" /><br>
         來源：<x:out select="$doc/rss/channel/generator" /><br>
         版權：<x:out select="$doc/rss/channel/copyright" /><br>
         出版時間：<x:out select="$doc/rss/channel/pubDate" /><br>
         連結位址：<x:out select="$doc/rss/channel/link" /><br>
         
  </body>
</html>
