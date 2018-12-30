<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>

<jsp:useBean id="person" class="com.helloweenvsfei.jsp.bean.Person"  scope="request" />
<jsp:setProperty name="person" property="*" />

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'userBean.jsp' starting page</title>
    <link rel="stylesheet" type="text/css"  href="style.css" />
  </head>
  
  <body>
    <div align="center">
      <form action="userBean.html" method="get" >
        <fieldset style='width:300pt'>
          <legend> 請填寫Person 資訊</legend> 
          <table align="center" width="400" >
            <tr>
              <td>姓名</td>
              <td>${person.name}</td>
            </tr>
            <tr>
              <td>年齡</td>
              <td>${person.age }</td>
            </tr>
            <tr>
              <td>性別</td>
              <td>${person.sex}</td>
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
