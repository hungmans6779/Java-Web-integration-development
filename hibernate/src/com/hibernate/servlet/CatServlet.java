package com.hibernate.servlet;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hibernate.bean.Cat;
import com.hibernate.dao.BaseDAO;

public class CatServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public CatServlet() {
		super();
	}

	
	
	
	private BaseDAO <Cat> baseDAO = new BaseDAO<Cat>();
	
	
	
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
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	  request.setCharacterEncoding("UTF-8");
	  response.setCharacterEncoding("UTF-8");
	  
	  String action = request.getParameter("action");
	  
	  System.out.println("CatServlet.java doPost action = "+action);
	  
	  if("list".equals(action)){            // 顯示所有的實體類別物件
	    list(request,response); 
	  }else if("initAdd".equals(action)){   // 顯示增加頁面
		initAdd(request,response);  
	  }else if("add".equals(action)){       // 向資料庫中插入一條新資料
		add(request,response);  
	  }else if("edit".equals(action)){      // 顯示修改頁面
		edit(request,response);  
	  }else if("save".equals(action)){      // 將修改後的資料儲存進資料庫
		save(request,response); 
	  }else if("delete".equals(action)){    // 刪除 id 對應的實體類別
		delete(request,response);  
	  }else if("view".equals(action)){      // 顯示 id 對應的實體類別屬性
		view(request,response);   
	  }else{                                // 預設顯示所有的實體類別物件
		list(request,response);   
	  }
	  
	}

	
	
	
    // 顯示所有的實體類別物件
    protected void list(HttpServletRequest request,HttpServletResponse response)
              throws ServletException,IOException{
      List <Cat> catList = baseDAO.list(" from Cat");  // 尋找多個Entity Bean
      request.setAttribute("catList",catList);
      RequestDispatcher rd = request.getRequestDispatcher("/listCat.jsp");
      rd.forward(request,response);
    }
    
    	
	
	
	// 顯示增加頁面
    protected void initAdd(HttpServletRequest request,HttpServletResponse response) 
              throws ServletException,IOException{
	  List <Cat> catList = baseDAO.list("select c from Cat c");  // 尋找多個Entity Bean
	  request.setAttribute("catList",catList);
	  RequestDispatcher rd = request.getRequestDispatcher("/addCat.jsp");
	  rd.forward(request, response);
    }
  

    
    
    
   
    
    
    // 向資料庫中插入一條新資料
    protected void add(HttpServletRequest request,HttpServletResponse response)
              throws ServletException,IOException{
   
      int motherId = Integer.parseInt(request.getParameter("motherId"));
      String name = request.getParameter("name");
      String description = request.getParameter("description");
      
      System.out.println("*************CatServlet.java add Method ***************");
      System.out.println("motherId    = "+motherId);
      System.out.println("name        = "+name);
      System.out.println("description = "+description);
      System.out.println("*******************************************************");
      
      Cat mother = baseDAO.find(Cat.class,motherId); // 根據 id 尋找單一Entity Bean

      Cat cat = new Cat();
      cat.setName(name);
      cat.setMother(mother);
      cat.setDescription(description);
      cat.setCreateDate(new Date());
      
      baseDAO.create(cat);  // 插入資料
      
      request.setAttribute("msg","增加 '"+cat.getName()+"' 成功");
      list(request,response);
    }
    
    
    
    
    
    
    
	
    // 顯示修改頁面
    protected void edit(HttpServletRequest request,HttpServletResponse response)
              throws ServletException,IOException{
    	
      int id = Integer.parseInt(request.getParameter("id"));
      
      System.out.println("*************CatServlet.java edit Method ***************");
      System.out.println("id = "+id);
      System.out.println("********************************************************");
      
      Cat cat = baseDAO.find(Cat.class,id);         // 根據 id 尋找單一Entity Bean
      request.setAttribute("cat",cat);
 
      List <Cat> catList = baseDAO.list(" from Cat"); // 尋找多個Entity Bean
      request.setAttribute("catList",catList);
      
      RequestDispatcher rd = request.getRequestDispatcher("/addCat.jsp");
      rd.forward(request,response);
    }
    
    
    
    
    
    // 將修改後的資料儲存進資料庫
    protected void save(HttpServletRequest request,HttpServletResponse response)
              throws ServletException,IOException{
    
      int motherId = Integer.parseInt(request.getParameter("motherId"));
      int id = Integer.parseInt(request.getParameter("id"));
      String name=request.getParameter("name");
      String description = request.getParameter("description");
      
      System.out.println("*************CatServlet.java save Method **************");
      System.out.println("motherId    = "+motherId);
      System.out.println("id          = "+id);
      System.out.println("name        = "+name);
      System.out.println("description = "+description);
      System.out.println("*******************************************************");
      
      Cat mother = baseDAO.find(Cat.class,motherId);  // 根據 id 尋找單一Entity Bean
     
      Cat cat = baseDAO.find(Cat.class, id);          // 根據 id 尋找單一Entity Bean
      cat.setName(name);
      cat.setDescription(description);
      cat.setMother(mother);
     
      boolean hasLoop=false;
      Cat tmpMother = mother;
      while(tmpMother != null){
    	System.out.println("CatServlet.java tmpMother.getId() = "+tmpMother.getId().intValue());
    	System.out.println("CatServlet.java cat.getId()       = "+cat.getId().intValue());
        if(tmpMother.getId().intValue() == cat.getId().intValue()){
          hasLoop = true;
          break;
        }
        tmpMother = tmpMother.getMother();
      } // end while(tmpMother != null){
      
      if(!hasLoop){
    	baseDAO.update(cat);  // 更新資料庫
    	request.setAttribute("msg","儲存 ' "+cat.getName()+"' 成功");
      }else{
    	request.setAttribute("msg", "儲存失敗。發現循環。");  
      }
      list(request, response); // 顯示所有的實體類別物件
    }
    
    
 
    

    
    // 刪除 id 對應的實體類別
    protected void delete(HttpServletRequest request,HttpServletResponse response)
              throws ServletException,IOException{
    
      int id = Integer.parseInt(request.getParameter("id"));
      
      System.out.println("*************CatServlet.java delete Method ************");
      System.out.println("id          = "+id);
      System.out.println("*******************************************************");
      
      Cat cat = baseDAO.find(Cat.class,id); // 根據 id 尋找單一Entity Bean
      if(cat!=null){ 
    	List <Cat> catList = baseDAO.list("select c from Cat c where c.mother.id = "+id); // 尋找多個Entity Bean
    	if(catList.size() > 0){
    	  request.setAttribute("msg", "無法刪除 '" + cat.getName()+ "'。請先刪除子Cat。");
    	}else{
    	  baseDAO.delete(cat);  // 從資料庫中刪除
		  request.setAttribute("msg", "刪除 '" + cat.getName() + "' 成功。");
    	}
      } // end if(cat!=null){
      list(request,response);
    }
    
    
    
    
    
    
    // 顯示 id 對應的實體類別屬性
    protected void view(HttpServletRequest request,HttpServletResponse response)
              throws ServletException,IOException{
      
      int id = Integer.parseInt(request.getParameter("id"));
      
      System.out.println("*************CatServlet.java view Method ***************");
      System.out.println("id = "+id);
      System.out.println("********************************************************");

      Cat cat = baseDAO.find(Cat.class,id);  // 根據 id 尋找單一Entity Bean
      request.setAttribute("cat",cat);
      
      RequestDispatcher rd = request.getRequestDispatcher("/viewCat.jsp");
      rd.forward(request, response);
    }
    

    

}
