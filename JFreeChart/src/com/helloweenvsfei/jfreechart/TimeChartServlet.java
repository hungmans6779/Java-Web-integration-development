package com.helloweenvsfei.jfreechart;

import java.awt.BasicStroke;
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
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.general.SeriesException;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;

public class TimeChartServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public TimeChartServlet() {
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


		response.setContentType("image/png"); // 設定傳回類型為圖片
		
		XYDataset dataset = createDataset();  // 獲得資料集對像
		
		// 建立圖形對像
		JFreeChart jfreechart = ChartFactory.createTimeSeriesChart("時序圖","POLO歷史價格", "價格", dataset, false, false, false);
		XYPlot xyplot = (XYPlot) jfreechart.getPlot();
		
		XYLineAndShapeRenderer xylineandshaperenderer = new XYLineAndShapeRenderer(); // 獲得折線顯示對像
		xylineandshaperenderer.setBaseShapesVisible(false); // 設定不顯示折線
		xylineandshaperenderer.setSeriesStroke(0, new BasicStroke(0.5F, 1, 1, 5F, new float[] { 5F, 10F }, 0.0F)); // 設定折線的粗細
		xyplot.setRenderer(xylineandshaperenderer);
		
		// 將圖表已資料流的方式傳回給客戶端
		ChartUtilities.writeChartAsPNG(response.getOutputStream(), jfreechart,500, 270);

		try{
		  ChartUtilities.saveChartAsPNG(new File("E:\\EclipseDeveloper\\MyEclipse Bling Edition 9\\王者歸來 Java Web 整合開發\\workspace\\JFreeChart\\generatorIMG\\time.png"),jfreechart,500,270);
		}catch(Exception e){
		  e.printStackTrace();  
	    }

	}


	
	/**
	 * 傳回資料集
	 * 
	 * @return
	 */
	private static XYDataset createDataset() {
		TimeSeries timeseries = new TimeSeries("JAVA"); //建立時序對像
		Day day = new Day(1, 1, 1990); //初始化日期為1990年1月1日
		double d = 100000D;
		
		// 增加1000條資料
		for(int i = 0; i < 4000; i++)
		  try{
		    // 隨機取出100附近數
		    d = (d + Math.random()) - 0.5D;
			// 增加到時序對像
			timeseries.add(day, new Double(d));
			// 之後的一天
			day = (Day) day.next();
		  } catch (SeriesException seriesexception){}
		// 傳回XYDataset資料集
		return new TimeSeriesCollection(timeseries);
	}
	
}
