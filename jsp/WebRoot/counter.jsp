<%@ page language="java" import="java.util.*" pageEncoding="BIG5"%>

<jsp:useBean id="personCount" class="com.helloweenvsfei.jsp.bean.Couter"  scope="session" />
<jsp:useBean id="totalCount"  class="com.helloweenvsfei.jsp.bean.Couter"  scope="application" />

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'counter.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
     <div align="center">
        <fieldset style='width:300pt'>
          <legend> 請填寫Person 資訊</legend> 
          <table align="center" width="400" >
            <tr>
              <td>您的存取次數</td>
              <td><jsp:getProperty name="personCount" property="count" /></td>
            </tr>
            <tr>
              <td>總共的存取次數</td>
              <td><jsp:getProperty name="totalCount" property="count" /></td>
            </tr>                    
          </table>
        </fieldset>
    </div> 
  </body>
</html>
