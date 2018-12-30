<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core"       prefix="c"   %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"        prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql"        prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml"        prefix="x"   %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>JSTL x_transform.jsp</title>
    <style>
      body, td, div {
      	font-size: 12px; 
      }
      .source {
      	white-space: pre;
      	width: 100%; 
	      height: 200px; 
	      overflow: scroll;
	      border: 1px solid #999999; 
	      padding: 2px; 
	      margin-bottom: 20px; 
      }
      table {
	      border-collapse: collapse;
	      border: 1px solid #999999; 
      }
      th {
	      border: 1px solid #999999; 
	      padding: 2px; 
	      text-align: center;
	      padding-left: 10px; 
	      padding-right: 10px; 
	      background: #CCCCCC;
      }
      td {
	      border: 1px solid #999999; 
	      padding: 2px; 
	      text-align: center;
	      padding-left: 10px; 
	      padding-right: 10px; 
      }
    </style>
  </head>
  
  <body>
  
    <c:set var="data" >
      <?xml version="1.0" encoding="UTF-8" ?>
      <students>
	      <student>
		      <id>1</id>
		      <name>張三</name>
		      <email>zhangsan@host.com</email>
		      <description>Software Engine</description>
	      </student>
	      <student>
		      <id>2</id>
		      <name>李四</name>
		      <email>lisi@somehost.com</email>
	      	<description>Sales</description>
	      </student>
	      <student>
		      <id>3</id>
		      <name>王五</name>
		      <email>wangwu@someweb.com</email>
		      <description>Manager</description>
	      </student>
      </students>
    </c:set>
     
     
     
    <c:set var="template" >
	  <?xml version="1.0" encoding="UTF-8"?>
	  <xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
	    <xsl:template match="students" >
	    	<table>
	    		<tr>
	    			<th>編號</th>
	    			<th>姓名</th>
	    			<th>電子郵件</th>
	    			<th>描述</th>
	    		</tr>
	    		<xsl:for-each select="student">
		    		<tr>
		    			<td><xsl:value-of select="id" /></td>
		    			<td><xsl:value-of select="name" /></td>
		    			<td><xsl:value-of select="email" /></td>
		    			<td><xsl:value-of select="description" /></td>
		    		</tr>
	    		</xsl:for-each>
	    	</table>
	    </xsl:template>
	  </xsl:stylesheet>    
    </c:set>     
  
     
    <div class="source">
      <c:out value="${data}" />
    </div>
     
    <x:transform doc="${ data }" xslt="${ template }" ></x:transform>
     
  </body>
  
</html>
