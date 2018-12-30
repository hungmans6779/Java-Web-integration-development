<%@ page language="java" import="java.util.*" pageEncoding="BIG5"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'plugin.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
  <body>
  
    <table align=center bgcolor=#999999 cellspacing=1>
      <tr>
        <td bgcolor=#FFFFFF>
          <jsp:plugin 
	           code="Graph.class" 
	           codebase="http://java.sun.com/applets/jdk/1.4/demo/applets/GraphLayout/" 
	           type="applet"
	           width="500"
	           height="400">
	           <jsp:params>
		         <jsp:param name="edges" value="joe-food,joe-dog,joe-tea,joe-cat,joe-table,table-plate/50,plate-food/30,food-mouse/100,food-dog/100,mouse-cat/150,table-cup/30,cup-tea/30,dog-cat/80,cup-spoon/50,plate-fork,dog-flea1,dog-flea2,flea1-flea2/20,plate-knife"/>
		         <jsp:param name="center" value="joe" />
	           </jsp:params>
 	           <jsp:fallback>您 的瀏覽器不支援Java Applet</jsp:fallback>
          </jsp:plugin>
        </td>
      </tr>
    </table>
  </body>
</html>
