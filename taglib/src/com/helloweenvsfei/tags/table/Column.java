package com.helloweenvsfei.tags.table;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class Column extends TagSupport {

	public Column() {
		// TODO Auto-generated constructor stub
	}
	
	private static final long serialVersionUID = 5119493903438602864L;
	  
	private String property;
    private String label;

	/**
	 * @return the property
	 */
	public String getProperty() {
		return property;
	}
	/**
	 * @param property the property to set
	 */
	public void setProperty(String property) {
		this.property = property;
	}
	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}
	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}

    
    public int doStartTag() throws JspException{
      if (!(this.getParent() instanceof Table)){
        throw new JspException("Column must be inside Table. ");
      }

      Map<String, String> column = new HashMap<String, String>();
      column.put("label", label);
      column.put("property", property);
      Table table = (Table) this.getParent();  
      table.getColumns().add(column);
      return SKIP_BODY;
    }

    
    public int doEndTag() throws JspException{
      return EVAL_PAGE;
    }
    

}
