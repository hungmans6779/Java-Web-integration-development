<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<%@ page import="java.util.*" %>

<%@ taglib uri="/struts-tags"      prefix="struts" %>
<%@ taglib uri="/struts-dojo-tags" prefix="sx" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

  <head>
    <title>appendTag.jsp</title>
    <sx:head />
  </head>
  
  <body>
    <!-- 
      append 標籤用於將多個 List 連成一個List，相當於Java 中的 list1.addAll(list2)。
    -->
    
    <%-- 在myAppendList 物件內後面追加其它的物件  --%>
    <struts:append id="myAppendList" >
      <struts:param value="maleList"    />  <%-- 追加 maleList   --%>
      <struts:param value="femaleList"  />  <%-- 追加 femaleList  --%>
    </struts:append>
    
    <!-- 檢查 myAppendList -->
    <struts:iterator value="myAppendList" >
      <struts:property /> <%-- 輸出裡面的每個值  --%>
      <br/>
    </struts:iterator>  
      
  </body>
  
</html>