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

<html:html lang="true" >
  <head>
    <title>view.jsp</title>
  </head>
  
  <body>
    This is a view Page Content <br>
    參數：action = <%= request.getParameter("action") %>
  </body>
  
</html:html>