package com.helloweenvsfei.tags;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.DynamicAttributes;
import javax.servlet.jsp.tagext.TagSupport;

public class DynamicAttributeTag extends TagSupport implements DynamicAttributes {

	private static final long serialVersionUID = -1477571708507488373L;
	
	private Map <String,Double> map=new HashMap<String,Double>();
	
	public DynamicAttributeTag() {
		// TODO Auto-generated constructor stub
	}

	
	
	public int doEndTag() throws JspException{
	
	  JspWriter out=pageContext.getOut();
	  
	  double min=0,max=0;
	
	  for(Double d:map.values()){
		min=Math.min(d,min);
		max=Math.max(d,max);  
	  }
	  
	  System.out.println("max = "+max);
	  System.out.println("min = "+min);
	  
	  StringBuffer buffer=new StringBuffer();
	  
	  buffer.append("<table>");
	  
	  for(Entry<String,Double>entry:map.entrySet()){
		buffer.append("<tr>");
		buffer.append("<td>").append(entry.getKey()).append("</td>");
		
		String imgStr="<img src='vote.gif' height='10' ";
		       imgStr+="width='"+(entry.getValue()-min)/(max-min+1)*200+50+"' />";
		buffer.append("<td>").append(imgStr).append(entry.getValue()).append("</td>");
		buffer.append("</tr>");
	  }
	  buffer.append("</table>");
	
	  try{
		out.write(buffer.toString());
	  }catch(Exception e){ }
	  
      return super.doEndTag();
	}
	
	
	public void setDynamicAttribute(String uri,String key,Object value) throws JspException{
		map.put(key,Double.parseDouble((String)value));  // 放到 Map中
	}
	
	
}
