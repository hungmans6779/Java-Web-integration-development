<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>addDepartment.jsp page</title>
  </head>
  
  <body>
    <!-- 部門表單  -->
    <form action="/servlet/DepartmentServlet" method="post" >
      <input type="hidden" name="action" value="${action}" />
      <input type="hidden" name="id"     value="${id}"     />
      <fieldset>
        <legend>增加部門</legend>
        <table>
          <tr>
            <td>名稱：</td>
            <td><input type="text" name="name" value="${name}" /></td>  
          </tr>
         <tr>
           <td>經理：</td>
           <td>
             <div>
               <input type="text" name="key" id="key" style="width:200px"  /> <!-- 查詢框 -->
               <input type="button" name="btnQuery" class="button" value="查詢" />
             </div>
             <table>
               <tr>
                 <td>
                   <select name="lineManagerList" size="10" style="width:100px;" >
                     <option value="" >輸入姓名後查詢</option>
                   </select>
                 </td>
                 <td>
                   <input type="button" name="btnToRight" value="&gt;&gt;" ><br><br>
                   <input type="button" name="btnToLeft"  value="&lt;&lt;" class="button" >
                 </td>
                 <td>
                   <select name="lineManagerId" size="10" ></select>
                 </td>
               </tr>
             </table>
           </td> 
         </tr>
         <tr>
           <td>描述</td>
           <td><textarea name="description" >${description }</textarea></td> 
         </tr>
         <tr>
           <td>&nbsp;</td>
           <td><input type="submit" class="button" value="傳送" /></td>
         </tr>
        </table>        
      </fieldset>
    
    </form>
  </body>
  
</html>
