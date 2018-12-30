<%@ page language="java" contentType="text/html;charset=UTF-8"  %>

<%@ taglib uri="/struts-tags"       prefix="struts" %>
<%@ taglib uri="/struts-dojo-tags"  prefix="sx"     %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'login.jsp' starting page</title>
    <sx:head />
  </head>
  
  <body>
  
    <struts:form action="loginAction" >
      <struts:label label="登錄系統" /><br/>
      <struts:textfield name="account" /><br/>
      <struts:password  name="password"  /><br/> 
      <struts:submit value="登入"  />
    </struts:form>
    
  </body>
  
</html>
