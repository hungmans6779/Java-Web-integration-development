<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>JSTL if</title>
  </head>
  
  <body>
    <fieldset>
      <c:if test="${param.action=='add'}" >
        <legend>增加操作</legend>
        <table>
          <tr>
            <td>帳號</td>
            <td><input type="text" name="login" /></td>
          </tr>
          <tr>
            <td>真寫姓名</td>
            <td><input type="text" name="name" /></td>
          </tr>
        </table>
      </c:if>
      <c:if test="${param.action=='edit'}" >
        <legend>修改操作</legend>
        <table>
          <tr>
            <td>帳號</td>
            <td><input type="text" name="login" /></td>
          </tr>
          <tr>
            <td>真寫姓名</td>
            <td><input type="text" name="name" /></td>
          </tr>
        </table>
      </c:if>
    </fieldset>
    
    <c:if test="1==1">測試1</c:if><br> 
    <c:if test="${1==1}">測試2</c:if><br>
    <c:if test="true" >測試3</c:if><br>
    <c:if test="${true}" >測試4</c:if><br>
  </body>
</html>
