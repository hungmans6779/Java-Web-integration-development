<%@ page language="java" pageEncoding="UTF-8" %>

<%@ taglib uri="http://struts.apache.org/tags-html"    prefix="html"   %>
<%@ taglib uri="http://struts.apache.org/tags-bean"    prefix="bean"   %> 
<%@ taglib uri="http://struts.apache.org/tags-logic"   prefix="logic"  %> 
<%@ taglib uri="http://struts.apache.org/tags-nested"  prefix="nested" %>

<html> 

  <head>
	<title>nestedTag.jsp</title>
    <script type="text/javascript" src="/struts1.2/js/calendar.js" ></script>
	<style type="text/css">
      body{
        font-size: 12px; 
      }
    </style>
  </head>

  <body>
		
	<html:form action="/nestedTag" >
	  <html:hidden property="action" value="add" />
	  <%--
	      帳號：<nested:text property="person.account" /><br>
	      姓名：<nested:text property="person.name" /><br>
	 
	     生日： <nested:text property="person.birthday" onfocus="setday(person.birthday);" />   
            <img src="${pageContext.request.contextPath}/images/calendar.gif" onclick="setday(person.birthday);" /><br>
                愛好：
            <nested:checkbox property="hobby" value="足球" >足球</nested:checkbox>
            <nested:checkbox property="hobby" value="影視" >影視</nested:checkbox>
            <nested:checkbox property="hobby" value="音樂" >音樂</nested:checkbox>
            <nested:checkbox property="hobby" value="美食" >美食</nested:checkbox> 
            <nested:checkbox property="hobby" value="旅遊" >旅遊</nested:checkbox>
            <nested:checkbox property="hobby" value="攝影" >攝影</nested:checkbox><br>
                                是否隱藏姓名：<nested:checkbox property="person.secret" /><br><br>       
      --%>                         
        <nested:nest property="person" >
                          當前層次：<nested:writeNesting /><br/> <!-- 輸出當前的層次 -->
                          帳號：<nested:text property="account" /><br>
                          姓名：<nested:text property="name" /><br>
                          生日：<nested:text property="birthday" /><br>
                          愛好：
               <nested:checkbox property="hobby" value="足球" >足球</nested:checkbox>
               <nested:checkbox property="hobby" value="影視" >影視</nested:checkbox>
               <nested:checkbox property="hobby" value="音樂" >音樂</nested:checkbox>
               <nested:checkbox property="hobby" value="美食" >美食</nested:checkbox>
               <nested:checkbox property="hobby" value="旅遊" >旅遊</nested:checkbox>
               <nested:checkbox property="hobby" value="攝影" >攝影</nested:checkbox><br>
                         是否隱藏姓名：<nested:checkbox property="secret" /><br><br>
        
          <nested:nest property="createDate" >  
                              當前層次：<nested:writeNesting /><br>           
                              建立時間：<nested:text property="time" /><br>         
          </nested:nest>  
          
        </nested:nest>
                             
      <html:submit value="提交" />                              
      
	</html:form>
	
  </body>

</html>