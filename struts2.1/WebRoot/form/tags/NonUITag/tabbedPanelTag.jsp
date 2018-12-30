<%@ page language="java" contentType="text/html;charset=UTF-8" %>

<%@ taglib uri="/struts-tags"       prefix="struts" %>
<%@ taglib uri="/struts-dojo-tags"  prefix="sx"     %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'tabbedPanelTag.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<sx:head />
  </head>
  
  <body>
    
    <sx:tabbedpanel id="test1" >
      <sx:div id="one" label="第一個 TabItem" theme="ajax" cssStyle="padding;10px;" >
        第1-1個 TabItem <br />
        第1-1個 TabItem <br />
      </sx:div>
      <sx:div id="two" label="第二個 TabItem" theme="ajax" cssStyle="padding:10px;" >
        第2-1個 TabItem <br />
        第2-1個 TabItem <br />
      </sx:div>
      <struts:url id="divTagNewsURL" action="divTagNews" />
      <sx:div id="three" label="新聞列表" theme="ajax" href="%{#divTagNewsURL}" />
    </sx:tabbedpanel>
    
        
        
    <br/>
    <hr/>
    
    <sx:tabbedpanel id="test2"  closeButton="tab" >
      <sx:div id="one2" label="第一個 TabItem" theme="ajax" cssStyle="padding;10px;" >
        第1-2個 TabItem <br />
        第1-2個 TabItem <br />
      </sx:div>
       <sx:div id="two2" label="第二個 TabItem" theme="ajax" cssStyle="padding:10px;" >
        第2-2個 TabItem <br />
        第2-2個 TabItem <br />
      </sx:div>
      <sx:div id="three2" label="新聞列表" theme="ajax" href="%{#divTagNewsURL}" />
    </sx:tabbedpanel> 
    
  </body>
  
</html>