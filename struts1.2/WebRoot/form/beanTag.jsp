<%@ page language="java" pageEncoding="UTF-8" %>

<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.helloweenvsfei.struts.bean.*" %>


<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean"   prefix="bean"  %> 

<%--
            參考頁面：http://struts.apache.org/1.2.9/userGuide/struts-bean.html
--%>


<%
   Person1 person1 = new Person1(); 
   person1.setName("張三");
   person1.setCreateDate(new Timestamp(System.currentTimeMillis())); 
   
   Person1 person2 = new Person1();
   person2.setName("李四");
   person2.setCreateDate(new Timestamp(System.currentTimeMillis()));
      
   request.setAttribute("person1",person1);
   request.setAttribute("person2",person2);


   Cookie cookie1 = new Cookie("kevinCK1","197867791");
   response.addCookie(cookie1);
   
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
    <title>beanTag.jsp</title>
  </head>
  
  <body>
   
   
   
    <font color='red'>&lt;bean:write&gt; 測試</font><br>
    <bean:write name="person1" /><br>
    <bean:write name="person1" property="createDate.time" /><br/>  <%-- getCreateDate().getTime() --%> 
    <hr>
    
   
   
   
   
   
   
    <font color='red'>&lt;bean:cookie&gt; 測試</font><br/> 
    <bean:cookie id="kevinID" name="kevinCK2" value="123" /><br>
    <bean:write name="kevinID" property="name" />的值為：<bean:write name="kevinID" property="value" /><br>
    <%
      String kevinID_name = kevinID.getName();
      String kevinID_value = kevinID.getValue();
      out.println("kevinID_name = "+kevinID_name);
      out.println("kevinID_value = "+kevinID_value);
    %>
    <br><br>
    <bean:cookie id="sessionID" name="JSESSIONID" />
    JSESSIONID_t1_1_name:<bean:write name="sessionID" property="name" /><br>
    JSESSIONID_t1_2_value:<bean:write name="sessionID" property="value" /><br>
    JSESSIONID_t2_1_name:${cookie.JSESSIONID.name}<br>
    JSESSIONID_t2_2_value:${cookie.JSESSIONID.value}<br><br>
    
    cookie kevinCK1:${cookie.kevinCK1.value} <br>
    cookie kevinCK2:${cookie.kevinID.value} <br>
    <hr/>
    
   
   
   
   
   
   
    <font color='red'>&lt;bean:parameter&gt; 測試</font><br/>
    <bean:parameter id="actionID" name="action" />
    action_t1_1_action:<bean:write name="actionID" /><br/>
    action_t1_2_action:${param.action}<br>
    action_t2_action:${param.action1}<br>
    <hr>
    
   
   
   
   
   
   
    <font color='red'>&lt;bean:header&gt; 測試</font><br>
    <bean:header id="hostID" name="host" />
    host_t1:<bean:write name="hostID" /><br>
    host_t2:${header.host}<br>
    <hr/>
    
   
   
   
   
   
   
    <font color='red' >&lt;bean:message&gt;測試</font><br>
    <!-- 讀取 \src\com\helloweenvsfei\struts\ApplicationResources.properties -->
    <bean:message key="hello.error.name" /><br>
    <bean:message key="hello.error.age" arg0="2" arg1="12" /><br>
    <hr/>
    
   
   
   
   
   
   
    <font color='red' >&lt;bean:page 測試&gt;</font><br>
    <bean:page id="var1" property="request" />
    <bean:page id="var2" property="application" />
    <h3>request：            <bean:write name="var1" /></h3>
    <h3>application： <bean:write name="var2"  /></h3>
    <hr>
    
   
   
   
   
   
   
    <font color='red' >&lt;bean:resource&gt;測試</font><br><br>
    <bean:resource id="web_info" name="/WEB-INF/web.xml" />
    <bean:write name="web_info" />
    <hr/>
    
   
   
   
   
   
   
    <font color='red' >&lt;bean:struts&gt; 測試</font><br>
    <bean:struts id="tagFormID" formBean="tagForm" />
    <bean:write name="tagFormID" property="name" /><br>
    <bean:write name="tagFormID" property="type" /><br>
    <bean:write name="tagFormID" property="class" /><br>
    <bean:write name="tagFormID" property="dynamic" /><br>
    <bean:struts id="tagMappingID" mapping="/tag" /><br>
    <bean:struts id="listID" forward="list" /><br>
    <hr> 
    
   
   
   
   
   
   
    <font color='red' >&lt;bean:include&gt;測試</font>
    <bean:include id="googleID" href="http://www.google.com.tw" />
    <bean:write name="googleID" filter="false" />
    <hr>
    
   
   
   
   
   
   
    <font color='red' >&lt;bean:size 測試&gt;</font><br>
    <%
      ArrayList <Integer> list = new ArrayList<Integer>();
      list.add(new Integer(1));
      list.add(new Integer(2));
      list.add(new Integer(3));
      
      pageContext.setAttribute("listforcount",list);
    %>
    <bean:size id="listforcountID" name="listforcount" />
          長度：<bean:write name="listforcountID" /> 
    <hr>
    
   
  </body>
  
</html>