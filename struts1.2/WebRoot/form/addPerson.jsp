<%@ page language="java" pageEncoding="UTF-8" %>

<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>

 
<html> 
  <head>
	<title>JSP for PersonForm form(addPerson.jsp)</title>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/calendar.js" ></script>
	<style type="text/css">
      body{
        font-size: 12px; 
      }
    </style>
  </head>
  <body>
    <html:form action="/person" >
      <html:hidden property="action" value="add" />
                帳號：<html:text property="account" /><html:errors property="account" /><br>
                姓名：<html:text property="name"    /><html:errors property="name"    /><br>
                生日：<html:text property="birthday" onfocus="setday(birthday);" />   
            <img src="${pageContext.request.contextPath}/images/calendar.gif" onclick="setday(birthday);" />
            <html:errors property="birthday" /><br>
                愛好：
            <html:checkbox property="hobby" value="足球" >足球</html:checkbox>
            <html:checkbox property="hobby" value="影視" >影視</html:checkbox>
            <html:checkbox property="hobby" value="音樂" >音樂</html:checkbox>
            <html:checkbox property="hobby" value="美食" >美食</html:checkbox> 
            <html:checkbox property="hobby" value="旅遊" >旅遊</html:checkbox>
            <html:checkbox property="hobby" value="攝影" >攝影</html:checkbox>
            <html:errors   property="hobby" /><br>
                                是否隱藏姓名：<html:checkbox property="secret" /><br><br>       
            <html:submit value="提交" />                                 
    </html:form>

  </body>
  
</html>