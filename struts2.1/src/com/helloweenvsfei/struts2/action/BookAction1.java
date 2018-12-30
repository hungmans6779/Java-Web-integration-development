package com.helloweenvsfei.struts2.action;

import java.util.List;
import java.util.ArrayList;

import org.apache.struts2.interceptor.validation.SkipValidation;



import com.helloweenvsfei.struts2.action.bean.Book1;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.DateRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;




public class BookAction1 extends ActionSupport {

	public static List <Book1> bookList = new ArrayList<Book1>();  // static 的 List，模擬資料庫
	private String title;                                          // JSP 頁面標題
	private Book1 book;                                            // Book 物件(不須要在這 new 出一個物件，如果沒有物件，會在執行時透過反射產生實體一個物件，)
             
	// 因此不會拋出 NullPointerException
	
	// 顯示增加書籍頁面
	@SkipValidation
	public String initAdd(){
	  System.out.println(BookAction.class.getName()+",initAdd()....");
	 
	  return "initAdd";	  // 傳回增加頁面
	} // end initAdd
	

	
	
	
	// 增加書籍
    /*
	@Validations(requiredStrings = {
			     @RequiredStringValidator(type = ValidatorType.SIMPLE,trim = true, fieldName = "book.name", message = "請輸入書籍名稱. *"),
		  	     @RequiredStringValidator(type = ValidatorType.SIMPLE,trim = true, fieldName = "book.author", message = "請輸入書籍作者. *") 
		      },dateRangeFields = { @DateRangeFieldValidator(type = ValidatorType.SIMPLE, fieldName = "book.publishedDate", min = "1900-01-01", max = "2200-01-01", message = "日期必須大於 ${min} 小於 ${max}, 目前值為 ${book.publishedDate}.") })
    */
	public String add(){
	  System.out.println("*********************************");
	  System.out.println(BookAction1.class.getName()+",add()...");
	  System.out.println("01.Name          = "+book.getName());
	  System.out.println("02.Author        = "+book.getAuthor());
	  System.out.println("03.publishedDate = "+book.getPublishedDate());
	  System.out.println("*********************************");
	  
	  bookList.add(book);  // 放到 List 中
	  System.out.println("add() bookList size = "+bookList.size());
	  title="<br><br>增加書籍成功<br><br>";   // 設定標題
	  
	  return "success";    // 傳回成功頁面
	} // end add
	
	
	
	// 書籍列表
	@SkipValidation
	public String list(){
	  System.out.println(BookAction1.class.getName()+",list()... bookList.size = "+bookList.size()); 
 
	  return "list";       // 傳回清單頁面	
	} // end list
	
	
	
	// 清空書籍列表
	@SkipValidation
	public String clear(){
	  System.out.println(BookAction1.class.getName()+",clear()... bookList.size = "+bookList.size()); 
		  
	  bookList.clear(); // 清空所有的Book 
	  title="<br><br>清空書籍列表成功<br><br>";    // 設定標題
	  
	  return "list";        // 傳回清單頁面
	}  // end clear
	
	
	
	
	
	
	

	public List<Book1> getBookList() {
	  return bookList;  
	}

	public String getTitle() {
	  return title;
	}

	public void setTitle(String title) {
	  this.title = title;
	}

	public Book1 getBook() {
	  return book;
	}

	public void setBook(Book1 book) {
	  this.book = book;
	}

}
