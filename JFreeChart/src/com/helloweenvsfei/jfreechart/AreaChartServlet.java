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
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RectangleInsets;

public class AreaChartServlet extends HttpServlet {

	private static final long serialVersionUID = 5852523271721922574L;
	
	/**
	 * Constructor of the object.
	 */
	public AreaChartServlet() {
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
		
		CategoryDataset dataset = createDataset(); // 獲得資料集對像
		
		// 建立圖形對像
		JFreeChart jfreechart = ChartFactory.createAreaChart("08年圖書銷售量排名","按季度", "銷量", dataset, PlotOrientation.VERTICAL, true, true,false);
		
		
		CategoryPlot categoryplot = (CategoryPlot) jfreechart.getPlot();      // 獲得圖表區域對像
		categoryplot.setForegroundAlpha(0.5F);                                // 設定前景色為50%透明
		categoryplot.setAxisOffset(new RectangleInsets(5D, 5D, 5D, 5D));      // 設定X軸偏移量
		categoryplot.setBackgroundPaint(Color.lightGray);                     // 設定北景色為淺灰色
		categoryplot.setDomainGridlinesVisible(true);                         // 設定顯示網格線		
		categoryplot.setDomainGridlinePaint(Color.white);                     // 設定網格線為白色
		categoryplot.setRangeGridlinesVisible(true);                          // 設定顯示邊界線		
		categoryplot.setRangeGridlinePaint(Color.white);                      // 設定顯示邊界線為白色
		CategoryAxis categoryaxis = categoryplot.getDomainAxis();             // 獲得X軸對像		
		categoryaxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45); // 設定X軸標籤位置為45度角
		categoryaxis.setLowerMargin(0.0D); 	                                  // 設定與X軸的補白為0
		categoryaxis.setUpperMargin(0.0D);
		
		// 將圖表已資料流的方式傳回給客戶端
		ChartUtilities.writeChartAsPNG(response.getOutputStream(), jfreechart,500, 270);
		

		try{
		  ChartUtilities.saveChartAsPNG(new File("E:\\EclipseDeveloper\\MyEclipse Bling Edition 9\\王者歸來 Java Web 整合開發\\workspace\\JFreeChart\\generatorIMG\\area.png"),jfreechart,500,270);
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
		// 時間維度
		String[] category1 = { "第一季度", "第二季度", "第三季度", "第四季度" };
		// 分類維度
		String[] category2 = { "JAVA", "C/C++", "PHP" };
		DefaultCategoryDataset defaultdataset = new DefaultCategoryDataset();
		for (int i = 0; i < category1.length; i++) {
			String category = category1[i];
			for (int j = 0; j < category2.length; j++) {
				String cat = category2[j];
				// 類比增加資料
				defaultdataset.addValue(DataUtils.getRandomData(), cat, category);
			}
		}
		return defaultdataset;
	}



}
