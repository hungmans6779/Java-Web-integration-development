<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*" %>

<%@ taglib uri="/struts-tags"      prefix="struts" %>
<%@ taglib uri="/struts-dojo-tags" prefix="sx" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>generatorTag.jsp</title>
    <sx:head />
  </head>
  
  <body>
    <!-- 
       generator 標籤用於將字串轉化為List，相當於 Java 中的 split，例如    
    -->

    <!-- 分割字串  -->
    <struts:generator val="%{'kevin,hungmans6779,自由人,超級賽亞人,喵㖆'}"  separator=","  >
       <!-- 檢查 List 資料 -->
      <struts:iterator>
        <struts:property />   <!-- 輸出每個資料值  -->
        <br/>
      </struts:iterator>
    </struts:generator>
  
  </body>
  
</html>