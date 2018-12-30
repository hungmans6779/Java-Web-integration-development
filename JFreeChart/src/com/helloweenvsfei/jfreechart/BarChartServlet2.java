package com.helloweenvsfei.jfreechart;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XYBarDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class BarChartServlet2 extends HttpServlet {

	private static final long serialVersionUID = 935480272440185396L;
	
	/**
	 * Constructor of the object.
	 */
	public BarChartServlet2() {
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
		this.doPost(request, response);
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

		
		response.setContentType("image/png"); // 設定傳回類型為圖片
	
		IntervalXYDataset dataset = createDataset(); // 獲得資料集對像
		
		// 建立圖形對像
		JFreeChart jfreechart = ChartFactory.createXYBarChart("08年圖書銷售量", null,false, "銷量", dataset, PlotOrientation.VERTICAL, true, false,false);
		jfreechart.setBackgroundPaint(Color.white); // 設定背景為白色
		
		XYPlot xyplot = (XYPlot) jfreechart.getPlot(); // 獲得圖表區域對像
		xyplot.setBackgroundPaint(Color.lightGray);    // 設定區域對像背景為灰色
		xyplot.setDomainGridlinePaint(Color.white);    // 設定區域對像網格線調為白色
		xyplot.setRangeGridlinePaint(Color.white);
		
		XYBarRenderer xybarrenderer = (XYBarRenderer) xyplot.getRenderer(); // 獲顯示圖形對像
		xybarrenderer.setDrawBarOutline(false); // 設定不顯示邊框線

		// 將圖表已資料流的方式傳回給客戶端
		ChartUtilities.writeChartAsPNG(response.getOutputStream(), jfreechart,500, 270);
		
		try{
		  ChartUtilities.saveChartAsPNG(new File("E:\\EclipseDeveloper\\MyEclipse Bling Edition 9\\王者歸來 Java Web 整合開發\\workspace\\JFreeChart\\generatorIMG\\bar2.png"),jfreechart,500,270);
		}catch(Exception e){
		  e.printStackTrace();  
	    }
		    
	}


	

	/**
	 * 傳回資料集
	 * 
	 * @return
	 */
	private static IntervalXYDataset createDataset() {
		// 建立基本資料
		XYSeries xyseries = new XYSeries("JAVA");
		XYSeries xyseries1 = new XYSeries("PHP");
		for (int i = 1; i <= 12; i++) {
		  // 增加資料
		  xyseries.add(i,DataUtils.getRandomData());
		  xyseries1.add(i,DataUtils.getRandomData());
		}
		
		XYSeriesCollection xyseriescollection = new XYSeriesCollection();
		xyseriescollection.addSeries(xyseries);
		xyseriescollection.addSeries(xyseries1);
		return new XYBarDataset(xyseriescollection, 0.90000000000000002D);
	}
	
	
	
	
}
