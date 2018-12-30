<%@ page language="java" contentType="text/html; charset=UTF-8" %>
 
<%@ taglib uri="/struts-tags"       prefix="struts" %>
<%@ taglib uri="/struts-dojo-tags"  prefix="sx" %>

<%@ page import="java.util.*" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'ognlSuccess.jsp' starting page</title>
    <struts:head theme="simple" />
    <style type="text/css">
      body,td {
	    font-size: 12px;
      }
    </style> 
  </head>
  
  <body> 
     
     
    &lt; # &gt; 顯示宣告 OGNL 運算式 <br/>
    <%--
      # 是 Struts2.x 標籤常用的符。主要有3種用途：
      ● 能夠存取 OGNL 上下文與 ActionContext 資源，相當於  ActionContext.getContext()。常用的 #屬性表：
        #parameters：request 傳送的所有參數。
        #request：request 裡的所有屬性。
        #session：session 裡的所有屬性。
        #application：ServletContext 裡的所有屬性。
        #attr：request 或 session 或 application 的所有屬性。
      ● 用於過濾或篩選集合，例如：books.{#this.price<20}，表示所有的 price<20 的書。 
      ● 建構 Map，如 #{'foo1':'bar1','foo2','bar2'}。
    --%>
    <%-- OGNL寫法： --%>
    所有的 ID:<struts:property value="#parameters.id" /><br>
    第一個 ID:<struts:property value="#parameters.id[0]" /> <br/>
    第二個 ID:<struts:property value="#parameters.id[1]" /> <br/>
    <%-- 一般寫法： --%>
    所有的 ID:<%= Arrays.toString(request.getParameterValues("id")) %><br/>
    第一個 ID: <%= request.getParameterValues("id")[0] %><br/>
    <%-- EL寫法： --%>
    所有的 ID:${paramValues.id}<br/>
    第一個 ID:${paramValues.id[0]}<br/>
    第二個 ID:${paramValues.id[1]}<br/>
    <hr/>
    
    
    request 中取屬性：    <struts:property value="#request.account" /><br/>
    session 中取屬性：    <struts:property    value="#session.account" /><br/>
    application 中取屬性：<struts:property value="#application.account" /><br/>
    request 中取屬性：    ${requestScope.account} <br/>
    session 中取屬性：    ${sessionScope.account }<br/>
    application 中取屬性：${applicationScope.account }<br/>
    
    attr 中取屬性： <struts:property value="#attr.account"  /><br/>
    <hr/>
    
    
    
    價格大於18元的共有 <struts:property value="magazineList.{?#this.price>18}.size()" />本，分別是：<br/>
    <struts:iterator value="magazineList.{?#this.price>18}" >
      <struts:property value="name" /> - ￥ <struts:property value="price" /><br/>
    </struts:iterator>
    <hr/>
    
    
    
    
    名稱包含"時代"二字的雜誌共有<struts:property value="magazineList.{?#this.name.contains('時代')}.size()" />本，分別是：<br/>
    <struts:iterator value="magazineList.{?#this.name.contains('時代')}" >
      <struts:property value="name" /> - ￥<struts:property value="price" />.<br/>
    </struts:iterator>
    <hr/>
    
    
    
    "足球之夜"的價格為 ￥ <struts:property value="magazineList.{?#this.name.contains('足球之夜')}[0].price" /><br/>
    <hr/>
    
    
    
    
    
    
    
    
    
    
    
    
    &lt; % &gt; 顯示宣告 OGNL 運算式 <br/>
    <%--
      % 表示某字串為一個OGNL 運算式。某些標籤中既能接受字串，又能接受 OGNL 運算式。
        這時候，標有 % 的被當做OGNL 運算式並被執行，沒有標有 % 的被當做普通字串。
    --%>
    <struts:label label="#request.account" /><br/> 
    <struts:label label="%{#request.account}" /><br/>
    <hr/> 
     
    
     
     
     
     
     
    &lt; $ &gt; 顯示宣告 OGNL 運算式 <br/>
    <%--
       主要用於在資源國際化檔案中或者 struts.xml 中 
    --%> 
     
     
     
     
     
         
  </body>
  
</html>