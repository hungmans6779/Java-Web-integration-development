package com.helloweenvsfei.watermark;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class ImageUtil {

	
  public static byte [] waterMark(byte [] imageData,String waterMarkFile) throws IOException{
	
	int paddingRight=10;
	int paddingBottom=10;
	
	Image image=new ImageIcon(imageData).getImage();
	int imageWidth=image.getWidth(null);
	int imageHeight=image.getHeight(null);
	
	Image waterMark=ImageIO.read(new File(waterMarkFile));
	int waterMarkWidth=waterMark.getWidth(null);
	int waterMarkHeight=waterMark.getHeight(null);
	
	
	// 如果圖片尺寸過小，則不打浮水印，直接傳回
	if(imageWidth < waterMarkWidth +2*paddingRight || imageHeight < waterMarkHeight + 2*paddingBottom){
	  return imageData;	
	}
	
	// 影像緩衝區
	BufferedImage bufferedImage=new BufferedImage(imageWidth,imageHeight,BufferedImage.TYPE_INT_RGB);
	
	
	// 繪圖用的Graphics 物件
	Graphics g=bufferedImage.createGraphics();
	
	// 繪製原始影像
	g.drawImage(image,0,0,imageWidth,imageHeight,null);
	
	// 繪製浮水印圖片
	g.drawImage(waterMark,imageWidth-waterMarkWidth-paddingRight,imageHeight-waterMarkHeight-paddingBottom,waterMarkWidth,waterMarkHeight,null);
	
	g.dispose();
	
	
	// 輸出流，快取記憶體資料 
	ByteArrayOutputStream out=new ByteArrayOutputStream();
	
	// 轉成JPG圖
	JPEGImageEncoder encoder=JPEGCodec.createJPEGEncoder(out);
	
	// 轉換
	encoder.encode(bufferedImage);
	
	// 轉出二進位
	byte [] data=out.toByteArray();
	out.close();
	return data;
	
  }
  
}
