<%@ page language="java" contentType="text/html;charset=UTF-8" %>

<%@ taglib uri="/struts-tags"       prefix="struts"  %>
<%@ taglib uri="/struts-dojo-tags"  prefix="sx"      %>

<%
   Thread.sleep(1000);
%>

<sx:head />
<style type="text/css">
  <!--
    div,body,td {
	   font-size: 12px;
    }
  //-->    
</style>

<div style="padding: 10px; width: 350px; background-color: #E5E5E5;">
      
      
  <%-- 檢查 List 中的所有新聞  --%>
  <struts:iterator value="%{news}" >  
    <struts:property /><br>  <%-- 輸出 --%>
  </struts:iterator>
    
    
  <struts:if test="%{key==''}" >
    <hr />
	<struts:set name="updatedTimes" value="%{#session.updatedTimes + 1}" />
	<struts:set name="update" value="%{#session.updatedTimes = #updatedTimes}" />
	第 <struts:property value="#session.updatedTimes" /> 次更新, 
                      
    <struts:bean name="java.util.Date" id="date" />
    時間:<struts:date name="#date" format="yyyy-MM-dd HH:mm:ss" />
  </struts:if>
      
      
</div>