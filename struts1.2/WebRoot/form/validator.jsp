<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<html> 
	
  <head>
	<title>vaildator.jsp</title>
    <style type="text/css" >
      <!--
		body {font-size: 12px; }
	  //-->		
	</style>
  </head>

  <body>
	<html:form action="/validator" onsubmit="return validateValidatorForm(this);" >  <!-- 驗證  -->
	      姓名：           <html:text property="name"  /><html:errors property="name"  /><br>
	      年齡：           <html:text property="age"   /><html:errors property="age"   /><br>
	       電子郵件：<html:text property="email" /><html:errors property="email" /><br>
	  
	  <html:submit value="傳送" />
      <html:javascript formName="validatorForm" />  <!-- 宣告驗證指令稿  -->
      <!-- 補充： html:javascript formName 與  /WEB-INF/validation.xml 中配置的 form 的 name 屬性遙相呼應。   -->
	</html:form>

  </body>

</html>