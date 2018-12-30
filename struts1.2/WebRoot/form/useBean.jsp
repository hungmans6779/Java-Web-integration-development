<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <title>FormBean 中使用Person 實體類別 </title>
  </head>
  
  <body>
    <html:form action="/useBean" >
      <html:hidden property="action" value="add" /><br>   <%-- 隱藏欄位 --%>
                帳號：<html:text property="person.account" /><br>
                姓名：<html:text property="person.name"    /><br>
      <html:submit /><html:cancel />
    </html:form>
  </body>
  
</html>