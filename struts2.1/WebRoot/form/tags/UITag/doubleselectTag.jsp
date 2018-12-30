<%@ page language="java" contentType="text/html;charset=UTF-8" %>

<%@ taglib uri="/struts-tags"       prefix="struts" %>
<%@ taglib uri="/struts-dojo-tags"  prefix="sx"     %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'doubleselectTag.jsp' starting page</title>
    <sx:head />
  </head>
  
  <body>
  
    <%--
      doubleselect 聯動標籤選擇框
      doubleselect 標籤為聯動下拉清單，選擇第一個下拉清單時，
      第二個下拉清單的值為隨第一個下拉清單值的改變而改變。
    --%>
    <struts:form action="/tags/doubleselectSubmmit.action" >
      <struts:doubleselect name="province" 
                           list="provinceList" 
                           doubleName="city"
                           doubleList="cityMap.get(top)" 
                           label="請選擇省份、市" />
      <struts:submit value="提  交" align="center" />
    </struts:form>
    
  </body>
  
</html>