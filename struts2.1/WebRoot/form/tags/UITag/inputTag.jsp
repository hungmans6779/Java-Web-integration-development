<%@ page language="java" contentType="text/html;charset=UTF-8" %>

<%@ taglib uri="/struts-tags"        prefix="struts"  %>
<%@ taglib uri="/struts-dojo-tags"   prefix="sx"      %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>My JSP 'inputTag.jsp' starting page</title>
    <sx:head /> 
  </head>
  
  <body> 
  
  
    <!-- 
       textfield、textarea、file、checkbox、radio 標籤
       這些標籤是最基本的表單標籤，會產生 HTML 裡的 <input> 標籤。同 form 標籤一樣，
       這些標籤也會根據目前主題產生版面配置程式碼，如 <tr>、<td>等，例如：
    -->
    <struts:form action="/tags/inputLoginTag.action" >
    
    
      <%-- textField 欄位 --%>
      <struts:textfield  name="textfield" label="文字方塊"  required="true" tooltip="這是一個文字方塊" />
    
    
      <%-- password 欄位 --%>  
      <struts:password name="password" label="密碼域" tooltip="這是密碼域" />
      
      
      <%-- textarea 欄位 --%>  
      <struts:textarea name="textarea" label="文字域" tooltip="這是文字域" /> 
      
      
      <%-- file 欄位 --%>  
      <struts:file name="file" label="檔案域" tooltip="這是檔案域" />
    
      
      <%-- radio 欄位 --%>  
      <struts:radio name="sex" label="單選框" tooltip="這是單選框"  list="#{'male':'男','felmale':'女'}"  />
      
      
      <%-- checkbox 欄位 --%>  
      <struts:checkbox name="hobby"  label="是否精通 Struts2" value="true" />
      
      
      <%-- submit 按鈕 --%>      
      <struts:submit value="提 交"  method="logout" align="center" />    
       
    </struts:form>
  
  
  </body>
  
</html>
