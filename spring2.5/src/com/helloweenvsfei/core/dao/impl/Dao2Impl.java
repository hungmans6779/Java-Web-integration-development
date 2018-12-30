package com.helloweenvsfei.core.dao.impl;

import java.util.Calendar;
import com.helloweenvsfei.core.dao.IDao2;


// 實 現 IDao2 介面
public class Dao2Impl implements IDao2 {

  // 實現 sayHello() 
  public String sayHello(String name){
		
    int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
    if(hour<6){
	  return "凌晨好,"+name;
    }else if(hour < 12){
	  return "早上好,"+name;
    }else if(hour<13){
	  return "中午好,"+name;	
    }else if(hour < 18){
	  return "下午好,"+name;		
    }else{
	  return "晚上好,"+name;	
    }
		
  } // end public String sayHello(String name) 

}
