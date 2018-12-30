<%@ page language="java" pageEncoding="UTF-8" %>

<%@ page import="java.util.*" %>

<%@ page import="java.util.*" %>
<%@ page import="java.text.NumberFormat" %>
<%@ page import="java.text.DecimalFormat" %>

<%@ page import="com.helloweenvsfei.hibernate.util.*" %>
<%@ page import="com.helloweenvsfei.hibernate.bean.Employee" %>
<%@ page import="com.helloweenvsfei.hibernate.bean.Department" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>listDepartment.jsp page</title>
  </head>
  
  <body>
  

    <table>    
      <tr>
        <%if("id".equals(request.getAttribute("sort"))){ %>
            <th class="sortable sorted ${order}" >
              <a href="${url}action=list&sort=id&order=${order=='asc'?'desc':'asc'}" >編號</a>
            </th>
        <%}else{%>
            <th class="sortable" >
              <a href="${url}action=list&sort=id&order=asc" >編號</a>
            </th>
        <%}%>
      </tr>
      <%
        List<Department> departmetnList =(List<Department>)request.getAttribute("departmentList");
        for(int i=0;departmetnList!=null && i < departmetnList.size();i++){
          Department d = departmetnList.get(i);       // 目前部門
          Employee lineManager = d.getLineManager();  // 部門經理
        
          out.println("<tr class='"+(i%2==0?"even":"odd")+"' >");
          out.println("  <td>"+d.getId()+"</td>"); 
          out.println("  <td>"+d.getName()+"</td>"); 
          out.println("  <td>"+(lineManager ==null?"":lineManager.getName())+"</td>");
          out.println("  <td>");
          out.println(d.getEmployees().size());  // 輸出員工數
          if(d.getEmployees().size() > 0){
            out.println("(");
            for(Employee ee:d.getEmployees()){  
              out.println(ee.getName()+", ");  // 輸出員工姓名
            } // end for(Employee ee:d.getEmployees()){
            out.println(")");
          }
          out.println("  </td>");  
          out.println("  <td>");
          out.println("    <a herf=/servlet/DepartmentServlet?action=edit&id="+d.getId()+" >修改</a>");
          out.println("    <a onclick=\"return confirm('確定刪除該部門?')\" href=/servlet/DepartmentServlet?action=delete&id="+d.getId()+" >刪除</a>");
          out.println("  </td>");
          out.println("</tr>");
        } // end for(int i=0;departmetnList!=null && i < departmetnList.size();i++){
      %>
      
      
      
    </table>
  </body>
  
</html>
