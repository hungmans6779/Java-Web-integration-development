<%@ page language="java" contentType="text/html; charset=UTF-8" %>


<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
	<head>
		<title>i18n resource.jsp</title>
	</head>
	<body>
		<!-- 设置 Locale, 测试用 -->
		<!-- 在非中文環境顯示百合花 -->
		在非中文環境顯示百合花<br>
		<fmt:setLocale value="en_US"/>
		<fmt:bundle basename="com.helloweenvsfei.i18n.resource" >
		  <fmt:message key="message_1" ></fmt:message> <br/>
		  <fmt:message key="message_2" ></fmt:message> <br/>
		  <img src="<fmt:message key="image" />" />
		</fmt:bundle>
		
		<hr>
				 
		<!-- 在中文環境顯示牡丹花 -->
		在中文環境顯示牡丹花<br>
	    <fmt:setLocale value="zh_CN"/>
	     <fmt:bundle basename="com.helloweenvsfei.i18n.resource" >
		  <fmt:message key="message_1" ></fmt:message> <br/>
		  <fmt:message key="message_2" ></fmt:message> <br/>
		  <img src="<fmt:message key="image" />" />
		</fmt:bundle>
		
	</body>
</html>
