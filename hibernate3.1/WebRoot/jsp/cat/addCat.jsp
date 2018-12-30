<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="com.helloweenvsfei.hibernate.bean.Cat" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
    <title>addCat.jsp</title>
    <style type="text/css">
      body,div,td,th{
	    font-size: 12px;
      }
      a{
	    color: blue;
      }
      a:hover {
	    color: red; 
      }
    </style>
  </head>
  
  <body>
    ${param.action=='initAdd'?"增加 Cat 資料":"修改 Cat 資料"} <span style='margin-left:2px' ></span> [ <a href="catServlet?action=initAdd" >添加 Cat </a> ][ <a href="catServlet?action=list" >Cat 列表 </a> ]
    <form action="catServlet" method="post" >
      <input type="hidden" name="id"      value="${cat.id}"                                />
      <input type="hidden" name="action"  value="${param.action=='initAdd'?'add':'save'}"  />
      <table>
        <tr>
          <td>Name:</td>
          <td><input type="text" name="name" value="${cat.name}" /></td>
        </tr>
        <tr>
          <td>Mother:</td>
          <td>
            <select name="motherId" >
              <option value="0" >--- 請選擇 ---</option>
              <%
                 @SuppressWarnings("unchecked")
                 List<Cat> catList =(List<Cat>) request.getAttribute("catList");
                 for(Cat cat:catList){
                   out.write("<option value="+cat.getId()+" >");
                   String name = cat.getName();
                   Cat mother = cat.getMother();
                   while(mother!=null){
                     name=mother.getName()+" / "+name;
                     mother = mother.getMother();
                   } // end while(mother!=null){
                   out.write(""+name+"");
                   out.write("</option>");
                 } // end for(Cat cat:catList){
              %>     
            </select>
            <script type="text/javascript" >document.getElementsByName('motherId')[0].value='${0+cat.mother.id}';</script>
          </td>
        </tr>
        <tr>
          <td>Description:</td>
          <td><textarea name="description" >${cat.description }</textarea></td>
        </tr>
        <tr>
          <td></td>
          <td><input type="submit"  value="${param.action=='initAdd'?'提交':'保存'}" /></td>
        </tr>
      </table>
      
    </form>
     
  </body>
  
</html>
