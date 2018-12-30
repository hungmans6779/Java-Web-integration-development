<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>

<%@ page import="java.net.URLEncoder" %>
<jsp:directive.page import="sun.misc.BASE64Encoder"/>
<jsp:directive.page import="java.io.InputStream"/>
<jsp:directive.page import="java.io.File"/>

<%
  File file=new File(this.getServletContext().getRealPath("cookie.gif"));
  byte [] binary=new byte[(int)file.length()]; 
 
  InputStream ins=this.getServletContext().getResourceAsStream(file.getName());
  ins.read(binary);
  ins.close();
  
  String content=URLEncoder.encode(BASE64Encoder.class.newInstance().encode(binary),"UTF-8");
  System.out.println(content);
  
  try{
    Cookie cookie=new Cookie("file",content);
    response.addCookie(cookie);
  }catch(Exception e){
    out.println("<hr>");
    out.println(e.getMessage());
    out.println("<hr>");
  }
  
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>Cookie Encoding</title>
</head>
<body>
从 Cookie 中获取到的二进制图片：<img src="base64_decode.jsp" /> <br/>
<textarea id='cookieArea' style='width:100%; height:200px; '></textarea>
<script type="text/javascript">cookieArea.value=document.cookie;</script>
</body>
</html>
