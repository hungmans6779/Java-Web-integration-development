package com.helloweenvsfei.struts2.convertor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Map;

import ognl.DefaultTypeConverter;


/*
 *  配合 /WEB-INF/classes/xwork-conversion.properties 的設定檔使用
 *  該轉換器的類別直接繼承 DefaultTypeConverter 類別並實現 convertValue() 方法就可以了。
 *　convertValue() 有3個參數，參數value 為待轉換的資料，參數 toType 為要換成的類型。
 *  注意 JSP 傳送資料時，參數 value 為 request.getParmaeterValues(String name) 傳回的 String[] 類型物件，而不是 String。
 */
public class DateTimeConvertor extends DefaultTypeConverter{

  // 日期格式化器
  private DateFormat [] dateFormat = {
     new SimpleDateFormat("yyyy-MM-dd"),
     new SimpleDateFormat("yyyy/MM/dd"),
     new SimpleDateFormat("yy-MM-dd"),
  };
	
  
  // 時間格式化器
  private DateFormat [] timeFormat = {
	new SimpleDateFormat("HH:mm:ssss"),
	new SimpleDateFormat("HH:mm"),
  };
  
  
  
  public Object convertValue(Map context,Object value,Class toType){
	
	if(toType.equals(java.sql.Date.class)){           // 如果是  java.sql.Date 類型	
	  System.out.println(DateTimeConvertor.class.getName()+",convertValue()...,toType => java.sql.Date ,value = "+Arrays.toString((String[])value));
		
	  String [] parameterValues = (String [])value;   // 原始字串資料
	  for(DateFormat format:dateFormat){              // 使用3種日期格式化器轉換日期
		try{
		  return new java.sql.Date(format.parse(parameterValues[0]).getTime());	
		}catch(Exception e){}
	  }
	}else if(toType.equals(java.sql.Time.class)){     // 如果是 java.sql.Time 類型 
	  System.out.println(DateTimeConvertor.class.getName()+",convertValue()...,toType => java.sql.Time ,value = "+Arrays.toString((String[])value));
	  
	  String [] parameterValues = (String[])value;    // 原始字串資料
	  for(DateFormat format:timeFormat){              // 使用2種時間格式化器轉換時間
		try{
		  return new java.sql.Time(format.parse(parameterValues[0]).getTime());	
		}catch(Exception e){}
	  }
	}else if(toType.equals(java.util.Date.class)){    // 如果是  java.util.Date 類型
	  System.out.println(DateTimeConvertor.class.getName()+",convertValue()...,toType => java.util.Date ,value = "+Arrays.toString((String[])value));
		
	  String [] parameterValues = (String[])value;    // 原始字串資料
	  for(DateFormat format:dateFormat){              // 使用3種日期格式化器轉換日期
		try{
		  return format.parse(parameterValues[0]);	 
		}catch(Exception e){}
	  }
	}else if(toType.equals(String.class)){            // 如果是字串
	  System.out.println(DateTimeConvertor.class.getName()+",convertValue()...,toType => String ,value = "+value);
		
	  if(value instanceof java.sql.Date){
	  }else if(value instanceof java.sql.Time){  
	  }else if(value instanceof java.util.Date){
	    return dateFormat[0].format((java.util.Date)value); // 將 Date 轉換為 String	  
	  }
	}
	
	 System.out.println(DateTimeConvertor.class.getName()+",convertValue()...");
	 return super.convertValue(context, value, toType); // 否則呼叫父類別的方法
  } // end convertValue
 
 
  
  
  
  /**
   * @param args
   */
  public static void main(String[] args) {

  }

  
  
  
}
