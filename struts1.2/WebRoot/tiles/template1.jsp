<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib uri="http://jakarta.apache.org/struts/tags-html"   prefix="html"   %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean"   prefix="bean"   %> 
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic"  prefix="logic"  %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-nested" prefix="nested" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-tiles"  prefix="tiles"  %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
  <head>
    <title><tiles:getAsString name="title" ignore="true" /></title>
    <style type="text/css">
      <!--
		body {margin: 0px; }
	
      	div, td {font-size: 12px; }
		
        .banner {
			height: 80px; 
			background: url(${pageContext.request.contextPath}/images/bg.jpg); 
			font-size: 16px; 
			font-weight: bold; 
			color: #ffffff; 
			padding-top: 30px; 
			padding-left: 40px; 
		}
    
		.header {
			line-height: 25px; 
			text-align: right; 
			padding-right: 20px; 
			background: url(${pageContext.request.contextPath}/images/bg_menu.jpg); 
		}
    
		.header a {color: #293C83; }
    
		.menu {}
    
		.menu div{background: #C8D7E3; text-align: center; line-height: 22px; border-bottom: 1px solid #FFFFFF; }
    
		.menu div a{color: #293D6B; }
    
		.menu #selected{background: #98B1C4; }
    
		.menu #selected a {color: #ffffff; }
    
		.footer {color: #ffffff; background: #98B1C4; line-height: 23px; text-align: center; }
	  //-->	
	</style>
  </head>
    
    
    
    
  <body>
  
    <!-- 標題字串，可選 -->
    <div class="banner" >
      <tiles:getAsString name="title" ignore="true" />
    </div>
    
    
    <!-- 導覽列，必需的 -->
    <div class="header" >
      <tiles:getAsString name="header" />
    </div>
     
    
    
    <!-- 內容區(menu + content) (開始) --> 
    <table>
      <tr>
        <td width="136" class="menu" >
          <!-- 功能表列，必需的 -->
          <tiles:getAsString name="menu" />
          <div align="right" ><img src="${pageContext.request.contextPath}/images/left-nav-corner.gif" ></div>
          <br><br><br><br><br><br>
        </td>
        <td valign="top" class="main" >
          <!-- 主要內容區域，必需的  -->
          <tiles:getAsString name="main" />
        </td>
      </tr>
    </table>
    <!-- 內容區(menu + content) (結束) --> 



    
    <!-- 結尾，版權宣告，必需的(開始) -->
    <div class="footer" >
      <!-- 
        <tiles:insert attribute="copyright" /> 
      -->
      <tiles:insert name="copyright" />
    </div>
    <!-- 結尾，版權宣告，必需的(結束) -->
    
    
    
  </body>

</html>