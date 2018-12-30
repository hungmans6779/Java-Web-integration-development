<%@ page language="java" contentType="text/html;charset=UTF-8" %>

<%@ taglib uri="/struts-tags"      prefix="struts"  %>
<%@ taglib uri="/struts-dojo-tags" prefix="sx"      %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'divTag.jsp' starting page</title>
    <sx:head  />
  </head>
  
  <body>
    
    <%--
      div、submit、a 標籤：實現無更新獲得資料
      在Web2.0 中，div 元素使用比較廣。這是因為 div 元素靈活、簡單，配合 css 樣式表能夠呈現豐富的顯示效果，
      因此，<div> 元素經常與 Ajax 技術聯用。Struts 2 把 div 元素與 Ajax 技術封裝成 div  標籤、submit 標籤、a 標籤等，方便開發者使用。
      
      div 標籤能夠顯示其他頁面的內容，而這個頁面的內容並不是用 iframe 等嵌套進來的。div 標籤能夠用 Ajax 獲得該頁面的內容，
      然後在標籤內部顯示。div 標籤處處表現著 Ajax 技術無頁面更新頁面、即時響應等特點。       
    --%>
    
    
    
    
    <%-- 清空 session 的計數器 --%>
    <struts:set name="clear" value="%{#session.updatedTimes=0}" />
    
    
    <%-- 要顯示頁面的URL --%>
    <struts:url id="news"  action="divTagNews" />
   


    <%-- indicator --%>
    <span id="indicator1" style="background:#FFF000;padding:4px;" >
      正在更新網址： <struts:property value="%{news}" />
    </span> 
    
   
   
    
    <%-- div 標籤 顯示一個頁面 每隔 3秒鐘更新一次 --%>
    <sx:div theme="ajax"  href="%{news}" showLoadingText="true" updateFreq="3000" indicator="%{indicator1}"  />
     
   
    
    <hr/>
    
    
    <%-- Ajax 查詢表單 --%>
    <struts:form name="newActionForm" id="newActionForm" >
      <struts:textfield name="key" label="關鍵字1" />
      <sx:submit value="查詢新聞"  href="%{news}" formId="%{newActionForm}" targets="divNewsSearch" />
    </struts:form>

    <%-- 查詢結果顯示在這裡 --%>
    <div id="divNewsSearch" ></div>

    <hr/>
    
    
    
    <struts:form name="newActionForm2" id="newActionForm2" >
      <struts:textfield name="key" label="關鍵字2" />
      <sx:submit value="查詢新聞2"  href="%{news}"  formId="%{newActionForm2}" targets="divNewsSearch2"  />
    </struts:form>   
    
    <div id="divNewsSearch2" ></div>
    
        
    
  </body>
  
</html>