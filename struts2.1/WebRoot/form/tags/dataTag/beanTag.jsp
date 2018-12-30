<%@ page language="java" contentType="text/html;charset=UTF-8" %>

<%@ taglib uri="/struts-tags"       prefix="struts"  %>
<%@ taglib uri="/struts-dojo-tags"  prefix="sx"      %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'beanTag.jsp' starting page</title>
    <sx:head />
  </head>
  
  <body> 
    
    <!-- 
      bean 標籤：用於參考某個 JavaBean，以便存取其 getter、setter 方法。
    -->
    <struts:bean name="com.helloweenvsfei.struts2.action.bean.Magazine" >
      <struts:param name="name" value="%{'kevin'}"  />
      <struts:property value="name" /><br/>
    </struts:bean>
    <hr/>
    
    <struts:bean name="com.helloweenvsfei.struts2.action.bean.Magazine" id="magazine2" >
      <struts:param name="name"  value="%{'壹周刊'}" />
      <struts:param name="price" value="%{'100'}"    />
    </struts:bean>
    <struts:iterator value="magazine2" >
      <struts:property value="%{name}" /> - ￥ <struts:property value="price" /><br/>
    </struts:iterator>
    <hr/>
    
  </body>
  
</html>