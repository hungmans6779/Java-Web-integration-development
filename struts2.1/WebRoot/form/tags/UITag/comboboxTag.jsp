<%@ page language="java" contentType="text/html;charset=UTF-8" %>

<%@ taglib uri="/struts-tags"       prefix="struts" %>
<%@ taglib uri="/struts-dojo-tags"  prefix="sx"     %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'comboboxTag.jsp' starting page</title>
    <sx:head />
  </head>
  
  <body>
  
    <%--
      comobobox 標籤複合
     
      comobobox 標籤用於產生一個下拉式列示方塊(Combob Box)。
      ComoboBox 的特點就是可選擇可編輯。
      既可以選擇下拉清單中已有的值，又可以填寫下拉清單中沒有的值。   
    --%>
    
    <struts:form action="/tags/comoboboxSubmmit.action" >
      <struts:combobox list="%{favouriteList}" name="favourite" label="最喜歡的水果" />  
      <struts:submit value="提 交" align="center" />
    </struts:form>
    
  </body>
  
</html>