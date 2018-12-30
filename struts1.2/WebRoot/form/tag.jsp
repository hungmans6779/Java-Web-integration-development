<%@ page language="java" pageEncoding="UTF-8" %>

<%@ taglib uri="http://jakarta.apache.org/struts/tags-html"    prefix="html"   %>    
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean"    prefix="bean"   %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic"   prefix="logic"  %>    
<%@ taglib uri="http://jakarta.apache.org/struts/tags-nested"  prefix="nested" %>    
<%@ taglib uri="http://jakarta.apache.org/struts/tags-tiles"   prefix="tiles"  %>    
    
<%--
            參考頁面：http://struts.apache.org/1.2.9/userGuide/struts-html.html
--%>
    
    
<html> 

  <head>
	<title>JSP for TagForm form</title>
	  <style type="text/css">
		body{
		  font-size: 12px; 
	    }
	  </style>
  </head>
  <body>
    
    <html:form action="/tag" >
      
              多選框：
             <html:checkbox property="checkbox" value="體育" >體育</html:checkbox> 
             <html:checkbox property="checkbox" value="音樂" >音樂</html:checkbox>
             <html:checkbox property="checkbox" value="影視" >影視</html:checkbox><br><br> 
     <%--     
              檔案域：<html:file property="file" /><br><br>
     --%>   
               
         隱藏欄位：<html:hidden property="hidden" /><br><br>
              多選框：
             <html:multibox property="multibox" value="選項一" />選項一
             <html:multibox property="multibox" value="選項二" />選項二<br><br>
              密碼域：<html:password property="password" /><br><br>
              單選框：
             <html:radio property="radio" value="男" />男 
             <html:radio property="radio" value="女" />女<br><br>
         下拉清單：
             <html:select property="select" >
               <html:option value="選項一" >選項一</html:option>
               <html:option value="選項二" >選項二</html:option>
               <html:option value="選項三" >選項三</html:option>
               <html:option value="選項四" >選項四</html:option>
               <html:option value="選項五" >選項五</html:option>
               <html:option value="選項六" >選項六</html:option>   
             </html:select><br><br>      
              輸入框：<html:text property="text" /><br><br>
             文字域：<html:textarea property="textarea" /><br><br>
        圖片按鈕：<html:image src="images/submit.gif" /><br><br>
        普通按鈕：<html:button property="button" value="普通按鈕" /><br><br>
        傳送按鈕：<html:submit value="傳送按鈕" /><br><br>
        
      <logic:present name="personList" >
                使用List 內容顯示下拉清單：
              <html:select property="select" >
                <html:options collection="personList" property="id" labelProperty="name" />
              </html:select>
      </logic:present>                                                                  
    
    </html:form>
    
  </body>

</html>