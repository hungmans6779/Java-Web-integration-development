<%@ page language="java" contentType="text/html; charset=UTF-8"  %>

<%@ taglib uri="/struts-tags"       prefix="struts"  %>
<%@ taglib uri="/struts-dojo-tags"  prefix="sx"      %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
    <title>My JSP 'setTag.jsp' starting page</title>
    <sx:head />
  </head>
  
  <body>
        
    <!-- 
      set 標籤：用於定義一個變數，並設定變數的值。
    -->
    <struts:set name="technologyName" value="%{'Java'}" />
    technologyName:<struts:property value="technologyName" />
    <hr/>
    
    <struts:set name="account" value="#parameters.account[0]" />
    account:<struts:property value="account" />
    <hr/>
     
     
  </body>
  
</html>