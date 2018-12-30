<%@ page language="java" contentType="text/html;charset=UTF-8" %>

<%@ taglib uri="/struts-tags"        prefix="struts"  %>
<%@ taglib uri="/struts-dojo-tags"   prefix="sx"      %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'optiontransferselectTag.jsp' starting page</title>
    <sx:head />
  </head>
  
  <body>
  
    <%--
      optiontransferselect 標籤：左右各有一個清單，右邊的選項可以轉到左邊，左邊的選項也可以轉到右邊。
      optiontransferselect 標籤是利用兩個 <select> 實現的。  
    --%>
    <struts:form action="/tags/optiontransferselectSubmmit.action" >
      <struts:optiontransferselect name="province"
                                   list="%{provinceUnselected}"
                                   doubleName="city"
                                   doubleList="%{provinceSelected}"
                                   leftTitle="已經勾選的省份"
                                   leftUpLabel="向上"
                                   leftDownLabel="向下"
                                   rightTitle="剩餘的省份"
                                   rightUpLabel="向上"
                                   rightDownLabel="向下"
                                   headerKey=""
                                   headerValue="---請選擇省份---" >
      </struts:optiontransferselect>
      <struts:submit value="提 交" align="center" />
    </struts:form>
  </body>
  
</html>