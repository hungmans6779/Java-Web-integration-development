<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"  errorPage="login.jsp" %>
<%
   request.setCharacterEncoding("UTF-8");
   
   String userName="";
   int visitTimes=0;
   
   Cookie [] cookies=request.getCookies();
   for(int i=0;cookies!=null&&i<cookies.length;i++){
     Cookie cookie=cookies[i];
     if("userName".equals(cookie.getName())){
       userName=cookie.getValue();
     }else if("visitTimes".equals(cookie.getName())){
       visitTimes=Integer.parseInt(cookie.getValue());
     }else{}
   } // end for(int i=0;cookies!=null&&i<cookies.length;i++){  

   if(userName == null || userName.trim().equals("")){
     throw new Exception("您還沒有登入，請先登入！！！");
   } // end if(userName == null || userName.trim().equals("")){ 

   Cookie visitTimesCookie=new Cookie("visitTimes",Integer.toString(++visitTimes));
   response.addCookie(visitTimesCookie);
   
   System.out.println("cookie.jsp  session ID = "+session.getId());
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'cookie.jsp' starting page</title>
  </head>
  
  <body>
   <div align="center" style="margin:10px; ">
	<fieldset>
		<legend>登录信息</legend>
		<form action="login.jsp" method="post">
			<table>
				<tr>
					<td>您的帐号：</td>
					<td><%= userName %></td>
				</tr>
				<tr>
					<td>登錄次數：</td>
					<td>${cookie.visitTimes.value}</td>
				</tr>
				<tr>
					<td></td>
					<td>
						<input type="button" value=" 刷  新 " onclick="location='<%= request.getRequestURI() %>?ts=' + new Date().getTime(); " class="button">
					</td>
				</tr>
			</table>
		</form>
	</fieldset>
</div>
  </body>
</html>
