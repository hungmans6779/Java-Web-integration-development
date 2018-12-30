<%@ page language="java" contentType="text/html;charset=UTF-8" %>

<%@ taglib uri="/struts-tags"         prefix="struts"   %>
<%@ taglib uri="/struts-dojo-tags"    prefix="sx"       %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <title>My JSP 'treeFileAjax.jsp' starting page</title>
    <sx:head  />
    <style type="text/css" >
      body,div{
	    font-size: 12px;
      }
    </style>
  </head>
  
  <body>

    <div dojoType="TreeRPCController" 
         widgetId="treeController"
	     DNDcontroller="create" 
	     RPCUrl="/struts2.1/form/tags/NonUITag/treeFileAjaxData.jsp" ></div>

    <div dojoType="Tree" widgetId="appFiles" toggle="fade" controller="treeController" >
      <div dojoType="TreeNode" 
           title='<struts:property value="%{#request.file.name}" />'
	       widgetId='<struts:property value="%{#request.file.absolutePath}" />'
	       isFolder='<struts:property value="%{#request.file.directory}" />'
	       objectId='<struts:property value="%{#request.file.absolutePath}" />'></div>
    </div>         
    
     
  </body>
  
</html>
