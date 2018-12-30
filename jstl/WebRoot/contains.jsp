<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core"      prefix="c"   %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"       prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"  %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>JSTL fn:contains()</title>
  </head>
  
  <body>
    header['User-Agent']="${header['User-Agent']}"; <br><br>
    
          您使用
     <c:if test="${fn:contains(header['User-Agent'],'MSIE')}" >IE 瀏覽器</c:if>
     <c:if test="${fn:contains(header['User-Agent'],'Firefox')}" >Firefox 瀏覽器</c:if>
     <c:if test="${fn:contains(header['User-Agent'],'Maxthon')}" >Maxthon 瀏覽器</c:if>
     <c:if test="${fn:contains(header['User-Agent'],'MyIE2')}" >MyIE2 瀏覽器</c:if>
     <c:if test="${fn:contains(header['User-Agent'],'Opera')}" >Opera 瀏覽器</c:if>
     <c:if test="${fn:contains(header['User-Agent'],'TencentTraveler')}" >騰訊 瀏覽器</c:if>
     <c:if test="${fn:contains(header['User-Agent'],'TheWorld')}" >世界之窗  瀏覽器</c:if>
     
     <br>
     <c:if test="${fn:containsIgnoreCase(header['User-Agent'],'windows')}" >Windows 作業系統</c:if>
     <c:if test="${fn:containsIgnoreCase(header['User-Agent'],'Linux')}" >Linux 作業系統</c:if>
     <c:if test="${fn:containsIgnoreCase(header['User-Agent'],'SunOS')}" >Sun 作業系統</c:if>
     <br>
  </body>
</html>
