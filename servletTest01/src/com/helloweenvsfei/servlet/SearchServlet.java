package com.helloweenvsfei.servlet;

import java.io.IOException;

import java.io.PrintWriter;
import java.math.BigInteger;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yahoo.search.ImageSearchRequest;
import com.yahoo.search.ImageSearchResult;
import com.yahoo.search.ImageSearchResults;
import com.yahoo.search.NewsSearchRequest;
import com.yahoo.search.NewsSearchResult;
import com.yahoo.search.NewsSearchResults;
import com.yahoo.search.SearchClient;
import com.yahoo.search.VideoSearchRequest;
import com.yahoo.search.VideoSearchResult;
import com.yahoo.search.VideoSearchResults;
import com.yahoo.search.WebSearchRequest;
import com.yahoo.search.WebSearchResult;
import com.yahoo.search.WebSearchResults;




public class SearchServlet extends HttpServlet {

	
	/**
	 * Constructor of the object.
	 */
	public SearchServlet() {
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


		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		response.setContentType("text/html");
		
		
		String word=request.getParameter("word");
		String type=request.getParameter("type");
		String alloweAdult=request.getParameter("allowedAdult");
		
		boolean adultOk="true".equals(alloweAdult);

		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>"+word+" 搜索結果</TITLE></HEAD>");
		out.println("  <style>");
		out.println("	  body, div {font-size:12px; padding:2px; margin:0px; }");
		out.println("	  .imgDiv{float:left; width: 172px; height:250px;  margin:2px; padding:2px; border:1px pink solid; overflow:hidden; }");
		out.println("  </style>");
		out.println("  <BODY>");

		out.println("   <div style='float:left;height:40px;' >    ");
		out.println("     <img src='http://us.i1.yimg.com/us.yimg.com/i/ww/beta/y3.gif' /> ");
		out.println("   </div>");
		out.println("   <form action='"+request.getRequestURI()+"' METHOD='get' >");
		out.println("     <div style='height:40px;' >   ");
		out.println("       <input type='radio' name='type' value='web' "+(type.equals("web")?"checked":"")+">網頁");
		out.println("       <input type='radio' name='type' value='news' "+(type.equals("news")?"checked":"")+">新聞");
		out.println("       <input type='radio' name='type' value='image' "+(type.equals("image")?"checked":"")+">圖片");
		out.println("       <input type='radio' name='type' value='video' "+(type.equals("video")?"checked":"")+">視頻");
		out.println("       ");
		out.println("     </div>");
		out.println("   </form>");
		
		
		
		SearchClient client=new SearchClient("javasdktest");
		
		try{
	        if("image".equals(type)){
	        	ImageSearchRequest searchRequest = new ImageSearchRequest(URLEncoder.encode(word, "UTF-8"));
	        	// 是否顯示成人內容
	        	searchRequest.setAdultOk(adultOk);
	        	// 查詢記錄數
	        	searchRequest.setResults(20);
	        	// 從第 0 條記錄開始顯示
	        	searchRequest.setStart(BigInteger.valueOf(0));
	        	
	        	double startTime = System.currentTimeMillis();
	        	ImageSearchResults results = client.imageSearch(searchRequest);
	        	double endTime = System.currentTimeMillis();

	    		out.println("<div align=right style='width:100%; background: #FFDDDD; height:25px; padding:2px; border-top:1px solid #FF9999; margin-bottom:5px; '>");
	    		out.println("	總共 " + results.getTotalResultsAvailable() + " 條資料，總用時 " + ( endTime - startTime )/1000 + " 秒。");
	    		out.println("</div>");
	        	
	        	for(ImageSearchResult result : results.listResults()){
	        		out.println("<div class='imgDiv'>");
	        		out.println("	<div align='center'><a href=\"" + result.getClickUrl() + "\" target=_blank><img width=160 height=120 src=\"" + result.getThumbnail().getUrl() + "\" border='0'></a></div>");
	        		out.println("	<div align='center'><a href=\"" + result.getRefererUrl() + "\" target=_blank>" + result.getTitle() + "</a></div>");
	        		out.println("	<div align='center'>" + result.getWidth() + "x" + result.getHeight() + " " + result.getFileFormat() + "</div>");
	        		out.println("	<div>" + (result.getSummary()==null ? "" : result.getSummary()) + "</div>");
	        		out.println("</div>");
	        	}
	        }
	        else if("web".equals(type)){
	        	WebSearchRequest searchRequest = new WebSearchRequest(URLEncoder.encode(word, "UTF-8"));
	        	// 是否顯示成人內容
	        	searchRequest.setAdultOk(adultOk);
	        	// 查詢記錄數
	        	searchRequest.setResults(20);
	        	// 從第 0 條記錄開始顯示
	        	searchRequest.setStart(BigInteger.valueOf(0));
	        	
	        	double startTime = System.currentTimeMillis();
	        	WebSearchResults results = client.webSearch(searchRequest);
	        	double endTime = System.currentTimeMillis();

	    		out.println("<div align=right style='width:100%; background: #FFDDDD; height:25px; padding:2px; border-top:1px solid #FF9999; margin-bottom:5px; '>");
	    		out.println("	總共 " + results.getTotalResultsAvailable() + " 條資料，總用時 " + ( endTime - startTime )/1000 + " 秒。");
	    		out.println("</div>");
	        	for(WebSearchResult result : results.listResults()){
	        		out.println("<div style='margin:8px; width:500px; '>");
	        		out.println("	<div><a href=\"" + result.getClickUrl() + "\" target=_blank><b>" + result.getTitle() + "</b></a> 檔案格式：" + result.getMimeType() + "</div>");
	        		out.println("	<div>網址：<a href=\"" + result.getUrl() + "\" target=_blank>" + result.getUrl() + "</a></div>");
	        		out.println("	<div>" + result.getSummary() + (result.getCache()==null ? "" : " [<a href=\"" + result.getCache().getUrl() + "\" target=_blank>網頁快照</a>]") +"</div>");
	        		
	        		out.println("</div>");
	        	}
	        }
	        else if("news".equals(type)){

	        	NewsSearchRequest searchRequest = new NewsSearchRequest(URLEncoder.encode(word, "UTF-8"));
	        	// 是否顯示成人內容
//	        	searchRequest.setAdultOk(adultOk);
	        	// 查詢記錄數
	        	searchRequest.setResults(20);
	        	// 從第 0 條記錄開始顯示
	        	searchRequest.setStart(BigInteger.valueOf(0));
	        	
	        	double startTime = System.currentTimeMillis();
	        	NewsSearchResults results = client.newsSearch(searchRequest);
	        	double endTime = System.currentTimeMillis();

	    		out.println("<div align=right style='width:100%; background: #FFDDDD; height:25px; padding:2px; border-top:1px solid #FF9999; margin-bottom:5px; '>");
	    		out.println("	總共 " + results.getTotalResultsAvailable() + " 條資料，總用時 " + ( endTime - startTime )/1000 + " 秒。");
	    		out.println("</div>");
	        	for(NewsSearchResult result : results.listResults()){
	        		out.println("<div style='margin:8px; width:500px; '>");
	        		out.println("	<div><a href=\"" + result.getClickUrl() + "\" target=_blank><b>" + result.getTitle() + "</b></a></div>");
	        		out.println("	<div>網址：<a href=\"" + result.getUrl() + "\" target=_blank>" + result.getUrl() + "</a></div>");
	        		out.println("	<div>" + result.getSummary() + "</div>");
	        		out.println("</div>");
	        	}
	        }
	        else if("video".equals(type)){
	        	VideoSearchRequest searchRequest = new VideoSearchRequest(URLEncoder.encode(word, "UTF-8"));
	        	// 是否顯示成人內容
	        	searchRequest.setAdultOk(adultOk);
	        	// 查詢記錄數
	        	searchRequest.setResults(20);
	        	// 從第 0 條記錄開始顯示
	        	searchRequest.setStart(BigInteger.valueOf(0));
	        	
	        	double startTime = System.currentTimeMillis();
	        	VideoSearchResults results = client.videoSearch(searchRequest);
	        	double endTime = System.currentTimeMillis();

	    		out.println("<div align=right style='width:100%; background: #FFDDDD; height:25px; padding:2px; border-top:1px solid #FF9999; margin-bottom:5px; '>");
	    		out.println("	總共 " + results.getTotalResultsAvailable() + " 條資料，總用時 " + ( endTime - startTime )/1000 + " 秒。");
	    		out.println("</div>");
	        	
	        	for(VideoSearchResult result : results.listResults()){
	        		out.println("<div class='imgDiv'>");
	        		out.println("	<div align='center'><a href=\"" + result.getClickUrl() + "\" target=_blank><img width=160 height=120 src=\"" + result.getThumbnail().getUrl() + "\" border='0'></a></div>");
	        		out.println("	<div align='center'><a href=\"" + result.getRefererUrl() + "\" target=_blank>" + result.getTitle() + "</a></div>");
	        		out.println("	<div align='center'>" + result.getWidth() + "x" + result.getHeight() + " " + result.getFileFormat() + "</div>");
	        		out.println("	<div>" + (result.getSummary()==null ? "" : result.getSummary()) + "</div>");
	        		out.println("</div>");
	        	}
	        }
		}catch(Exception e){
		  e.printStackTrace();
		}
		
		
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
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
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
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
