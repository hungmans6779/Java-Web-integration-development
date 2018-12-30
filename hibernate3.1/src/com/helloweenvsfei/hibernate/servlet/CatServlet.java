package com.helloweenvsfei.hibernate.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.helloweenvsfei.hibernate.bean.Cat;
import com.helloweenvsfei.hibernate.dao.BaseDAO;

/**
 * Servlet implementation class CatServlet
 */
public class CatServlet extends HttpServlet {
	
  private static final long serialVersionUID = 1L;
   
  private BaseDAO <Cat> baseDAO  = new BaseDAO<Cat>();
	
	
	
 /**
   * @see HttpServlet#HttpServlet()
   */
  public CatServlet() {
    super();
  }

     
  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
  }

	
  
  
	
  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	
	/* 
	 * addCat.jsp  使用物件  catList 及 cat
	 * listCat.jsp 使用物件  msg 及 catList
	 * viewCat.jsp 使用物件  cat
	 */
	
	String action = request.getParameter("action");
	if("initAdd".equals(action)){
      initAdd(request,response);        // 顯示增加頁面                                          => addCat.jsp
	}else if("add".equals(action)){
	  add(request,response);            // 向資料庫中插入一條新資料            => listCat.jsp
	}else if("edit".equals(action)){
	  edit(request,response);           // 顯示修改頁面                                          => addCat.jsp
	}else if("save".equals(action)){
	  save(request,response);           // 將修改後的資料儲存進資料庫	  => listCat.jsp
	}else if("view".equals(action)){
	  view(request,response);           // 顯示 id 對應的實體類別屬性       => viewCat.jsp
	}else if("list".equals(action)){
	  list(request,response);           // 顯示所有的實體類別物件	      => listCat.jsp
	}else if("delete".equals(action)){
	  delete(request,response);         // 刪除id 對應的實體類別       	  => listCat.jsp
	}else{ 
	  list(request,response);           // 預設顯示所有的實體類別物件	  => listCat.jsp
	}
	

  } // end doPost
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  // 顯示增加頁面
  protected void initAdd(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
	List<Cat> catList = baseDAO.list("select c from Cat c");
	request.setAttribute("catList",catList);
	
	/*
    RequestDispatcher rd = request.getRequestDispatcher("/addCat.jsp");
    rd.forward(request, response);
    */
	request.getRequestDispatcher("/jsp/cat/addCat.jsp").forward(request,response);
  } // end initAdd
  
  
  
  
  
  
  

  // 向資料庫中插入一條新資料
  protected void add(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
    int motherId = Integer.parseInt(request.getParameter("motherId"));
    String name=request.getParameter("name");
    String description = request.getParameter("description");
    
    Cat mother = baseDAO.find(Cat.class,motherId);
    
    Cat cat = new Cat();
    cat.setName(name);
    cat.setDescription(description);
    cat.setCreateDate(new Date());
    cat.setMother(mother);
    
    baseDAO.create(cat);  // 插入資料表
    
    request.setAttribute("msg","增加 '"+cat.getName()+"' 成功...");
    
    list(request,response); // 顯示所有的實體類別物件	
  } // end add
  
  
  
  
  
  
  

  // 顯示修改頁面
  protected void edit(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
	int id = Integer.parseInt(request.getParameter("id"));
	
	Cat cat = baseDAO.find(Cat.class,id);
	request.setAttribute("cat",cat);
	request.setAttribute("catList",baseDAO.list(" from Cat"));
	
    /*	
	RequestDispatcher rd = request.getRequestDispatcher("/jsp/cat/addCat.jsp");
	rd.forward(request, response);
	*/
	request.getRequestDispatcher("/jsp/cat/addCat.jsp").forward(request, response);
  } // end edit
  
  
  
  
  
  
  

  // 將修改後的資料儲存進資料庫	
  protected void save(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
	  
	int motherId = Integer.parseInt(request.getParameter("motherId"));
	  
	int id = Integer.parseInt(request.getParameter("id"));
	String name= request.getParameter("name");
	String description = request.getParameter("description");
	
	Cat mother = baseDAO.find(Cat.class,motherId);
	Cat cat = baseDAO.find(Cat.class,id);
	
	cat.setName(name);
	cat.setDescription(description);
	cat.setMother(mother);
	
	boolean hasLoop = false;
	Cat tmpMother = mother;
	while(tmpMother!=null){
	  if(tmpMother.getId().intValue() == cat.getId().intValue()){
		 hasLoop = true;
		 break;
	  } // end if(tmpMother.getId().intValue() == cat.getId().intValue()){ 
	  tmpMother = tmpMother.getMother(); // 母貓內應沒有 mother_id
	} // end while(tmpMother!=null){
	
	if(!hasLoop){
      baseDAO.update(cat);
      request.setAttribute("msg","儲存  '"+cat.getName()+"' 成功...");
	}else{
	  request.setAttribute("msg","儲存失敗，發現循環...");	
	}
	
	list(request,response); // 顯示所有的實體類別物件	
  } // end save
  
  
  
  
  
  
  

  // 顯示 id 對應的實體類別屬性 	
  protected void view(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
	int id = Integer.parseInt(request.getParameter("id"));
	
	Cat cat = baseDAO.find(Cat.class,id);
	
	request.setAttribute("cat",cat);
	
    /*	
	RequestDispatcher rd = request.getRequestDispatcher("/jsp/cat/viewCat.jsp");
	rd.forward(request,response);
	*/
	request.getRequestDispatcher("/jsp/cat/viewCat.jsp").forward(request,response);
  } // end view
  
  
  
  
  
  
  

  // 顯示所有的實體類別物件	
  protected void list(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
	request.setAttribute("catList",baseDAO.list(" from Cat"));
	
	/*
	RequestDispatcher rd = request.getRequestDispatcher("/jsp/cat/listCat.jsp");
	rd.forward(request,response);
	*/
	request.getRequestDispatcher("/jsp/cat/listCat.jsp").forward(request,response);
  } // end list
  
  
  
  
  
  
  

  // 刪除id 對應的實體類別
  protected void delete(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
	int id = Integer.parseInt(request.getParameter("id"));
	
	Cat cat = baseDAO.find(Cat.class,id);
	if(cat!=null){
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("  select c from Cat c                            \n");
      sqlStr.append("   where c.mother.id = '").append(id).append("'  \n");
    	 
	  List <Cat> catList = baseDAO.list(sqlStr.toString());
	  if(catList.size()>0){
		request.setAttribute("msg","無法刪除 ' "+cat.getName()+"' 。請先刪除子 Cat。");  
	  }else{
		baseDAO.delete(cat);  
		request.setAttribute("msg","刪除 '"+cat.getName()+"' 成功...");
	  }
	  
	  list(request,response);
	} // end if(cat!=null){
	  
  } // end delete
  
  
	
	
}
