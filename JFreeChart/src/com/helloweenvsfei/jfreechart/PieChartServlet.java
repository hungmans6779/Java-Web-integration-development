package com.helloweenvsfei.jfreechart;

import java.awt.Font;
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
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

public class PieChartServlet extends HttpServlet {

	
	private static final long serialVersionUID = -3798298158506030366L;
	
	/**
	 * Constructor of the object.
	 */
	public PieChartServlet() {
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

		
	  response.setContentType("image/png");  // 設定傳回類型為圖片
	  request.setCharacterEncoding("UTF-8");
	  response.setCharacterEncoding("UTF-8");
	  
	  PieDataset dataset=createPieDataset(); // 獲得資料集物件
	  
	  // 建立圖形物件
	  JFreeChart jfreechart =ChartFactory.createPieChart3D("2011 年圖書銷量排行榜", dataset,true,true,false);
	 
	  PiePlot pieplot=(PiePlot)jfreechart.getPlot();  // 獲得圖表的區域物件
	  pieplot.setLabelFont(new Font("細明體",0,12));  // 設定圖表區域的標籤字體	  
	  pieplot.setNoDataMessage("沒有銷售資料");        // 設定圖表區域無數據時的預設顯示文字
	  pieplot.setCircular(false);                     // 設定圖表區不是圖形，由於是3D的餠狀圖，建議設定為false
	  pieplot.setLabelGap(0.02D);                     // 設定圖表區域文字與圖表區域的間隔距離，0.02表示2%
	  
	  // 將圖表以資料流程的方式回傳給用戶端
	  ChartUtilities.writeChartAsPNG(response.getOutputStream(),jfreechart,500,270);
	  
	  try{
	    ChartUtilities.saveChartAsPNG(new File("E:\\EclipseDeveloper\\MyEclipse Bling Edition 9\\王者歸來 Java Web 整合開發\\workspace\\JFreeChart\\generatorIMG\\pie.png"),jfreechart,500,270);
	  }catch(Exception e){
		e.printStackTrace();  
	  }
	}

	
	
	private static PieDataset createPieDataset(){

	  // 建立餅狀圖的資料集物件
	  DefaultPieDataset defaultpiedataset=new DefaultPieDataset();
		
	  // 分別設定繪圖區域的說明和資料
	  defaultpiedataset.setValue("JAVA",DataUtils.getRandomData());
	  defaultpiedataset.setValue("C/C++",DataUtils.getRandomData());
	  defaultpiedataset.setValue("PHP",DataUtils.getRandomData());
	  defaultpiedataset.setValue("JavaScript",DataUtils.getRandomData());
	  defaultpiedataset.setValue("Ajax",DataUtils.getRandomData());
	  
	  return defaultpiedataset;
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
