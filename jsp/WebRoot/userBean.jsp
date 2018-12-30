<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>

<jsp:useBean id="person" class="com.helloweenvsfei.jsp.bean.Person"  scope="request" />
<jsp:setProperty name="person" property="*" />

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'userBean.jsp' starting page</title>
    <link rel="stylesheet" type="text/css"  href="style.css" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html; charset=UTF-8" >
  </head>
  
  <body>
    <div align="center">
      <form action="userBean.html" method="get" >
        <fieldset style='width:300pt'>
          <legend> 請填寫Person 資訊</legend> 
          <table align="center" width="400" >
            <tr>
              <td>姓名</td>
              <td><jsp:getProperty name="person" property="name" /></td>
            </tr>
            <tr>
              <td>年齡</td>
              <td><jsp:getProperty name="person" property="age" /></td>
            </tr>
            <tr>
              <td>性別</td>
              <td>
                <jsp:getProperty name="person" property="sex" />
              </td>
            </tr>
            <tr>
              <td></td>
              <td><input type="submit" name="search" value="返回 Person 資訊" class="button" /></td>
            </tr>                        
          </table>
        </fieldset>
      </form>
    </div> 
  </body>
</html>
