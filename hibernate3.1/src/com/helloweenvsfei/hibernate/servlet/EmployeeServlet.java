package com.helloweenvsfei.hibernate.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.helloweenvsfei.hibernate.bean.Employee;
import com.helloweenvsfei.hibernate.util.HibernateUtil;
import com.helloweenvsfei.hibernate.util.Pagination;
import com.helloweenvsfei.hibernate.util.StringUtil;

public class EmployeeServlet extends HttpServlet {

	
	/**
	 * Constructor of the object.
	 */
	public EmployeeServlet() {
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
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doPost(request,response);
	} // end doGet

	
	
	
	
	
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
	  if("add".equals(action)){
		addEmployee(request,response);    // 增加員工
		return;
	  }else if("edit".equals(action)){
		edit(request,response);           // 修改員工  
	  }else if("save".equals(action)){
		save(request,response);           // 儲存員工  
	  }else if("delete".equals(action)){
		delete(request,response);         // 刪除員工  
	  }else{
	    listEmployee(request,response);   // 列出所有員工
	  }
	} // end doPost


	
	
	
	

	// 增加員工
	private void addEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
      
	  Employee employee = StringUtil.getRandomEmployee();  // 隨機產生 Employee 資料
      
	  // 開啟階段
	  Session session = HibernateUtil.getSession();
	  
	  // 開啟交易
	  Transaction trans = session.beginTransaction();
	  
	  // 持久化物件(儲存  employee ) 
	  session.persist(employee);
	  
	  // 執行交易
	  trans.commit();
	  
	  // 關閉階段
	  session.close();

	  request.setAttribute("message","已增加隨機員工："+employee.getName());
	  
	  listEmployee(request,response);   // 列出所有員工	  
	} // end addEmployee
	
	
	
	
	
	
	
	
	// 修改員工  
	private void edit(HttpServletRequest request,HttpServletResponse reponse) throws ServletException,IOException{
		 
	} // end edit
	
	
	
	
	// 儲存員工  
	private void save(HttpServletRequest request,HttpServletResponse reponse) throws ServletException,IOException{
		 
	} // end save
	
	
	
	
	// 刪除員工  
	private void delete(HttpServletRequest request,HttpServletResponse reponse) throws ServletException,IOException{
		 
	} // end delete
	
		
	
	
	
	
	
	
	
	
	// 列出所有員工
	private void listEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
      String sort = request.getParameter("sort");    // 排序列
      String order = request.getParameter("order");  // 排列方式      
      if(StringUtil.isNull(sort)){
    	sort="id";
      }
      if(StringUtil.isNull(order)){
    	order="desc";  
      }
      
      
      String name = request.getParameter("name");                         // 姓名
      String age = request.getParameter("age");                           // 年齡
      String ageOperate = request.getParameter("ageOperate");             // 操作，大於、等於
      String sex = request.getParameter("sex");                           // 要查詢的性別
      String birthday = request.getParameter("birthday");                 // 要查詢的生日
      String time = request.getParameter("time");                         // 要查詢的時間
      String salary = request.getParameter("salary");                     // 要查詢的薪水
      String salaryOperate = request.getParameter("salaryOperate");       // 操作大於、等於
      String description = request.getParameter("description");           // 備註
      String disabled = request.getParameter("disabled");                 // 是否被阻止
      
      
      String where = "";
     
      // 如果查詢姓名
      if(!StringUtil.isNull(name)){
    	if(!StringUtil.isNull(where)){
    	  where +=" and ";  
    	}
    	where +=" e.name like :name ";
      }

      // 如果查詢性別
      if(!StringUtil.isNull(sex)){
    	if(!StringUtil.isNull(where)){
    	  where +=" and ";  
    	}
    	where +=" e.sex = :sex ";
      }      

      // 如果查詢年齡
      if(!StringUtil.isNull(age)){
    	if(!StringUtil.isNull(where)){
    	  where +=" and ";  
    	}
    	where +=" e.age '"+ageOperate+" :age ";   // 組織條件，大於、等於、小於 
      }          

      // 如果查詢生日
      if(!StringUtil.isNull(birthday)){
    	if(!StringUtil.isNull(where)){
    	  where +=" and ";  
    	}
    	where +=" e.birthday = :birthday ";
      }         
      
      // 如果查詢上班時間
      if(!StringUtil.isNull(time)){
    	if(!StringUtil.isNull(where)){
    	  where +=" and ";  
    	}
    	where +=" :time between e.startTime and e.endTime ";
      }         
      
      // 如果查詢薪水
      if(!StringUtil.isNull(salary)){
    	if(!StringUtil.isNull(where)){
    	  where +=" and ";  
    	}
    	where +=" e.salary '"+salaryOperate+" :salary ";   // 組織條件，大於、等於、小於 
      }      
           
      // 如果查詢備註
      if(!StringUtil.isNull(description)){
    	if(!StringUtil.isNull(where)){
    	  where +=" and ";  
    	}
    	where +=" e.description like :description ";
      }   
        
      // 如果查詢狀態
      if(!StringUtil.isNull(disabled)){
    	if(!StringUtil.isNull(where)){
    	  where +=" and ";  
    	}
    	where +=" e.disabled = :disabled ";
      }     
      
      
      String hql = " from Employee e ";
      if(!StringUtil.isNull(where)){
    	hql += "where "+where;  
      }
      hql += " order by e."+sort+" "+order;  // 追加排序支援
      
      
      System.out.println(EmployeeServlet.class.getName()+", hql1 = "+hql);
      
      
      Query query = HibernateUtil.getSession().createQuery("select count(e) "+hql);
      
      
      if(hql.contains("name")){
    	query.setParameter("name","%"+name+"%");
      } 
      if(hql.contains("sex")){
      	query.setParameter("sex",sex);
      } 
      if(hql.contains("age")){
      	query.setInteger("age",new Integer(age));
      }  
      if(hql.contains("birthday")){
      	query.setDate("birthday",Date.valueOf(birthday));
      } 
      if(hql.contains("time")){
      	query.setTime("time",Time.valueOf(time));
      } 
      if(hql.contains("salary")){
      	query.setDouble("salary",new Double(salary));
      } 
      if(hql.contains("description")){
      	query.setParameter("description","%"+description+"%");
      } 
      if(hql.contains("disabled")){
      	query.setBoolean("disabled","true".equals(disabled));
      } 
      
      
      Number result = (Number)query.uniqueResult();
      int count = result.intValue();
      
      
      
      
      Pagination pagination = new Pagination();  // 分頁器
      pagination.setRecordCount(count);          // 設定記錄總數
      pagination.setRequest(request);            // 設定 request
      
      
      query = HibernateUtil.getSession().createQuery(hql).setFirstResult(pagination.getFirstResult()).setMaxResults(pagination.getPageSize());
      
      
      List<Employee> employeeList = query.list();
      request.setAttribute("url",StringUtil.getURL(request));
      request.setAttribute("sort",sort);
      request.setAttribute("pagination",pagination);
      request.setAttribute("employeeList",employeeList);
      
      if(request.getAttribute("message")==null){
    	 request.setAttribute("message","HQL："+hql); 
      }
      
      request.getRequestDispatcher("/listEmployee.jsp").forward(request, response);
            
      return; 
	} // end listEmployee
	
	
	
	
	
	
}
