<?xml version="1.0" encoding="UTF-8"?>
	<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
	    <xsl:template match="students">
	    	<table>
	    		<tr>
	    			<th>编号</th>
	    			<th>姓名</th>
	    			<th>电子邮件</th>
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