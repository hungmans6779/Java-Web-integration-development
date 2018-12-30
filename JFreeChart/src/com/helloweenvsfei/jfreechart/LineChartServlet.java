package com.helloweenvsfei.jfreechart;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.HorizontalAlignment;
import org.jfree.ui.RectangleEdge;

public class LineChartServlet extends HttpServlet {

	private static final long serialVersionUID = 1585397081043433662L;
	
	
	/**
	 * Constructor of the object.
	 */
	public LineChartServlet() {
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

		
		// 設定傳回類型為圖片
		response.setContentType("image/png");

		CategoryDataset dataset = createDataset(); // 獲得資料集對像
		
		// 建立圖形對像
		JFreeChart jfreechart = ChartFactory.createLineChart("08年圖書銷售量",null, "銷售量", dataset, PlotOrientation.VERTICAL, false, true,false);
		jfreechart.addSubtitle(new TextTitle("按月份")); // 設定圖表的子標題
	  
		TextTitle texttitle = new TextTitle("日期: " + new Date());   // 建立一個標題
		texttitle.setFont(new Font("黑體", 0, 10));                   // 設定標題字體
		texttitle.setPosition(RectangleEdge.BOTTOM);                  // 設定標題向下對齊
		texttitle.setHorizontalAlignment(HorizontalAlignment.RIGHT);  // 設定標題向右對齊
		
		jfreechart.addSubtitle(texttitle);                            // 增加圖表的子標題
		jfreechart.setBackgroundPaint(Color.white);                   // 設定圖表的背景色為白色
		
		
		CategoryPlot categoryplot = (CategoryPlot) jfreechart.getPlot(); // 獲得圖表區域對像
		categoryplot.setBackgroundPaint(Color.lightGray);
		categoryplot.setRangeGridlinesVisible(false);
		
		
		// 獲顯示線條對像
		LineAndShapeRenderer lineandshaperenderer = (LineAndShapeRenderer) categoryplot.getRenderer();
		lineandshaperenderer.setBaseShapesVisible(true);
		lineandshaperenderer.setDrawOutlines(true);
		lineandshaperenderer.setUseFillPaint(true);
		lineandshaperenderer.setBaseFillPaint(Color.white);
		lineandshaperenderer.setSeriesStroke(0, new BasicStroke(3F)); // 設定折線加粗
		lineandshaperenderer.setSeriesOutlineStroke(0, new BasicStroke(2.0F));
		lineandshaperenderer.setSeriesShape(0,new java.awt.geom.Ellipse2D.Double(-5D, -5D, 10D, 10D)); // 設定折線拐點
		
		
		// 將圖表已資料流的方式傳回給客戶端
		ChartUtilities.writeChartAsPNG(response.getOutputStream(), jfreechart,500, 270);

		try{
		  ChartUtilities.saveChartAsPNG(new File("E:\\EclipseDeveloper\\MyEclipse Bling Edition 9\\王者歸來 Java Web 整合開發\\workspace\\JFreeChart\\generatorIMG\\line.png"),jfreechart,500,270);
		}catch(Exception e){
		  e.printStackTrace();  
	    }
		    		
		
	}


	
	
	
	/**
	 * 傳回資料集
	 * 
	 * @return
	 */
	private static CategoryDataset createDataset() {
		DefaultCategoryDataset defaultdataset = new DefaultCategoryDataset();
		for (int i = 1; i <= 12; i++) {
			defaultdataset.addValue(DataUtils.getRandomData(), "JAVA", i + "月");
			defaultdataset.addValue(DataUtils.getRandomData(), "PHP", i + "月");
		}
		return defaultdataset;
	}

}
