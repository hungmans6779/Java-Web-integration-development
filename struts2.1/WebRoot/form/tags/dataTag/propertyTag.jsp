<%@ page language="java" contentType="text/html; charset=UTF-8"  %>

<%@ taglib uri="/struts-tags"       prefix="struts"  %>
<%@ taglib uri="/struts-dojo-tags"  prefix="sx"      %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'propertyTag.jsp' starting page</title>
    <sx:head />
  </head>
  
  <body>
    
    <!-- 
      property 標籤：用於定義一個變數，並設定變數的值。
    -->
    
    <struts:property value="id"                        /><br/>
    <struts:property value="%{#parameters.account[0]}" /><br/>
    <hr/>
    
    
    <struts:bean name="com.helloweenvsfei.struts2.action.bean.Magazine" id="magazine1" >
      <struts:property value="#magazine1.name" default="沒有找到 #magazine1.name" />
    </struts:bean>
    <hr/>
    
    
    <struts:bean name="com.helloweenvsfei.struts2.action.bean.Magazine" id="magazine2" >
      <struts:param name="name" value="%{'時代週刊'}" />
      <struts:param name="price" value="%{'100'}" />
      
      <struts:property value="#magazine2.name" default="沒有找到 #magazine2.name" /> - ￥ <struts:property value="#magazine2.price" default="沒有找到 #magazine2.price" />
    </struts:bean>
    <hr/> 
    
    
  </body>
  
</html>