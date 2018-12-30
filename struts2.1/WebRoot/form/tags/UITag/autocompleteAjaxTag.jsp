<%@ page language="java" contentType="text/html;charset=UTF-8" %>

<%@ taglib uri="/struts-tags"         prefix="struts"  %>
<%@ taglib uri="/struts-dojo-tags"    prefix="sx"      %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'autocompleteAjaxTag.jsp' starting page</title>
    <sx:head />
  </head>
  
  <body>
  
    <!-- 使用動態資料的autocomplete 標籤
         autocomplete 標籤還支援 Ajax 方式獲得動態資料，根據填寫的內容動態地顯示輸入提示。
         如果下拉清單的資料很龐大，只能使用動態資料。
         
         href 屬性指定獲得資料的URL。該 URL 會根據目前輸入的內容動態地篩選內容，
         傳回下拉清單資料。indicator 屬性可以為一個圖片或者一段文字，autocomplete 獲得資料時會顯示 indicator。
    -->  
  </body>
 
  <!-- 獲得資料的URL  --> 
  <struts:url id="dataUrl" value="autocompleteAjaxDate.jsp" />
  
  
  <!-- 動態取得 autocomplete 下拉式選項  -->
  <sx:autocompleter name="country"          href="%{dataUrl}"     label="請選擇國家"
                    loadOnTextChange="true" loadMinimumCount="0"  autoComplete="false" 
                    showDownArrow="true"    indicator="indicator" />   
  <image id="indicator"  src="/struts2.1/images/loading.gif" />
    
</html>
