<%@ page language="java" contentType="text/html;charset=UTF-8" %>

<%@ taglib uri="/struts-tags"       prefix="struts" %>
<%@ taglib uri="/struts-dojo-tags"  prefix="sx"      %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
  <head>
    <title>My JSP 'textTag.jsp' starting page</title>
    <sx:head />
  </head>
  
  <body>
    <struts:text name="struts.messages.error.uploading" /><br/>
    <hr/>
    <struts:i18n name="otherResources" >
      <struts:text name="hello.world" />
    </struts:i18n><br/>
    <hr/>
    
    <struts:text name="none.resource">没有资源，显示标签体内的字符串。</struts:text> <br/>
    <hr/>
    
    <struts:text name="沒有資源，也沒有標籤體內容，則顯示 name的屬性" /><br/>
    <hr/>
    
    <struts:property value="%{getText('struts.messages.error.uploading') }" /><br/>
    <hr/>
    
  </body>
  
</html>
