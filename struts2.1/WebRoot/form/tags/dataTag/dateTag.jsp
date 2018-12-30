<%@ page language="java" contentType="text/html;charset=UTF-8" %>

<%@ taglib uri="/struts-tags"      prefix="struts" %>
<%@ taglib uri="/struts-dojo-tags" prefix="sx"     %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'dateTag.jsp' starting page</title>
    <sx:head />
  </head>
  
  <body>
    <!-- 
      date 標籤：用於格式化時間輸出，屬性 format 設定時間格式字串，例如 yyyy-MM-dd、HH:mm:ss 等。
      format 支援 JDK 中的日期格式。
      date 標籤的屬性 nice：預設為false。如果為nice，會輸出形如 2 days,6 hours ago、 in 10 minutes 等的時間格式。
      nice 為true時，format 屬性不起作用。
    -->
    
    <struts:bean name="java.util.Date" id="date" >
      <struts:param name="time" value="#date.time - 2*24*60*60*1000" />
    </struts:bean>
    
    <struts:date name="date" format="yyyy-MM-dd  HH:mm:ss" /> <br/>   <!-- 格式化日期  -->
    <struts:date name="date" /><br/>                                  <!-- 輸出為日期格式1 -->
    <struts:date name="date" nice="true" /><br/>                      <!-- 輸出為 nice 格式 -->
    
    
  </body>
  
</html>