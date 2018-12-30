<%@ page language="java" contentType="text/html;charset=UTF-8" %>

<%@ taglib uri="/struts-tags"       prefix="struts"  %>
<%@ taglib uri="/struts-dojo-tags"  prefix="sx"      %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'divLogin.jsp' starting page</title>
    <meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page" >
    <sx:head />
    <style type="text/css">
      <!--
        div,body,td,span {
	      font-size: 12px;
        }
        
        form {
	      padding: 0px; 
	      margin: 0px; 
        }
        
        .div {
	      padding: 10px;
	      width: 520px;
	      background-color: #E5E5E5;
        }

        #errorDiv {
	      color: red;
	      text-align: center;
	      font-weight: bold; 
        }
        
      //-->
    </style>
  </head>
  
  
  <body>
    <%--
        本例使用 JavaScript 程式的例子。使用Ajax 實現無更新登入、註銷。
        登入前頁面顯示登入表單，登入後顯示歡迎資訊，並利用傳回的 JavaScript 把登入表單隱藏。
        按一下註銷後，又利用傳回的JavaScript 把歡迎資訊隱藏，把登入表單顯示出來。
    
    --%>
    <div class="div" id="loginDiv" >
      
      <%-- 錯誤資訊 --%>
      <div id="errorDiv" ></div>
      
      <struts:form name="divLoginForm" id="divLoginForm" >
        <struts:label label="請輸入使用者名稱和密碼" />
        <struts:textfield name="username"  label="帳號" value="kevin" />
        <struts:password  name="password"  label="密碼" value="1234" title="1234" />
        <struts:url id="divLoginUrl" action="divLoginTag!login"  />
        <sx:submit value="登 入" formId ="divLoginForm"  href="%{divLoginUrl}" targets="loginSuccessDiv" executeScripts="true" /> 
      </struts:form>
    
    </div> <%-- end class="div" id="loginDiv"  --%>
    
    <hr/>
    
    更處理的網址：<struts:property value="%{divLoginUrl}" />
    <hr/>
    
    <%-- 成功資訊 --%>
    成功資訊：<br />
    <div id="loginSuccessDiv" class="div" style="display:none;" /> 
     
  </body>
  
</html>