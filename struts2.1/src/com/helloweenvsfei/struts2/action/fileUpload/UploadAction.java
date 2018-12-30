package com.helloweenvsfei.struts2.action.fileUpload;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;


/*
 *     Strust1.x、Struts2.x 都提供對上傳檔案的支援。Struts1.x 把上傳後的檔案封裝為 FormFile 物件，
   需要用FileInputStream 讀取。而Struts2.x 則直接把上傳後的檔案封裝為 java.io.File 物件。
   開發者只需在 Action 中定義一個File 類型的變數，然後直接使用該 File 物件，將它複製到目的目錄即可。    
 */
public class UploadAction extends ActionSupport{

  /*
   *     屬性： picture 定義：File 類型的屬性，用於接受表單傳的圖片檔案。Struts2.x 會將圖片儲存後放到暫存檔案夾中，
   * 然後把路徑設定到 picture 屬性上。在 Action 直接參考即可。
   * 
   * 
   *     屬性：pictureFileName，  Struts2.x 檔案只是臨時的，上傳結束後 Struts2.x 會將檔案刪除，因此 UploadAction 中需要將檔案複製出來。
   * 該暫存檔案的名稱不是檔案的原名稱，而是 Struts2.x 根據時間戳記隨機產生的，副檔名為".tmp" ，
   * 目的是保證指存檔案夾中的檔案名不會有重覆。
   * 如果要獲得該檔案的原始名稱，還需要定義一個 String 類型的屬性，屬性名必須為 xxxFileName，
   * 其中 xxx 為 File 屬性的名稱(即本例中的picture)。Struts2.x 會將原檔案名名設定到該屬性上。例如：pictureFileName。
   * 
   *     屬性：pictureContentType，如果要獲得該檔案的原始MIME 類型，需要定義一個 String 類型的屬性，屬性名必須定義為xxxContentType，
   * 其中xxx 也為File 屬性的名稱(即本例的picture)。Struts2.x 會將原文件的MIME 類型設定到該屬性上。例如：pictureContentType。
   *
   *  補充： xxxFileName、xxxContentType 屬性不是必須的。如果有，Struts2.x 會將相關資訊設定進去，如果沒有，就不設定。
   */
	
  private File picture;                // 上傳的檔案。Struts2.x 會將檔案封裝為 File 物件
  private String pictureFileName;      // 檔案名稱。Struts2.x 會將檔案名稱設定到該變數 
  private String pictureContentType;   // 檔案類型。Struts2.x 會將檔案類型設定到該變數
 
  
  private String uploadFilePath; 
  
  
  // 主方法
  public String execute(){
	System.out.println(UploadAction.class.getName()+",execute()....."); 
	return "input";  
  } // execute()


   
  
  
  // 檔案上傳 
  public String upload() throws Exception{
	  
	ServletContext application = ServletActionContext.getServletContext();
	String uploadPath = application.getRealPath("upload");
	
	uploadFilePath = uploadPath;
	
	System.out.println(UploadAction.class.getName()+",upload()....."); 
	System.out.println("File       = "+picture);
	System.out.println("FileName   = "+pictureFileName);
	System.out.println("uploadPath = "+uploadPath);
	
	
	
	// 最後將檔案儲存到/upload 目錄下
	File saved = new File(uploadPath,pictureFileName);
	
	InputStream ins = null;
	OutputStream ous = null;
	try{
	  // 確保資料夾 /upload 存在
	  boolean isMkdir = saved.getParentFile().mkdirs();
	  System.out.println("isMkdir = "+isMkdir);
		
	  ins = new FileInputStream(picture);  // 讀入暫存檔案
	  ous = new FileOutputStream(saved);   // 寫入到upload 下
	  
	  byte [] b =  new byte[1024];  // 位元組快取記憶體
	  int len = 0 ;
	  while((len = ins.read(b))!=-1){
		ous.write(b,0,len);   // 寫入檔案
	  } // end while((len = ins.read(b))!=-1){
	  
	}catch(Exception e){
	  e.printStackTrace();	
	}finally{
	  if(ous!=null) { ous.close(); ous = null; }
	  if(ins!=null) { ins.close(); ins = null; }
	}
	
	return "list"; 
  } // uplad()
  

  
  
  
  
  
  public File getPicture() {
	return picture;
  }

  public void setPicture(File picture) {
	this.picture = picture;
  }

  public String getPictureContentType() {
	return pictureContentType;
  }

  public void setPictureContentType(String pictureContentType) {
	this.pictureContentType = pictureContentType;
  }

  public String getPictureFileName() {
	return pictureFileName;
  }

  public void setPictureFileName(String pictureFileName) {
	this.pictureFileName = pictureFileName;
  }



  public String getUploadFilePath() {
	return uploadFilePath;
  }


  
  
}
