<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.net.*" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'encoding.jsp' starting page</title>
  </head>
   
  <body>
    <%
       Cookie ck=new Cookie(URLEncoder.encode("姓名","UTF-8"),URLEncoder.encode("洪嘉宏","UTF-8"));
       response.addCookie(ck);
       
       Cookie [] cookies=request.getCookies();
       for(int i=0;i<cookies.length;i++){
         String name=URLDecoder.decode(cookies[i].getName(),"UTF-8");
         String value=URLDecoder.decode(cookies[i].getValue(),"UTF-8");
         out.println(name+" = "+value+"<br>");
       }
    %>
    <hr>
      session getId() = <%= session.getId() %>
    <hr>
     EL JSESSIONID = ${ cookie.JSESSIONID.value}
    <hr>
  </body>
</html>
