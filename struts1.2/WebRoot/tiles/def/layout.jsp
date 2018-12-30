<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib uri="http://jakarta.apache.org/struts/tags-html"   prefix="html"   %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean"   prefix="bean"   %> 
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic"  prefix="logic"  %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-nested" prefix="nested" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-tiles"  prefix="tiles"  %>

<%-- 
   1.《html 標籤函式庫》：用於產生 html 程式碼。  
    
   2.《bean 標籤函式庫》：用於操作 POJO、Cookie、Header 以及Struts 物件等。
  
   3.《logic 標籤函式庫》：由於 bean 標籤經常拋出例外，因此常與 logic 標籤一起使用。
   
   4.《nested 標籤函式庫》：使用 nested 標籤能夠使Struts 把資料直接設置到業務元件 POJO 而不是FormBean。
   
   5.《tiles 標籤函式庫》：原本是一個獨立的軟體產品，後來被融入Apache Struts 中。
                           tiles Apache 官方網站為：http://tiles.apache.org/
                           tiles 在處理網頁佈局以及佈局的再使用性、可維護性上做得非常好，
                           能將頁面或者部份頁面元件化。
                           開發Struts 專案時，結合使用tiles，在處理JSP檔案樣式上會得心應手，簡單明瞭。
       
--%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title><tiles:getAsString name="title" /></title>
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
      <tiles:insert name="header" />
    </div>
     
    <table>
      <tr>
        <td width="136" class="menu" >
          <!-- 功能表列，必需的 -->
          <tiles:insert name="menu" />
          <div align="right" ><img src="${pageContext.request.contextPath}/images/left-nav-corner.gif" ></div>
          <br><br><br><br><br><br>
        </td>
        <td valign="top" class="main" >
          <!-- 主要內容區域，必需的  -->
          <tiles:insert name="main" />
        </td>
      </tr>
    </table>
    
    
    <!-- 結尾，版權宣告，必需的   -->
    <div class="footer" >
      <tiles:insert name="footer" />
    </div>
    
  </body>
  
  
</html>
