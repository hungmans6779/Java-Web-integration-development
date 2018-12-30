<%@ page language="java" pageEncoding="UTF-8" %>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
 
 
<html> 

  <head>
    <title>JSP for UploadForm form</title>
  </head>
	
  <body>
  
	<html:form action="/upload?action=upload" enctype="multipart/form-data" >
	     文件：<html:file     property="file" style="width:200px" ></html:file><br>
	     備註：<html:textarea property="text" style="width:200px" ></html:textarea><br><br>   
	    
	  <html:submit value="開始上傳" />
	</html:form>
	
  </body>
	
</html>

