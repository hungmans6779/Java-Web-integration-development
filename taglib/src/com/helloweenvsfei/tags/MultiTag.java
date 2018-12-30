package com.helloweenvsfei.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MultiTag extends SimpleTagSupport {

	public MultiTag() {
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
	
	
	
	public void doTag() throws JspException,IOException{
	    this.getJspContext().getOut().write(num1+" * "+num2+" = "+(num1*num2));	
	}

	
	
}
