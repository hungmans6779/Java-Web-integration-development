<%@ page language="java" contentType="text/html;charset=UTF-8" %>

<%@ taglib uri="/struts-tags"       prefix="struts" %>
<%@ taglib uri="/struts-dojo-tags"  prefix="sx"     %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'treeFile.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <sx:head debug="false" />
  </head>
  
  <body>
    
    <struts:set name="i" value="0" />
    <sx:tree id="root" 
             rootNode="%{#request.file}"
             nodeTitleProperty="file.name"
             nodeIdProperty="%{#i+1}"
             childCollectionProperty="children" />
  
  </body>
  
</html>