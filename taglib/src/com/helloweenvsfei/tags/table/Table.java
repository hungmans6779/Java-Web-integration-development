package com.helloweenvsfei.tags.table;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class Table extends BodyTagSupport {

	public Table() {
		// TODO Auto-generated constructor stub
	}
	
	
	private static final long serialVersionUID = 3358444196409845360L;
	 
	private List<Map<String,String>> columns=new ArrayList<Map<String,String>>();
	private Object items;
	private String url;
	
	
	/**
	 * @return the columns
	 */
	public List<Map<String, String>> getColumns() {
		return columns;
	}

	/**
	 * @param columns the columns to set
	 */
	public void setColumns(List<Map<String, String>> columns) {
		this.columns = columns;
	}

	/**
	 * @return the items
	 */
	public Object getItems() {
		return items;
	}

	/**
	 * @param items the items to set
	 */
	public void setItems(Object items) {
		this.items = items;
	}


	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}




	

	public int doStartTag() throws JspException{
		columns.clear();
		return super.doStartTag();
	
	}

	
	
	
	
	public int doAfterBody() throws JspException{

		try{
      
          BodyContent bc=getBodyContent();        // 獲得標籤體
          JspWriter out=bc.getEnclosingWriter();
          
	      HttpServletRequest request=(HttpServletRequest)pageContext.getRequest();
	     
	      String orderName=request.getParameter("orderName"); 
	      String orderType=request.getParameter("orderType");      // 排序方式
	             orderType="desc".equals(orderType)?"desc":"asc";  // 昇冪還是降冪
	      
	      out.println("<table id=theObjTable");
	      out.println("   class=list_table STYLE='table-layout:fixed;' >");
	      out.println("   <tr class=tr_title>");
	      out.println("   <script>var columns = []; </script>");

	      for(int i=0;i<columns.size();i++){
	        Map<String,String> column=columns.get(i);  // 獲得列資料
	        
	        String property=column.get("property");  // 列對應的POJO的屬性
	        String label=column.get("label");        // 列名稱
	               label=(label==null)?property:label;
	               
	        out.println("<td id='__id_td_" + property + "'>");
	        out.println("<font class='resizeDivClass'");
	        out.println("      onmousedown='MouseDownToResize(this);');");
	        out.println("      onmousemove='MouseMoveToResize(this);'");
	        out.println("      onmouseup='MouseUpToResize(this);'></font>");
            out.println("<span onclick=\"sort('" + property + "'); \"");
	        out.println(" style=\"cursor: pointer; \">");
            out.println(label);

	        if(property.equals(orderName)){        	
	          out.println("<img src='images/" + orderType+".gif' border=0/>");
	        }
            out.println("</span>");
            out.println("</td>");
	        out.println("<script>columns[columns.length] = '__id_td_" + property + "'; </script>");
	      } // end for(int i=0;i<columns.size();i++){
	      out.println("</tr>");
	      
	      
          if (items != null){
 
          	/** 檢查所有的資料 */
            for(Object obj : (Iterable) items) {	
              out.println("   <tr class=tr_data>");    
              for(int i = 0; i < columns.size(); i++){    	
                Map<String, String> column = columns.get(i);
                String property = column.get("property");
                String getterStyle = toGetterStyle(property);
                
                try{
                  String getter = "get" + getterStyle;  // ex. getId
                  String is = "is" + getterStyle;       // ex. isId

                  Method method = null;
                  try{
                	// obj.getClass() // ex. class com.helloweenvsfei.bean.Person
                    /** 獲得 getXxx() 形式的方法 */
                    method = obj.getClass().getMethod(getter); // 傳回一個 Method 對象，它反映此 Class 物件 所表示的類別或介面的指定公共成員方法。
                  }catch (Exception e){}

                  if(method == null){ /** 如果沒有，獲得 isXxx() 形式的方法 */
                    method = obj.getClass().getMethod(is); // 傳回一個 Method 對象，它反映此 Class 物件 所表示的類別或介面的指定公共成員方法。
                  }
               
                  method.setAccessible(true); // 使用單一安全性檢查（為了提高效率）為一組物件 設置 accessible 標誌的便捷方法。
                  
                  /** 獲得屬性值 */
                  Object value = method.invoke(obj);  // 對帶有指定引數的指定物件 呼叫由此 Method 物件 表示的底層方法。
                  out.println("<td><span title='" + value + "'>" + value + "</span></td>");

                }catch (Exception e){
                  throw new JspException(e);
                }
              } // end for(int i = 0; i < columns.size(); i++){
              out.println("   </tr>");
            } // end for(Object obj : (Iterable) items) {
          } // end if (items != null){
          out.println("</table>");
  
          out.println("<script>");
          out.println("   var orderName = '" + orderName + "'; ");
          out.println("   var orderType = '" + orderType + "'; ");
          out.println("   function sort(column){");
          out.println("       if(orderName == column){");
          out.println("           location='" + url + "?orderName=' + column + '&orderType=' + (orderType=='asc' ? 'desc' : 'asc'); ");
          out.println("       }");
          out.println("       else{");
          out.println("           location='" + url + "?orderName=' + column + '&orderType=' + orderType; ");
          out.println("       }");
          out.println("   }");
          out.println("</script>");
    
		}catch(Exception e){
		  throw new JspException("Error:"+e.getMessage());
		}
		return SKIP_BODY;
	}
	
	
	
	
	
    /**
     * 首字母大寫
     * @param column
     * @return
     */
    public String toGetterStyle(String column){
      if(column.length() == 1){
        return column.toUpperCase();
      }
      char ch = column.charAt(0);
      return Character.toUpperCase(ch) + column.substring(1);
    }

    
    
}
