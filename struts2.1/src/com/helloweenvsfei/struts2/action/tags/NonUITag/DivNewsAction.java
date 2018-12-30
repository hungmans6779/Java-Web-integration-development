package com.helloweenvsfei.struts2.action.tags.NonUITag;

import java.util.ArrayList;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;


public class DivNewsAction {

  private static String [] ALL_NEWS = {
	"中國將舉辦2008年奧運會, 開幕式日期 2008年8月8日",
	"繼水立方後, 又一奧運建築鳥巢體育館日前竣工", 
	"嫦娥探月衛星成功發射升空", 
	"神舟六號號宇宙飛船勝利返航",
	"中國A股股市超跌反彈",   
  };
	
  
  private String key;
  private List<String> news = new ArrayList<String>();
  
  
  
  // 主方法
  public String execute(){
	key = (key==null)?"":key;

	// 檢查新聞標題
	for(String n:ALL_NEWS){
	  if(n.contains(key)){ // 包含關鍵字 
		news.add(n); 
	  }
	} // end for(String n:ALL_NEWS){

	return "success";  
  } // end execute() 


  
  
  public String getKey() {
	return key;
  }

  public void setKey(String key) {
	this.key = key;
  }

  public List<String> getNews() {
	return news;
  }

  public void setNews(List<String> news) {
	this.news = news;
  }
  
  
  
  
  
  
  
}
