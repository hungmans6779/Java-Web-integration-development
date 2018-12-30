<%@ page language="java" pageEncoding="UTF-8" %>

<%@ page import="java.util.*" %>

<%@ taglib uri="/struts-tags"        prefix="struts" %>
<%@ taglib uri="/struts-dojo-tags"   prefix="sx"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
  <head>
    <title>welcome.jsp</title>
    <!-- 宣告使用 Ajax 主題  -->
    <%--
                   參閱文件：http://www.iteye.com/topic/235649
                   应该是2.1.2以上版本的，要在工程中加个struts2-dojo-plugin.jar 
       <struts:head theme="ajax" />
    --%>
    <sx:head />
  </head>
  
  <body>   
           登入成功，歡迎您，<struts:property value="account" />  <!-- 顯示 Action 裡的 account 屬性  -->                  
  </body>
  
</html>