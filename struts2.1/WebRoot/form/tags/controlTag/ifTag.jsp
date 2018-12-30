<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*" %>

<%@ taglib uri="/struts-tags"      prefix="struts" %>
<%@ taglib uri="/struts-dojo-tags" prefix="sx" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>ifTag.jsp</title>
    <sx:head />
  </head>
  
  <body>
    
    <struts:form action="/tags/ifTag.action" >
      <struts:textfield name="name" label="姓名" /><br/>
      <struts:submit value="傳送" />
    </struts:form> 
    
    
    <%--
       <struts:if> <struts:elseif> <struts:else> 可以連用;
        if 及 elseif 都有 test屬性，傳回 true 或者 false。
    --%>
  
    <struts:if test="#parameters.name[0]!=''" >
      
      <!-- 利用 requset 參數判斷 -->
      &lt;利用 requset 參數判斷   &gt;  <br/><br/>
      <struts:if test="#parameters.name[0]=='kevin'">
        Hello,kevin 您好... 
      </struts:if>
      <struts:elseif test="#parameters.name[0] == 'hungmans6779'" >
        Hello,hungmans6779 您好...
      </struts:elseif>
      <struts:else>
        Hello, 匿名使用者 <struts:property value="#parameters.name[0]" /> 您好...
      </struts:else> 
      <br/><br/>  
      <hr />
      
      
   
      <!-- 利用 action 做判斷 -->
      &lt;利用 action 做判斷 &gt;  <br/><br/>
      <struts:if test="name.equals('kevin')" >
        Hello, kevin 您好... 
      </struts:if>
      <struts:elseif test="name=='hungmans6779'" >
        Hello, hungmans6779 您好...
      </struts:elseif>
      <struts:else>
        Hello, 匿名使用者 <struts:property value="name" />  您好...
      </struts:else>    
      <hr />
    
    
    </struts:if>  
     
  </body>
  
</html>