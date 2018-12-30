package com.helloweenvsfei.itext;

import java.awt.Color;
import java.io.FileOutputStream;


import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

public class FirstPDF {
  
	
  public static void main(String [] args){
	
	  Document document=new Document(PageSize.A4);
	  try{
		  
		// 輸出文件物件,A4紙大小  
	    PdfWriter writer=PdfWriter.getInstance(document,new FileOutputStream("E:\\EclipseDeveloper\\MyEclipse Bling Edition 9\\王者歸來 Java Web 整合開發\\workspace\\iText\\generateDoc\\FirstPDF.pdf"));	
	    
		document.addAuthor("kevin");                 // 設定文件作者
		document.addTitle("This is itext PDF file"); // 設定文件標題
		document.addSubject("First pdf");            // 設定主題
		document.addKeywords("iText");               // 設定關鍵字
		
	   
	    document.open();  // 開啟文件
	    
	    document.add(new Paragraph("Hello World,Hello iText")); // 在 pdf 檔案中寫入文字
	    
	    
		// 設定字體的文字
		document.add(new Paragraph("Hello World, Hello iText",FontFactory.getFont(FontFactory.COURIER, 12, Font.BOLDITALIC)));
		
		BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
		Font FontChinese = new Font(bfChinese, 12, Font.NORMAL);
		// 設定為中文
		Paragraph pragraph=new Paragraph("你好,這是中文", FontChinese);  
		document.add(pragraph);
		

		//建立圖片對象，參數為圖片的檔案名
		Image bmp = Image.getInstance("E:\\EclipseDeveloper\\MyEclipse Bling Edition 9\\王者歸來 Java Web 整合開發\\workspace\\iText\\WebRoot\\mudan.jpg");
		bmp.scalePercent(25f);
	   
	    document.close();  // 關閉文件
	    
	  }catch(Exception e){
		e.printStackTrace();  
	  }
	  
  }
  
  
}
