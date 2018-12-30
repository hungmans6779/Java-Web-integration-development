<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>viewCat.jsp</title>
    <style type="text/css" >
      body,div,td,th {
	    font-size: 12px;
      }
      table{
	    border-collapse: collapse;
	    border: 1px solid #000000;
      }
      th,td {
	    border: 1px solid #000000;
	    padding: 2px;
	    padding-left: 5px;
	    padding-right: 5px;
      }
      a{
	    color: blue;
      }
      a:hover {
	    color: red; 
      } 
    </style>
  </head>
  
  <body>
          查看 Cat 資料 <span style="margin-left:2px" ></span> [ <a href="catServlet?action=initAdd" >添加 Cat</a> ] [ <a href="catServlet?action=list" > Cat 列表</a> ]
    <table>
      <tr>
        <td>Name:</td>
        <td>${cat.name}</td>
      </tr>
      <tr>
        <td>Mother:</td>
        <td>${cat.mother.name}</td>
      </tr>
      <tr>
        <td>Description:</td>
        <td>${cat.description}</td>
      </tr>
      <tr>
        <td>Create Date:</td>
        <td>${cat.createDate}</td>
      </tr>
    </table>
  </body>
  
</html>
