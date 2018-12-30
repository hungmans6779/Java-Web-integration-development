<%@ page language="java" contentType="text/html; charset=UTF-8"  %>

<%@ taglib uri="/struts-tags"       prefix="struts"  %>
<%@ taglib uri="/struts-dojo-tags"  prefix="sx"      %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'paramTag.jsp' starting page</title>
     <sx:head />
  </head>
  
  <body>
    <!-- 
      param 標籤：用於給其它標籤傳遞參數
    -->
    
    <struts:bean name="java.util.Date" id="date" >
      <struts:param name="time" value="#date.time - 2*24*60*60*1000" /> 
      <struts:property value="time" /> <br/>
    </struts:bean>
    <hr/>
    <struts:date name="date" format="yyyy-MM-dd HH:mm:ss" /><br/>   <!-- 格式化日期  -->
    <hr/>
 
  </body>
  
</html>