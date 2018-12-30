package com.helloweenvsfei.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class AddTag  extends TagSupport{

	public AddTag() {
		// TODO Auto-generated constructor stub
	}
	
    private int num1;
    private int num2;
	/**
	 * @return the num1
	 */
	public int getNum1() {
		return num1;
	}
	/**
	 * @param num1 the num1 to set
	 */
	public void setNum1(int num1) {
		this.num1 = num1;
	}
	/**
	 * @return the num2
	 */
	public int getNum2() {
		return num2;
	}
	/**
	 * @param num2 the num2 to set
	 */
	public void setNum2(int num2) {
		this.num2 = num2;
	}
    

    
    public int doEndTag() throws JspException{
    	
    	try{
    		this.pageContext.getOut().println(num1+" + "+num2+" = "+(num1+num2));
    	 }catch(Exception e){
    	 }
    	
    	
    	return EVAL_PAGE;
    }
}
