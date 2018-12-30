<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>

<jsp:directive.page import="java.util.Locale" />

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'locales.jsp' starting page</title>
    <style type="text/css">
      body{
      	font-size: 14px; 
      }
      table {
      	border-collapse: collapse;
	      border: 1px solid #000000;
	      margin-top: 5px; 
      }
      th, td {
      	border: 1px solid #000000;
	      padding: 2px; 
	      text-align: center;
	      font-size: 12px; 
      }
	</style>
  </head>
  
  <body>
   <table>
     <tr>
       <th>Locale</th>
       <th>Country</th>
       <th>Display Country</th>
       <th>Language</th>
       <th>Variant</th>
     </tr>
     <%
       Locale [] availableLocales =Locale.getAvailableLocales();
       
       for(Locale locale:availableLocales){
         out.println("<tr>");
         out.println("<td>"+locale.getDisplayName()+"</td>");
         out.println("<td>"+locale.getCountry()+"</td>");
         out.println("<td>"+locale.getDisplayCountry()+"</td>");
         out.println("<td>"+locale.getLanguage()+"</td>");
         out.println("<td>"+locale.getDisplayLanguage()+"</td>");
          out.println("<td>"+locale.getVariant()+"</td>");
         out.println("</tr>");
       } // end for(Locale locale:availableLocales){
     %>  
   </table>
  </body>
</html>
