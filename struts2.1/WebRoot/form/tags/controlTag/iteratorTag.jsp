<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*" %>

<%@ taglib uri="/struts-tags"       prefix="struts" %>
<%@ taglib uri="/struts-dojo-tags"  prefix="sx"   %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">


<html>
  <head>
    <title>iteratorTag.jsp</title>
    <sx:head />
  </head>
  
  <body>
  
    <!-- 
      iterator 標籤用於檢查集合(包括 List、Set、Map)、陣列等。可以使用 OGNL 運算式對資料進行過濾。
     -->
    <struts:iterator value="magazineList.{?#this.price>18}" >
      <struts:property value="#this.name" /> - ￥<struts:property value="#this.price" />
      <!-- 
        <struts:property value="name" /> - ￥<struts:property value="price" />
       -->
      <br/>
    </struts:iterator>
    
  </body>
  
</html>