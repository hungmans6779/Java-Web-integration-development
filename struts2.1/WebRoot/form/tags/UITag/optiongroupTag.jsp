<%@ page language="java" contentType="text/html;charset=UTF-8" %>

<%@ taglib uri="/struts-tags"        prefix="struts"  %>
<%@ taglib uri="/struts-dojo-tags"   prefix="sx"      %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'optiongroupTag.jsp' starting page</title>
    <sx:head />
  </head>
  
  <body>
  
    <%--
       <OptGroup> 是個標準的HTML 標籤，用於給 <select> 的選項分組。
        optgroup 標籤可以產生<OptGroup>標籤。
    --%>
    <struts:form action="/tags/optiongroupSubmmit.action" >
      
      <struts:select name="city" list="%{cityList}" label="請選擇城市" >
        <struts:iterator value="%{provinceMap}" >
          <struts:optgroup label="%{key}" list="%{value}" /> <!-- list 屬性只接受Map   -->
        </struts:iterator>
      </struts:select>
      
      <struts:submit value="提 交" align="center" />
    </struts:form>
    
  </body>
  
</html>