<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib uri="http://jakarta.apache.org/struts/tags-html"   prefix="html"  %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic"  prefix="logic" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean"   prefix="bean"  %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>listCat2 page</title>
    <style type="text/css" >
	  <!--
	    body, td, th, input { font-size: 12px; }
		table { border-collapse: collapse; border: 1px solid #000000; }
		th, td {border-collapse: collapse; border: 1px solid #000000; padding: 4px; }
      //-->
    </style>   
  </head>
  
  <body>
    
    <html:form action="/cat2" >
      <input type="hidden" name="action" value="add" />     <!-- 隱藏欄位，action 參數 -->
      <html:text property="name" />                         <!-- 文字琙 Cat 的名字 -->
      <html:submit value="增加"  />                         <!-- 傳送按鈕  -->
    </html:form> 
    
    <table>
      <tr>
        <th>ID</th>
        <th>Name</th>
        <th>CreateDate</th> 
      </tr>
      <logic:iterate id="cat" name="catList" >
        <tr>
          <td><bean:write name="cat" property="id" /></td>           <!--  輸出 id -->
          <td><bean:write name="cat" property="name" /></td>         <!--  輸出 name -->
          <td><bean:write name="cat" property="createDate" /></td>   <!--  輸出createDate -->
        </tr>
      </logic:iterate> 
    </table>
    
  </body>
  
</html>
