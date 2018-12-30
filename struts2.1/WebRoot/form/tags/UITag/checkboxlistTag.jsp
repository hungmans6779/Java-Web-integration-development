<%@ page language="java" contentType="text/html;charset=UTF-8" %>

<%@ taglib uri="/struts-tags"       prefix="struts" %>
<%@ taglib uri="/struts-dojo-tags"  prefix="sx"     %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'checkboxlistTag.jsp' starting page</title>
    <sx:head />
  </head>
  
  <body>
  
    <%-- 
       checkboxlist 標籤多選框組
       
       checkboxlist 標籤可以多選的多個核對方塊。如果 Action 中對應的屬性為 List 類型或者陣列類型，
       JSP 中的 checkboxlist 標籤會自動勾選多個值。
    --%>
    
    <struts:form action="/tags/checkboxlistSubmmit.action" >
      <struts:checkboxlist list="#request.favouriteList" name="favourite" label="最喜歡的水果" />  
      <struts:submit value="提 交" align="center" /> 
    </struts:form>
    
  </body>
  
</html>
