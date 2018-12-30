<%@ page language="java" contentType="text/html;charset=UTF-8"  %>

<%@ page import="java.util.*" %>

<%@ taglib uri="/struts-tags"         prefix="struts"    %>
<%@ taglib uri="/struts-dojo-tags"    prefix="sx"        %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'mergeTag.jsp' starting page</title>
    <!-- 
      <struts:head theme="simple" />
    -->
    <sx:head />
  </head>
  
  <!-- 
    merge 標籤類似於 append 標籤，能將兩個List 連接成一個List。它們的用法完全一致。
    不同的是，append 標籤是先增加 maleList 的所有元素，後增加 femaleList 的所有元素。
    而 merge 標籤是先增加 maleList 的第一個元素，再增加femaleList 的第一個元素；
    再增加 maleList 的第二個元素，再增加 femaleList 的第二個元素...依此類堆。
    由於增加次序不一樣，顯示的順序也會不一樣。
  -->
  
  <body> 
    <!-- 
    <struts:merge id="myMergeList" >
      <struts:param value="maleList"    />
      <struts:param value="femaleList"  />
    </struts:merge>
    <struts:iterator value="myMergeList" >
      <struts:property />
      <br/>
    </struts:iterator>
   -->
   
    <struts:merge id="myMergeList" >
      <struts:param value="%{maleList}"    />
      <struts:param value="%{femaleList}"  />
    </struts:merge>
    <struts:iterator value="%{#myMergeList}" >
      <struts:property />
      <br/>
    </struts:iterator>
    
  </body>
  
</html>