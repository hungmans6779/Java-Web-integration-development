<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%
  request.setAttribute("locale","en_US"); // en_US 英文環境
 // request.setAttribute("locale","zh_TW");  // 繁體環境
 // request.setAttribute("locale","zh_CN");    // 簡體環境
%>
<html>
  <head>
    <title>My JSP 'resource1.jsp' starting page</title>
    <link rel="stylesheet" type="text/css" href="css/flora/flora.all.css" media="screen"/>
	<script type="text/javascript" src="js/jquery-1.2.6.pack.js"></script>
	<script type="text/javascript" src="js/ui.core.js"></script>
	<script type="text/javascript" src="js/ui.tabs.js"></script>
	<script type="text/javascript">
      <!--
         $(document).ready(function(){
           $("#example > ul").tabs();
         });
      //-->
    </script>
	<style>
        #example [id]{
          width:400px;
          height:600px;
        }
    </style>
  </head>
  
  <body>
  

	<fmt:setLocale value="${locale}" />
	<fmt:bundle basename="com.helloweenvsfei.i18n.languageInfo" prefix="tag." >
      <div id="example" class="flora" >
        <ul>
          <li><a href="#tag-1" ><span><fmt:message key="overviewStr" /></span></a></li>
          <li><a href="#tag-2" ><span><fmt:message key="itineraryStr" /></span></a></li>
          <li><a href="#tag-3" ><span><fmt:message key="DatesAndPricesStr" /></span></a></li>
          <li><a href="#tag-4" ><span><fmt:message key="extersionsStr" /></span></a></li>
          <li><a href="#tag-5" ><span><fmt:message key="CustomizeStr" /></span></a></li>
          <li><a href="#tag-6" ><span><fmt:message key="AskStr" /></span></a></li>
        </ul>
        <div id="tag-1" >
          Tag1 的內容
        </div>
        <div id="tag-2" >
          Tag2 的內容
        </div>
        <div id="tag-3" >
          Tag3 的內容
        </div>
        <div id="tag-4" >
           Tag4 的內容
        </div>
        <div id="tag-5" >
          Tag5 的內容
        </div>
        <div id="tag-6" >
          Tag6 的內容
        </div>
      </div>
      
     
     
    </fmt:bundle>
    
    <fmt:bundle basename="com.helloweenvsfei.i18n.languageInfo" prefix="img." >
     <img src="<fmt:message key="image1Str" />" />
    </fmt:bundle>
    
	<!-- Locale:en_US 英文環境 (結束)-->
	
	<hr>



				
  </body>
</html>
