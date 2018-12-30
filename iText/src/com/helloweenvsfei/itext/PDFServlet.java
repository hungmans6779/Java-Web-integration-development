package com.helloweenvsfei.itext;

import java.io.ByteArrayOutputStream;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;


public class PDFServlet extends HttpServlet {

	private static final long serialVersionUID = -1770041214313726383L;

	public PDFServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	              throws ServletException, IOException {

		// 建立文件對象，A4紙大小
		Document document = new Document(PageSize.A4);
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		try{
		  PdfWriter writer = PdfWriter.getInstance(document,stream);
		  document.open();  // 開啟文件
		  document.add(new Paragraph("Hello Kevin, Hello iText")); // 在 pdf 檔案中寫入文字			
		  document.close(); // 關閉文件
		} catch (Exception e) {
		  e.printStackTrace();
		}
		
		response.setContentType("application/pdf");            // 設定響應文件類型為pdf
		response.setContentLength(stream.size());              // 設定響應資料大小		
		ServletOutputStream out = response.getOutputStream();  // 獲得響應資料流
		stream.writeTo(out);                                   // 將pdf資料流寫入到響應資料流中
		
		out.flush();
		if(out!=null){ out.close(); out=null;  }
		
	} // end doPost

	
}
