<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ page import="com.helloweenvsfei.struts.bean.*" %>

<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean"   prefix="bean"  %> 
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic"  prefix="logic" %> 

<%--
            參考頁面：http://struts.apache.org/1.2.9/userGuide/struts-logic.html
--%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>logicTag.jsp</title>
  </head>
  
  <body>
  
    <font color='red' >&lt;logic:present&gt; 測試</font><br>
    <logic:present cookie="JSESSIONID" >
      <bean:cookie id="sessionID" name="JSESSIONID" />
      <bean:write name="sessionID" property="value" />
    </logic:present>
    <logic:notPresent cookie="JSESSIONID" >
      Cookie "JSESSIONID" 不存在。
    </logic:notPresent>
    <hr>  
    
    
    
    
    <font color='red'>&lt;logic:equal&gt; & &lt;logic:notEquals&gt; 測試</font><br>
    <logic:equal value="F377C4713EDB8AE90CB46E3F0F5AC405" cookie="JSESSIONID" >YES</logic:equal>
    <logic:notEqual value="F377C4713EDB8AE90CB46E3F0F5AC405" cookie="JSESSIONID" >noEqual</logic:notEqual>
    <hr>
    



    <font color='red'>&lt;logic:empty&gt; & &lt;logic:notEmpty&gt; 測試</font><br>
    <%
      request.setAttribute("someBean",new Person1());
      request.removeAttribute("someBean");
    %>
    <logic:empty name="someBean" >someBean 是空的</logic:empty>
    <logic:notEmpty name="someBean" >someBean 不是空的</logic:notEmpty> 
    <hr> 
     
     
    <%--  
      <logic:redirect href="http://www.hhtravel.com" />
    --%>
     
     
     
     
  </body>
  
</html>