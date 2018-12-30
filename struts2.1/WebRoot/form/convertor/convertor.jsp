<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>

<%@ taglib uri="/struts-tags"       prefix="struts" %>
<%@ taglib uri="/struts-dojo-tags"  prefix="sx" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>convertor.jsp</title>
    <sx:head />
    <style type="text/css" >
      <!--
        body,td{
          font-size:12px;
        }
      //-->
    </style>
  </head>
  
  <body>
    
    <struts:form action="convertor" >
      <struts:label label="轉換器" />
      <struts:textfield name="sqlDate"  label="SQL Date(ex.2012-10-03):"    />
      <struts:textfield name="sqlTime"  label="SQL Time(ex.15:03:00):"      />
      <struts:textfield name="utilDate" label="Util Date(ex.2012-10-01):"   />
      <struts:submit value="提交"   method="convert"  />
    </struts:form>
    
  </body>
  
</html>