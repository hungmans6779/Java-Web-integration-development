<%@ page language="java" contentType="text/html;charset=UTF-8" %>

<%@ taglib uri="/struts-tags"         prefix="struts"   %>
<%@ taglib uri="/struts-dojo-tags"    prefix="sx"       %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'subsetTag.jsp' starting page</title>
    <sx:head />
  </head>
  
  <body>
    <!-- 
      subset 標籤用於篩選集合裡的元素。
      它使用一個 Filter，將不合格的元素過濾掉，剩下原集合的一個子集。  
    --> 
   
    <!-- 篩選標籤 -->
    <struts:subset source="maleList" decider="decider" >  
      <struts:iterator>        <!-- 檢查篩選後的結果  -->        
        <struts:property />    <!-- 輸出每個檢查的值 -->
        <br/>
      </struts:iterator>
    </struts:subset>
    
  </body>
  
</html>