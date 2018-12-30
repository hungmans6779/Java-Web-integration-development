package com.helloweenvsfei.hibernate.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.helloweenvsfei.hibernate.bean.Department;
import com.helloweenvsfei.hibernate.bean.Employee;
import com.helloweenvsfei.hibernate.util.HibernateUtil;
import com.helloweenvsfei.hibernate.util.StringUtil;


/*
 *  DepartmentServlet 管理 Department 實體的相關操作，包括建立(Create)、更新(Update)、刪除(Delete)、查詢(Read)等GRUD 操作等。
 *  先看一下查詢功能。查詢功能列出所有的部門，包括部門名稱、經理、包括的員工數、所包括的員工等，並支援按一下表頭排序。
 */

/**
 * Servlet implementation class DepartmentServlet
 */
public class DepartmentServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentServlet() {
        super();    
    }

    
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  doPost(request,response);
	} // end doGet

	
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  request.setCharacterEncoding("UTF-8");
	  response.setCharacterEncoding("UTF-8");
	 
	  
	  String action = request.getParameter("action"); // action 參數
	  if("add".equals(action)){
		add(request,response);           // 增加部門
	  }else if("query".equals(action)){
		query(request,response);         // 供Ajax 用，查詢經理名稱
	  }else{
		list(request,response);          // 查詢部門
	  }
	  
	} // end doPost
	
	

	
	
	
	// 增加部門
	private void add(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
	  String id = request.getParameter("id");                         // 獲得 id
	  String name = request.getParameter("name");                     // 獲得部門名稱
	  String description = request.getParameter("description");       // 獲得描述
	  String lineManagerId = request.getParameter("lineManagerId");   // 獲得經理 id
	  
	  
	  RequestDispatcher rd = request.getRequestDispatcher("/addDepartment.jsp");
	  
	  
	  // 開啟階段
	  Session session = HibernateUtil.getSession();
	  
	  // 開啟交易
	  Transaction trans = session.beginTransaction();
	  
	  List list = session.createQuery("from Department d where d.name = :name ").setParameter("name",name).list();
	  if(list.size()>0){
	    request.setAttribute("message","部門名稱\""+name+"\"已經存在");
	    rd.forward(request, response);
	    session.close();
	    return;
	  } // end if(list.size()>0){
	  
	  
	  Department d = new Department();  // 新增一個部門
	  d.setName(name);                  // 設定名稱
	  d.setDescription(description);    // 設定描述
  	  if(!StringUtil.isNull(lineManagerId)){
  	    Employee lineManager = (Employee)session.get(Employee.class,new Integer(lineManagerId));  // 查詢該經理
  	    d.setLineManager(lineManager);                                                            // 設定經理
  	  }
	 
  	  // 持久化物件
  	  session.persist(d);
  	  
  	  // 執行交易
  	  trans.commit();
  	  
  	  // 關閉階段
  	  session.close();
	  
  	  
  	  request.setAttribute("message","部門\""+d.getName()+"\"儲存成功。");
  	  
  	  list(request,response); // 查詢部門
	} // add
	
	
	
	
	
	
	// 供Ajax 用，查詢經理名稱
	private void query(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
	  String key = request.getParameter("key"); // 獲得關鍵字
	  String hql = "from Employee e";
	  
	  if(!StringUtil.isNull(key)){
		hql += " where e.name like '%"+key+"%'";
	  }
	  final int SIZE = 8;
	  
	  Session session = HibernateUtil.getSession();
	  List<Employee > employeeList = session.createQuery(hql).setMaxResults(SIZE).list();
	  
	  session.close();
	  
	  StringBuffer buffer  = new StringBuffer();
	  buffer.append("{");
	  for(int i=0;i<employeeList.size();i++){
		if(i!=0) buffer.append(",");
		Employee employee = employeeList.get(i);
		buffer.append(employee.getId()+":\""+employee.getName()+"\"");
	  }
	  if(employeeList.size()>=SIZE){
		buffer.append(",0:\"超過"+SIZE+"條資料...\"");  
	  }
	  
	  buffer.append("}");
	  
	  response.getWriter().write(buffer.toString());
	  
	  
	} // query
	
	
	
	
	
	
	// 查詢部門
	private void list(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
	  String sort = request.getParameter("SORT");    // 排序列
	  String order = request.getParameter("order");  // 排序方式：昇冪、降冪
	  
	  if(StringUtil.isNull(sort)){
		sort="id";                       // 預設為 id 排序
	  }
	  if(StringUtil.isNull(order)){
		order="desc";                    // 預設為降冪排列  
	  }
	  
	
	  String departmentName = request.getParameter("departmentName");          // 部門名稱
	  String managerName = request.getParameter("managerName");                // 經理姓名
	  String employeeSize = request.getParameter("employeeSize");              // 員工數量
	  String employeesOperator = request.getParameter("employeesOperator");    // 數量操作 
	  
	  
	  String where = "";
	  
	  // 查詢部門名稱
	  if(!StringUtil.isNull(departmentName)){
		if(where.length()!=0){
		  where += " and ";	
		}
		where +=" d.name like :departmentName ";
	  } 
	  
	  // 查詢經理姓名
	  if(!StringUtil.isNull(managerName)){
		if(where.length()!=0){
		  where += " and ";	
		}
		where +=" d.lineManager.name like :managerName ";
	  }   
	  
	  // 查詢員工數
	  if(!StringUtil.isNull(employeeSize)){
		if(where.length()!=0){
		  where += " and ";	
		}
		where +=" d.employees.size "+employeesOperator+" :employeeSize ";
		// where +=" size(d.employees) "+employeesOperator+" :employeeSize ";
	  }   
	  
	  
	  String hql = " from Department d ";  // HQL 敘述
      if(where.length()!=0){
        hql += "where "+where;	  
      }
      hql += " order by d."+sort+" "+order; // 連接排序列
     
      System.out.println(DepartmentServlet.class.getName()+",hql = "+hql);
      
     
      
      
      
      
      
      // 開啟階段
      Session session = HibernateUtil.getSession();
	  
      // 開啟交易
      Transaction trans = session.beginTransaction();
      
      Query query = session.createQuery(hql);
      
      if(hql.contains("departmentName")){
        query.setParameter("departmentName","%"+departmentName+"%");
      }
      
      if(hql.contains("managerName")){
        query.setParameter("managerName","%"+managerName+"%");
      }
        
      if(hql.contains("employeeSize")){
        query.setInteger("employeeSize",Integer.parseInt(employeeSize));
      }
        
      
      // 檢查一下查詢出的部門
      List<Department> departmentList = query.list();
      for(Department d:departmentList){
        d.getEmployees().size();	  
      }
      
      
      // 執行交易
      trans.commit();
      
      // 關閉階段
      session.close();
      

      request.setAttribute("departmentList",departmentList);   // 將 departmentList 物件儲存到 request
      request.setAttribute("sort",sort);                       // 儲存排序列
      request.setAttribute("order",order);                     // 儲存排序方式
      request.setAttribute("url",StringUtil.getURL(request));  // 計算URL
      
      // 輸出 HQL 敘述
      if(request.getAttribute("message")==null){
    	request.setAttribute("message","HQL："+hql);  
      }
      
      
      
      // 轉到 listDepartment.jsp 頁面
      RequestDispatcher rd = request.getRequestDispatcher("/listDepartment.jsp");
      rd.forward(request,response);                              
      
	} // list
	
	
	
	
}
