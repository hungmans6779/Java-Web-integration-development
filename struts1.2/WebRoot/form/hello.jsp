<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %> 

 
<html> 
  <head>
	<title>JSP for HelloForm form</title>
  </head>
  <body>
    
	<html:form action="/hello" >
	    姓名： <html:text property="name" /><b><html:errors property="name" /></b><br/>
              年齡 ： <html:text property="age"  /><b><html:errors property="age"  /></b><br/>
             是否用過 Struts?：<html:checkbox property="experience" /><br/>
	   愛好：
	  <html:checkbox property="hobby" value="音樂" /> 音樂
	  <html:checkbox property="hobby" value="體育" /> 體育
	  <html:checkbox property="hobby" value="影視" /> 影視
	  <b><html:errors property="hobby" /></b></br>
	     日期：<html:text property="date" /><br>
	     時間：<html:text property="time" /><br>
	  <html:submit/><html:cancel/> 
	</html:form>
	  
  </body>
	
</html>