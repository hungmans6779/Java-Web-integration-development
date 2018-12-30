<%@ page language="java" contentType="text/html;charset=UTF-8" %>

<%@ taglib uri="/struts-tags"      prefix="struts"  %>
<%@ taglib uri="/struts-dojo-tags" prefix="sx"      %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'errorInputTag.jsp' starting page</title>
    <sx:head />
  </head>
  
  <body>
    
    <%--
        ActionError、ActionMessage、FieldError 標籤錯誤資訊
        這3個標籤用於在JSP 中顯示攔截器或者Action 中的訊息。
        
        (1) ActionError 標籤：用於顯示Action 中的錯誤訊息。
        (2) ActionMessage 標籤：用於顯示 aCTION 中的訊息。
        (3) FiledError 標籤：用於顯示資料驗證錯誤資訊。
    --%>
    
    ActionErrors:(Action 錯誤訊息)
    <div style="color:red;font-weight:bold;" >
      <struts:actionerror />	
    </div>
    <hr/>
    
    ActionMessags：(Action 訊息)
    <div style="color:green;font-weight:bold;" >
      <struts:actionmessage />
    </div>
    <hr/>

    FieldErrors:(域錯誤訊息)
    <div style="color:red;font-weight:bold;" >
      全部 FiledError(錯誤訊息)：<struts:fielderror /><br/>
      姓名(錯誤訊息)：<struts:fielderror  fieldName="username" /><br/>
      密碼(錯誤訊息)：<struts:fielderror  fieldName="password" /><br/>
    </div>
    <hr />
    
    
    
    
    
    <struts:form action="/tags/errorTag.action" method="get" >
      
      <struts:label label="ActionError、ActionMessage、FieldError 示範" />
      
      <%-- 執行 error Method() --%>
      <struts:submit value="執行 error()" method="error" />  
        
      <%-- 執行 message Method() --%>  
      <struts:submit value="執行 message()" method="message" />
      
      <%-- 執行 fieldError Method() --%>
      <struts:submit value="執行 fieldMessage()"  method="fieldError" />
      
    </struts:form>
    
    
    
  </body>
  
</html>
