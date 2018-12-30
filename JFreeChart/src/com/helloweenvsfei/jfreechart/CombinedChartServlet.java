package com.helloweenvsfei.jfreechart;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.CombinedDomainCategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class CombinedChartServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public CombinedChartServlet() {
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
		
		CategoryDataset categorydataset = createDataset(); // 建立第一個資料集
		
		NumberAxis numberaxis = new NumberAxis("銷量");
		numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		
		LineAndShapeRenderer lineandshaperenderer = new LineAndShapeRenderer();
		CategoryPlot categoryplot = new CategoryPlot(categorydataset, null,numberaxis, lineandshaperenderer);
		categoryplot.setDomainGridlinesVisible(true);
		
		
		CategoryDataset categorydataset1 = createDataset();  // 建立第二個資料集
		NumberAxis numberaxis1 = new NumberAxis("銷量");
		BarRenderer barrenderer = new BarRenderer();
		barrenderer.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());
		CategoryPlot categoryplot1 = new CategoryPlot(categorydataset1, null,numberaxis1, barrenderer);
		categoryplot1.setDomainGridlinesVisible(true);
		
		// 建立組合資料集
		CategoryAxis categoryaxis = new CategoryAxis();
		CombinedDomainCategoryPlot combineddomaincategoryplot = new CombinedDomainCategoryPlot(categoryaxis);
		combineddomaincategoryplot.add(categoryplot, 2);
		combineddomaincategoryplot.add(categoryplot1, 1);
		
		// 建立圖表對像
		JFreeChart jfreechart = new JFreeChart("組合圖", null,combineddomaincategoryplot, true);

		// 將圖表已資料流的方式傳回給客戶端
		ChartUtilities.writeChartAsPNG(response.getOutputStream(), jfreechart,500, 270);

		try{
		  ChartUtilities.saveChartAsPNG(new File("E:\\EclipseDeveloper\\MyEclipse Bling Edition 9\\王者歸來 Java Web 整合開發\\workspace\\JFreeChart\\generatorIMG\\comb.png"),jfreechart,500,270);
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
		
		String [] category1 = { "第一季度", "第二季度", "第三季度", "第四季度" }; // 時間維度		
		String [] category2 = { "JAVA", "C/C++", "PHP" };     // 分類維度
		
		DefaultCategoryDataset defaultdataset = new DefaultCategoryDataset();
		for(int i = 0; i < category1.length; i++) {
		  String category = category1[i];
		  for(int j = 0; j < category2.length; j++) {
			String cat = category2[j];
			// 類比增加資料
			defaultdataset.addValue(DataUtils.getRandomData(),cat,category);
		  }
	    }
	  return defaultdataset;
	}



}
