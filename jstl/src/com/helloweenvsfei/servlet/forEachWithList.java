package com.helloweenvsfei.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.helloweenvsfei.jstl.bean.Person;

public class forEachWithList extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public forEachWithList() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		  List<Person>personList=new ArrayList<Person>();
		    
		  Person person=new Person();
		  person.setId(1);
		  person.setName("張三");
		  person.setAge(20);
		  person.setSex("男");
		  person.setAddress("北京市海淀区上地软件园");
		  person.setBirthday("2008-08-08");
		  person.setMobile("13820080808");
		  person.setTelephone("69653234");
		  person.setCity("北京");
		  personList.add(person);
		      
		      
		  Person person2 = new Person();
		  person2.setId(2);
		  person2.setName("李四");
		  person2.setAge(20);
		  person2.setSex("男");
		  person2.setAddress("北京市东皇城根锡拉胡同");
		  person2.setBirthday("2008-01-01");
		  person2.setMobile("13820080808");
		  person2.setTelephone("20054879");
		  person2.setCity("北京");
		  personList.add(person2);

		   
		  Person person3 = new Person();
		  person3.setId(3);
		  person3.setName("大刀王五");
		  person3.setAge(10);
		  person3.setSex("男");
		  person3.setAddress("北京市东皇城根锡拉胡同");
		  person3.setBirthday("2008-01-01");
		  person3.setMobile("13820080808");
		  person3.setTelephone("20054879");
		  person3.setCity("北京");
		  personList.add(person3);   
		    
		  Person person4 = new Person();
		  person4.setId(4);
		  person4.setName("小六");
		  person4.setAge(18);
		  person4.setSex("男");
		  person4.setAddress("北京市东皇城根锡拉胡同");
		  person4.setBirthday("2008-01-01");
		  person4.setMobile("13820080808");
		  person4.setTelephone("20054879");
		  person4.setCity("北京");
		  personList.add(person4);     
		
		  
		  request.setAttribute("personList",personList);
		  
		  request.getRequestDispatcher("/forEachWithListServlet.jsp").forward(request,response);
		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		doGet(request,response);
	}

	
	
	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
