<%@ page language="java" contentType="text/html;charset=UTF-8" %>

<%@ taglib uri="/struts-tags"         prefix="struts"  %>
<%@ taglib uri="/struts-dojo-tags"    prefix="sx"      %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'autocompleteTag.jsp' starting page</title>
    <sx:head />
  </head>
  
  <body> 
    <!-- 
      select、autocomplete 標籤下拉式清單 
      select 標籤為標準的下列框，產生HTML 裡的 <select>標籤。
      autocomplete 標籤為具有自動完成功能的下拉清單，能根據所填的內容篩選下拉清單的內容。
      使用 autocomplete 標籤必須使用 Ajax 主題，因為它用到了 DOJO 的 JavaScript 函式庫。 
    -->
    provinceList：<struts:property value="provinceList"  /><br/>
    #request.provinceList1：<struts:property value="#request.provinceList1"  /><br/>
    #attr.provinceList2：   <struts:property value="#attr.provinceList2"  /><br/>
    
    <hr/>
    
    <struts:form action="/tags/autocompleteTagSubmit.action" >
      <struts:select    name="province1" label="請選擇年份"  list="provinceList" />
      <sx:autocompleter name="province2" label="請選擇年份"  list ="%{#request.provinceList1}" />
      <struts:submit value="提  交" align="center" />
    </struts:form>
    
  </body>
  
</html>
