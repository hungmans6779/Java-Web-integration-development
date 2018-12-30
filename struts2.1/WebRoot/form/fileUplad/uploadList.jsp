<%@ page language="java" contentType="text/html;charset=UTF-8" %>

<%@ taglib uri="/struts-tags"       prefix="struts"  %>
<%@ taglib uri="/struts-dojo-tags"  prefix="sx"      %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'uploadList.jsp' starting page</title>
    <sx:head />
    <style type="text/css">
	  body, td {
	    font-size: 12px; 
	  }
	</style>
  </head>
  
  
  <body>
    文件已經保存到：
    檔案路徑：<struts:property value="uploadFilePath" /> <br/>
    <a href="upload/<struts:property value='pictureFileName' />" target="_blank" >
      <struts:property value='pictureFileName' />
    </a>
    <br/><br/>
 
    &lt;&lt;<a href="upload.action" >  繼續上傳</a>
    
  </body>
  
</html>