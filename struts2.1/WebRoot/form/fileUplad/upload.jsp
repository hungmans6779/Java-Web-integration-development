<%@ page language="java" contentType="text/html;charset=UTF-8" %>

<%@ taglib uri="/struts-tags"       prefix="struts"  %>
<%@ taglib uri="/struts-dojo-tags"  prefix="sx"      %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'upload.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <sx:head />
    <style type="text/css">
	  body, td {
	    font-size: 12px; 
	  }
	</style>
  </head>
  
  <body> 
    
    <!-- 顯示錯誤訊息 -->
    <struts:actionerror/>
    
    
    <struts:form action="upload" enctype="multipart/form-data" method="post" validate="true" >
      <struts:label value="上傳文件" />
      
      <struts:file name="picture" label="文件一" />
      <struts:submit value="開始上傳" method="upload" />
    </struts:form>
     
  </body>
  
</html>