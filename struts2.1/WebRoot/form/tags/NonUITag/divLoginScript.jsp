<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*" %>

<%@ taglib uri="/struts-tags"       prefix="struts" %>
<%@ taglib uri="/struts-dojo-tags"  prefix="sx"     %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
  <head>
    <title>divLoginScript.jsp</title>
    <sx:head />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page" >
  </head>
  
  <body>


    <struts:bean id="date" name="java.util.Date" />
    
    <!--  如果登入成功 -->
    <struts:if test="%{#request.status=='success'}" >  
      歡迎您！！！<struts:property value="%{#session.username}" />. 登入時間：<struts:date name="%{date}" />. 

	  <struts:url id="divLogoutUrl" action="divLoginTag!logout" /> <br/>
	  註銷使用的網址：<struts:property value="%{divLogoutUrl}" /><br/>
	  <struts:a href="%{#divLogoutUrl}" executeScripts="true"  >注銷</struts:a> 
 
	  <script type="text/javascript" >
		document.getElementById('errorDiv').innerHTML = '';
		document.getElementById('loginDiv').style.display = 'none';
		document.getElementById('loginSuccessDiv').style.display = '';
	  </script>
    </struts:if>
    <struts:elseif test="%{#request.status == 'failed'}" >
      <script type="text/javascript" >
		document.getElementById('errorDiv').innerHTML = "登入失敗，錯誤的使用者名稱密碼";
	  </script>
    </struts:elseif>
    <struts:elseif test="%{#request.status =='logout'}" >
      <script type="text/javascript" >
        document.getElementById('errorDiv').innerHTML = '';
	    document.getElementById('loginDiv').style.display = '';
		document.getElementById('loginSuccessDiv').style.display = 'none';
	  </script>
    </struts:elseif>
    <struts:else>
      <script type="text/javascript" >
        alert('other status');
      </script>
    </struts:else>
   
  </body>
  
</html>