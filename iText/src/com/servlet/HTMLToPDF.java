package com.servlet;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.html.simpleparser.StyleSheet;
import com.itextpdf.text.pdf.PdfWriter;

public class HTMLToPDF extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public HTMLToPDF() {
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
	  doPost(request,response);
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

	  String action = request.getParameter("action");
		
	  Document document = document = new Document(PageSize.A4,0,0,0,0); 
	  try{  
		String responseInfo ="";
		  
		String fileName = "D:\\"+action+".pdf";
		  
		PdfWriter.getInstance(document,new FileOutputStream(fileName));  
		  
		if(action.equals("1")){
		  responseInfo = sampleHTML();			
		}else if(action.equals("2")){
		  responseInfo = GetConverURLToHTML("");
		  responseInfo = responseInfo.replaceAll("src=\"images/","src=\"http://www.htravel.com.tw/hTravel/images/");
		}else if(action.equals("3")){
		  responseInfo = PostConverURLToHTML("");
		  responseInfo = responseInfo.replaceAll("src=\"/images/","src=\"http://www.eztravel.com.tw/images/");
		}else{}
		responseInfo = responseInfo.replaceAll("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\">","");
		 
		
		document.open();    // HTML 語法  
		  
		 
	    System.out.println("kevintest responseInfo = "+responseInfo);
		StringReader stringReader = new StringReader(responseInfo);    
		  
		System.out.println("kevintest - 1");
		
		     
		// 載入字型  
		FontFactory.register("C://Windows/Fonts/kaiu.ttf");    // 標楷體
		  
		System.out.println("kevintest - 2");
		
		// 設定 HTML 標籤樣式  
		StyleSheet st = new StyleSheet();  
		st.loadTagStyle("body", "face", "標楷體");          // 字型 
		st.loadTagStyle("body", "size", "10px");            // 字體大小  
		st.loadTagStyle("body", "encoding", "Identity-H");  // 顯示中文字    
		  
		  
		System.out.println("kevintest - 3");
		
		// 產生 HTML 轉換物件  
   		HTMLWorker worker = new HTMLWorker(document);    
		  
   		System.out.println("kevintest - 4");
   		  
		// 輸出 HTML 到 PDF  
		ArrayList p = (ArrayList) HTMLWorker.parseToList(stringReader,st);  
		  
		System.out.println("kevintest - 5");
		
		System.out.println("kevintest p size = "+p.size());
		  
		System.out.println("kevintest - 6");
		
		for( int k = 0; k < p.size(); k++ ){     
		  document.add((Element)p.get(k));    
		}
		document.close();      
	  }catch(Exception e){
		e.printStackTrace();  
	  }		
	}


	
	
	
	
	public String sampleHTML(){
	  StringBuffer simpleHtmlCode = new StringBuffer("<html><body>");   
	  simpleHtmlCode.append("您好, 歡迎光臨<br/>" );  
	  simpleHtmlCode.append("我是 <font color='#0000FF'>kevin</font><br/>" );  
	  simpleHtmlCode.append("祝大家新年快樂 !!<br/>" );  
	  simpleHtmlCode.append( "<br/>" );  
	  simpleHtmlCode.append( "<table border='1' cellspacing='0' cellpadding='0' width='100%'><tr><td height='100' valign='top'>歡迎光臨</td><td height='100' align='right'>Hello World</td></tr><tr><td colspan='2' height='300' bgColor='#FFFF00'>歡迎<font color='#0000FF'>光臨</font></td></tr></table>");  
	  simpleHtmlCode.append("</body></html>");     
		  
	  return simpleHtmlCode.toString();
	}
	
	
	

	
	

	public String PostConverURLToHTML(String url){
	  
	  StringReader sr = null;
	  HttpClient httpClient = null;
	  PostMethod postMethod = null;
	  String responseInfo = "";
	  try{
		httpClient = new HttpClient();
		postMethod = new PostMethod("http://www.eztravel.com.tw/ezec/pkgfrn/grp_begdate.jsp");
		
		NameValuePair [] postData = new NameValuePair[1];
		postData[0] = new NameValuePair("prod_no","FRN0000008658");
		postMethod.addParameters(postData);
		int statusCode = httpClient.executeMethod(postMethod);
		
		System.out.println("kevintest PostConverURLToHTML statusCode = "+statusCode);

		responseInfo = postMethod.getResponseBodyAsString();		
	  }catch(Exception e){
		e.printStackTrace();  
	  }finally{
		postMethod.releaseConnection();  
	  }
	  return responseInfo;
	}
	
	
	
	
	
	
	
	
	
	
	public String GetConverURLToHTML(String url){
	  
	  StringReader sr = null;
	  HttpClient httpClient = null;
	  GetMethod getMethod = null;
	  String responseInfo = "";
	  try{
		httpClient = new HttpClient();
		getMethod = new GetMethod("http://www.htravel.com.tw/hTravel/standard.html");
		int statusCode = httpClient.executeMethod(getMethod);

		System.out.println("kevintest GetConverURLToHTML statusCode = "+statusCode);
		
		responseInfo = getMethod.getResponseBodyAsString();
	  }catch(Exception e){
		e.printStackTrace();  
	  }finally{
		getMethod.releaseConnection();  
	  }
	  return responseInfo;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String [] args){
		
		
		 /** The resulting HTML file. */
	    String HTML = "d:\\1.html";
	    
	    // String HTML = "http://www.eztravel.com.tw";
	    
	    /** The resulting PDF file. */
	    String RESULT1 = "d:\\1.pdf";

	    
	    StringBuffer simpleHtmlCode = new StringBuffer("<html><body>");   
	    simpleHtmlCode.append( "你好, 歡迎光臨<br/>" );  
		simpleHtmlCode.append( "我是 <font color='#0000FF'>昭佑.天翔</font><br/>" );  
		simpleHtmlCode.append( "祝你 新年快樂 !!<br/>" );  
		simpleHtmlCode.append( "<br/>" );  
		simpleHtmlCode.append( "<table border='1' cellspacing='0' cellpadding='0' width='100%'><tr><td height='100' valign='top'>歡迎光臨</td><td height='100' align='right'>Hello World</td></tr><tr><td colspan='2' height='300' bgColor='#FFFF00'>歡迎<font color='#0000FF'>光臨</font></td></tr></table>");  
		simpleHtmlCode.append("</body></html>");     
		  
		StringReader stringReader = new StringReader(simpleHtmlCode.toString());    
		  

	   	    
	    try{
		  // step 1
          Document document = new Document();
        
          // step 2    
          PdfWriter.getInstance(document, new FileOutputStream(RESULT1));
        
          // step 3
          document.open();
        
          // step 4
          List<Element> objects= HTMLWorker.parseToList(stringReader, null);
          for(Element element : objects) {
            document.add(element);
          }
        
           // step 5
          document.close();
	    }catch(Exception e){
	      e.printStackTrace();
	    }
	    
	}
	
	

}
