<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'BusinessException.jsp' starting page</title>
    <style type="text/css" >
      <!--
        .error{
           font-size:12px;
           padding:5px;
           border:1px solid #FF0000;
           background:url(images/error.gif) 8px 5px no-repeat #FFEEFF;
           padding-left:30px;
        }
      //-->
    </style>
  </head>
  
  <body>
    BusinessException jsp page. <br>
    
    <div class="error" >
      ${message} <a href="javascript:history.go(-1);" >傳回</a>
    </div>
  </body>
</html>
