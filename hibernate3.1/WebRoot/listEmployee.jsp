<%@ page language="java" pageEncoding="UTF-8" %>

<%@ page import="java.util.*" %>
<%@ page import="java.text.NumberFormat" %>
<%@ page import="java.text.DecimalFormat" %>


<%@ page import="com.helloweenvsfei.hibernate.util.*" %>
<%@ page import="com.helloweenvsfei.hibernate.bean.Employee" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>listEmployee.jsp page</title>
  </head>
  
  <body>
    <%
      String message=(String)request.getAttribute("message");
      if(!StringUtil.isNull(message)){
        out.println("<div class='message' >"+message+"</div>");
      }
    %>
    
    <table>
      <tr>
        <%if("id".equals(request.getAttribute("sort"))){%>
            <th class="sortable sorted ${ order }" >  <%-- 顯示小箭頭 --%>
              <a href="${url}action=list&sort=id&order=${order=='asc'?'desc':'asc'}" >編號</a>
            </th>
        <%}else{%>
            <th class="sortable" >
              <a href="${url}action=list&sort=id&order=asc" >編號</a>
            </th>
        <%}%>
        <th>操作</th>
      </tr>
      <%
        List<Employee> employeeList = (List<Employee>) request.getAttribute("employeeList");
        NumberFormat salaryFormat = new DecimalFormat("0.00");  // 薪水格式化器
        
        for(int i=0;employeeList!=null && i < employeeList.size();i++){
          Employee e = employeeList.get(i);
          out.println("<tr class='"+(i%2==0?"even":"odd")+"'>");
          out.println("  <td>"+e.getId()+"</td>");                           // id
          out.println("  <td>"+e.getName()+"</td>");                         // 姓名
          out.println("  <td>"+e.getSex()+"</td>");                          // 性別
          out.println("  <td>"+e.getAge()+"</td>");                          // 年齡
          out.println("  <td>"+e.getBirthday()+"</td>");                     // 生日
          out.println("  <td>"+salaryFormat.format(e.getSalary())+"</td>");  // 薪水
          out.println("  <td>"+e.getStartTime()+"</td>");                    // 上班時間         
          out.println("  <td>"+e.getEndTime()+"</td>");                      // 下班時間
          out.println("  <td>"+(e.isDisabled()?"已阻止":"正常")+"</td>");     // 狀態
          out.println("  <td>&nbsp;</td>");                                 
          out.println("</tr>");   //                            
        } // end for(int i=0;employeeList!=null && i < employeeList.size();i++){

      %>
    </table>
    
    <div style="padding-top:10px;font-size:12px" >${pagination}</div>
    
  </body>
  
</html>
