/*
 * IBM Confidential
 * 
 * OCO Source Materials
 * 
 * #ID# IBM CRL Supply Chain Management Research
 * 
 * (C) Copyright IBM Corp. 2005, 2006
 * 
 * The source code for this program is not published or otherwise divested of
 * its trade secrets.
 * 
 */
package com.helloweenvsfei.util;

import java.net.URLEncoder;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Pagination{
	
    private int pageSize = 20;
    private int pageNum  = 1;
    private int recordCount;
    private int pageCount;
    private int firstResult;
    private String pageUrl;

    public Pagination(HttpServletRequest request, HttpServletResponse response){
        
    	try{
           pageNum = Integer.parseInt(request.getParameter("pageNum"));
           System.out.println("request.getParameter('pageNum') = "+request.getParameter("pageNum"));
        }catch (Exception e){}

        for(Cookie cookie : request.getCookies()){
            if ("pageSize".equals(cookie.getName())) {
                try{
                    pageSize = Integer.parseInt(cookie.getValue());
                    System.out.println("pageSize = "+pageSize);
                }catch (Exception e){}
            }
        }

        
        try{
            pageSize = Integer.parseInt(request.getParameter("pageSize"));
            System.out.println("request.getParameter('pageSize') = "+request.getParameter("pageSize"));
        }catch (Exception e){}

        
        Cookie cookie = new Cookie("pageSize", Integer.toString(pageSize));
        cookie.setMaxAge(Integer.MAX_VALUE);
        response.addCookie(cookie);

        
        StringBuffer queryString = new StringBuffer();
        for(Object parameterName : request.getParameterMap().keySet()){
            String name = (String) parameterName;
            if ("pageNum".equals(name) || "pageSize".equals(name)){
                continue;
            }

            for(String value : request.getParameterValues(name)){
                if (queryString.length() > 0){
                    queryString.append("&");
                }

                try{
                    queryString.append(name + "="+ URLEncoder.encode(value, "UTF-8"));
                }catch (Exception e){
                    queryString.append(name + "=" + value);
                }
            }
        }
        pageUrl = request.getRequestURI() + "?" + queryString.toString();
    }

    
    
    
    
    private void calculate(){
        pageCount = (recordCount + pageSize - 1) / pageSize;
        firstResult = (pageNum - 1) * pageSize;
    }

    
    
    /**
     * 玻ネだ戈癟 珹材程单单
     * 
     * @param pageNum
     *            ヘ玡计
     * @param pageCount
     *            羆计
     * @param recordCount
     *            羆癘魁计
     * @param pageUrl
     *             URL
     * @return
     */
    public String toString(){
        calculate();

        String url = pageUrl.contains("?") ? pageUrl : pageUrl + "?";
        
        StringBuffer buffer = new StringBuffer();
        buffer.append("– ");
        buffer.append("<select name=ibm_crl_scm_page_size_select onchange='setPageSize(value); ' >");
        buffer.append(" <option value=5"+ (pageSize == 5 ? " selected " : "") + ">5</option>");
        buffer.append(" <option value=20"+ (pageSize == 20 ? " selected " : "") + ">20</option>");
        buffer.append(" <option value=40"+ (pageSize == 40 ? " selected " : "") + ">40</option>");
        buffer.append(" <option value=60"+ (pageSize == 60 ? " selected " : "") + ">60</option>");
        buffer.append(" <option value=80"+ (pageSize == 80 ? " selected " : "") + ">80</option>");
        buffer.append(" <option value=100"+ (pageSize == 100 ? " selected " : "") + ">100</option>");
        buffer.append("</select> 兵癘魁 ");
        buffer.append(" 羆癘魁计: " + recordCount);
        buffer.append(" 计/羆计: " + pageNum + "/" + pageCount + "  ");
        buffer.append("  ");
        buffer.append(pageCount == 0 || pageNum == 1 ? " 材 " : " <a href='"+ url + "&pageNum=1'>材</a> ");
        buffer.append("  &nbsp;  ");
        buffer.append(pageCount == 0 || pageNum == 1 ? "  " : " <a href='"+ url + "&pageNum=" + (pageNum - 1) + "'></a> ");
        buffer.append("  &nbsp;  ");
        buffer.append(pageCount == 0 || pageNum == pageCount ? "  ": " <a href='" + url + "&pageNum=" + (pageNum + 1)+ "'></a> ");
        buffer.append("  &nbsp;  ");
        buffer.append(pageCount == 0 || pageNum == pageCount ? " 程 " : " <a href='" + url + "&pageNum=" + pageCount + "'>程</a> ");
        buffer.append(" &nbsp;  锣材<input type='text' name='ibm_crl_scm_goto_input' " + " style='width:20px; font-size:12px; text-align:center; '> ");
        buffer.append(" <input type='button' "+ " name='ibm_crl_scm_goto_button' value='Go' class='button'>");
        buffer.append("<script language='javascript'>");
        buffer.append("function helloweenvsfei_enter(){");
        buffer.append(" if(event.keyCode == 13){");
        buffer.append("     helloweenvsfei_goto();");
        buffer.append("     return false;");
        buffer.append(" }");
        buffer.append(" return true;");
        buffer.append("} ");
        buffer.append("function setPageSize(pageSize){");
        buffer.append(" location='" + url + "&pageSize=' + pageSize;");
        buffer.append("} ");
        buffer.append("function helloweenvsfei_goto(){");
        buffer.append(" var numText = document.getElementsByName('ibm_crl_scm_goto_input')[0].value;");
        buffer.append(" var num = parseInt(numText, 10);");
        buffer.append(" if(!num){");
        buffer.append("     alert('Input must be a number');   ");
        buffer.append("     return;");
        buffer.append(" }");
        buffer.append(" if(num<1 || num>" + pageCount + "){");
        buffer.append("     alert('Input must between 1 and " + pageCount + ". ');    ");
        buffer.append("     return;");
        buffer.append(" }");
        buffer.append(" location='" + url + "&pageNum=' + num;");
        buffer.append("}");
        buffer.append("document.getElementsByName('ibm_crl_scm_goto_input')[0].onkeypress = helloweenvsfei_enter;");
        buffer.append("document.getElementsByName('ibm_crl_scm_goto_button')[0].onclick = helloweenvsfei_goto;");
        buffer.append("</script>");

        return buffer.toString();
    }

    
    
    public int getPageSize(){
        calculate();
        return pageSize;
    }

    
    public void setPageSize(int pageSize){
        calculate();
        this.pageSize = pageSize;
    }

    public int getRecordCount(){
        calculate();
        return recordCount;
    }

    public void setRecordCount(int recordCount){
        calculate();
        this.recordCount = recordCount;
    }

    
    public int getFirstResult(){
        calculate();
        return firstResult;
    }

    
    public void setFirstResult(int firstResult) {
        calculate();
        this.firstResult = firstResult;
    }

    public String getPageUrl(){
        return pageUrl + "&pageNum=" + pageNum;
    }

    public void setPageUrl(String pageUrl){
        this.pageUrl = pageUrl;
    }

}

// end
