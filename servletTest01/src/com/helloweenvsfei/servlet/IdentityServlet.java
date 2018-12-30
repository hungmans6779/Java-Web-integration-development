package com.helloweenvsfei.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;


public class IdentityServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public IdentityServlet() {
	  super();
	}


	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}
	
	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	
	public void init(ServletConfig config) throws ServletException{
      super.init(config);
      this.log("init");
	}
	
	
	
	public static final char[] CHARS={'1','2','3','4','5','6','7','8','9','0',
		                              'A','B','C','D','E','F','G','H','I','J',
		                              'K','L','M','N','O','P','Q','R','S','T',
		                              'U','V','W','X','Y','Z'};
	
	
	public static Random random=new Random();
	
	
	// 取得六位數亂數
	public static String getRandomString(){
	  StringBuffer buffer=new StringBuffer();
	  for(int i=1;i<=6;i++){
		buffer.append(CHARS[random.nextInt(CHARS.length)]);  
	  }
	  return buffer.toString();
	}
	
	// 獲得隨機的顏色
	public static Color getRandomColor(){
	  return new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255));	
	}
	
	// 傳回某顏色的反色
	public static Color getReverseColor(Color c){
	  return new Color(255-c.getRed(),255-c.getGreen(),255-c.getBlue());
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


//		response.setContentType("text/html");
//		PrintWriter out=response.getWriter();
//		
//		String randomString=getRandomString();
//		out.print("randomString = "+randomString);
	

		
		response.setContentType("image/jpeg");
		
		String randomString=getRandomString();
		request.getSession(true).setAttribute("randomString",randomString);
		
		int width=100;
		int height=30;
	
		Color color=getRandomColor();
		Color reverseColor=getReverseColor(color);
		
		BufferedImage bi=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		
		Graphics2D g=bi.createGraphics();
		g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,16));
		g.setColor(color);
		g.fillRect(0,0,width,height);
		g.setColor(reverseColor);
		g.drawString(randomString,18,20);
		
	    for(int i=0,n=random.nextInt(width);i<n;i++){
	      g.drawRect(random.nextInt(width),random.nextInt(height),1,1);	
	    }
	    
	    // 轉成JPEG格式
		ServletOutputStream out=response.getOutputStream();
		JPEGImageEncoder encoder=JPEGCodec.createJPEGEncoder(out);
		encoder.encode(bi);
		out.flush();
		

	}

	
	public static void main(String [] args){
	  System.out.println("getRandomString() = "+getRandomString());
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
      doGet(request,response);
	}


}
