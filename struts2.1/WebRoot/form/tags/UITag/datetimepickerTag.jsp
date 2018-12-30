<%@ page language="java" contentType="text/html;charset=UTF-8" %>

<%@ taglib uri="/struts-tags"       prefix="struts" %>
<%@ taglib uri="/struts-dojo-tags"  prefix="sx" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

  <head>
    <title>My JSP 'datetimepickerTag.jsp' starting page</title>
    <sx:head />
  </head>
  
  <body>
    
    <%--
      datetimepicker 日期選擇器
      datetimepicker 標籤是專門輸入日期時間的輸入框，它附帶一個日曆，可以指定日曆格式。
    --%>
    <struts:form action="/tags/datetimepickerSubmit.action" >
      <sx:datetimepicker name="date" displayFormat="yyyy-MM-dd"  label="請選擇日期" />
      <struts:submit value="提 交" align="center" />  
    </struts:form>
  </body>
  
</html>
