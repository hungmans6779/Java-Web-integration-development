<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%
  Map <String,String> hm=new TreeMap<String,String>();
 
  hm.put("1","lynn");
  hm.put("2","kevin");
  hm.put("3","kent");
  hm.put("4","jessie");
  hm.put("5","kuo");
  request.setAttribute("hmObj",hm);
  
%>
<html>
  <head>
    <title>JSTL forEachWithMap</title>
    <style>
      table {
	      border-collapse: collapse;
	      border: 1px solid #000000;
      }
      td {
	      border: 1px solid #000000; 
	      font-size: 12px; 
	      padding: 2px; 
      }
      .title td {
	      text-align: center;
	      background: #cccccc; 
      }
    </style>
  </head>
  
  <body>
    <table>
      <tr>
        <td>Name</td>
        <td>Value</td>
      </tr>
      <c:forEach items="${hmObj}" var="item" >
        <tr>
          <td>${item.key}</td>
          <td>${item.value}</td>
        </tr>
      </c:forEach>
    </table>
  </body>
</html>
