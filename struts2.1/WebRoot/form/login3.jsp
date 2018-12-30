<%@ page language="java" pageEncoding="UTF-8" %>


<!-- 標籤函式庫  taglib 宣告  -->
<%@ taglib uri="/struts-tags"       prefix="struts"  %>
<%@ taglib uri="/struts-dojo-tags"  prefix="sx"      %> 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>login3.jsp</title>
    
    <!-- 宣告使用 Ajax 主題  -->
    <%--
                   參閱文件：http://www.iteye.com/topic/235649
                    应该是2.1.2以上版本的，要在工程中加个struts2-dojo-plugin.jar 
       <struts:head theme="ajax" />
    --%>
    <sx:head />
  </head>
  
  <body>
   
    <struts:form action="loginPerson3" >
      <struts:label value="登入系統" ></struts:label>      <!-- 文字標籤 -->
      <struts:textfield name="account"  label="帳號"   />  <!-- 文字輸入框 -->
      <struts:password  name="password" label="密碼"   />  <!-- 密碼輸入框  -->
      <struts:submit value="登入" />                       <!-- 傳送鈕  -->
    </struts:form>
   
  </body>
  
</html>