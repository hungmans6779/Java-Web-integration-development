<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isErrorPage="true" %>
<%
   request.setCharacterEncoding("UTF-8");
   response.setCharacterEncoding("UTF-8");
   
   if("POST".equals(request.getMethod())){
     
     Cookie userNameCookie=new Cookie("userName",request.getParameter("userName"));
     Cookie visitTimesCookie=new Cookie("visitTimes","0");
     response.addCookie(userNameCookie);
     response.addCookie(visitTimesCookie);
     response.sendRedirect(request.getContextPath()+"/cookie.jsp");
     return ;
   } // end if("POST".equals(request.getMethod())){
   
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'login.jsp' starting page</title>
  </head>
  
  <body>
   <div align="center" style="margin:10px; ">
	<fieldset>
		<legend>登录</legend>
		<form action="login.jsp" method="post">
			<table>
				<tr>
					<td>
					</td>
					<td>
						<span><img src="images/errorstate.gif"></span>
						<span style="color:red; "><%= exception.getMessage() %></span>
					</td>
				</tr>
				<tr>
					<td>帐号：</td>
					<td><input type="text" name="userName" style="width:200px; "></td>
				</tr>
				<tr>
					<td>密码：</td>
					<td><input type="password" name="password" style="width:200px; "></td>
				</tr>
				<tr>
					<td>
					</td>
					<td>
						<input type="submit" value=" 登  录 " class="button" >
					</td>
				</tr>
			</table>
		</form>
	</fieldset>
</div>
   
  </body>
</html>
