package com.helloweenvsfei.hibernate.util;

import java.sql.Date;

import java.sql.Time;
import java.text.NumberFormat;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import com.helloweenvsfei.hibernate.bean.Employee;

public class StringUtil {

	
  // 亂數產生器
  private static Random random = new Random();
  
  
  // 隨機產生 Employee 資料
  public static Employee getRandomEmployee(){
	 
	String name = "";  // 姓名，隨機產生
	// 產生 2、3 個中文字
	for(int i=0,n=2+(random.nextInt(8)==0?0:1);i < n;i++){
	  try{
	    name += getChineseCharacter(System.currentTimeMillis()+i);  // 傳回隨機中文字
	  }catch(Exception e){
		e.printStackTrace();  
	  }
	} // end for(int i=0,n=2+(random.nextInt(8)==0?0:1);i < n;i++){
	
	int year = 1950 + random.nextInt(40);               // 隨機年：1950 - 1990
	int month = 1 + random.nextInt(12);                 // 隨機月：1-12
	int day = 1 +random.nextInt(31);                    // 隨機日：1-31
	int hh = 7 + random.nextInt(2);                     // 隨機小時：7～9
	int mm = random.nextInt(60);                        // 隨機分鐘：0～59
	int ss = random.nextInt(60);                        // 隨機秒     ：0～59
	int hhh = 16 + random.nextInt(2);                   // 隨機小時：16～18
	
	double salary = 1000 + random.nextDouble() * 5000;  // 隨機薪水:1000 ～ 6000
	
	System.out.println("name = "+name);
	System.out.println("year = "+year+",month = "+month+",day = "+day);
	System.out.println("hh   = "+hh+",mm = "+mm+",ss = "+ss+",hhh = "+hhh);
	
	Employee employee = new Employee();
	employee.setName(name);
	employee.setAge(20+random.nextInt(40));                       // 設定隨機年齡：20-60
	employee.setBirthday(Date.valueOf(year+"-"+month+"-"+day));   // 設定隨機生日 
	employee.setDateCreated(new java.util.Date());                // 建立時間
	employee.setDescription("");                                  // 備註
	employee.setDisabled(random.nextInt(10)==9);                  // 是否被阻止，10% 的機率
	employee.setSex(random.nextInt(3)==2?"女":"男");              // 姓名，男女比例： 2:1
	employee.setStartTime(Time.valueOf(hh+":"+mm+":"+ss));        // 隨機上班時間
	employee.setEndTime(Time.valueOf(hhh+":"+mm+":"+ss));         // 隨機下班時間
	employee.setSalary(salary);
	
	
	return employee;
  } // end getRandomEmployee
  
  
  
  
  
  
  
  // 傳回隨機中文字
  private static String getChineseCharacter(long seed) throws Exception{
	String str = null;                             // 儲存結果
	int highPos,lowPos;                            // 高位元，低位元
	
	Random random = new Random(seed);              // 亂數產生器
	highPos = 176 + Math.abs(random.nextInt(39));  // 計算高位元
	lowPos = 161 + Math.abs(random.nextInt(93));   // 計算低位元
	System.out.println(StringUtil.class.getName()+",seed = "+seed+",highPos = "+highPos+",lowPos = "+lowPos);
	
	byte [] b = new byte[2];                       // 轉化為 B 類型
	b[0] = (new Integer(highPos)).byteValue();     // 高位元組
	b[1] = (new Integer(lowPos)).byteValue();      // 低位元組
	str = new String(b,"GBK");                     // 轉化為中文字
	
	return str;
  } // end getChineseCharacter
  
  
  
  

  public static boolean isNull(Object obj) {
	return obj == null;
  }

  
  public static boolean isNull(String obj) {
	return obj == null || obj.trim().length() == 0;
  }
  
  
  
  public static String getURL(HttpServletRequest request){
	String requestURI = request.getRequestURI();
	String queryString = request.getQueryString();
	String url = requestURI +"?"+filterQueryString(queryString);
    
    return url;
  } // en 
  
  
  
  
  
  
  // 使用正規運算式過濾指定參數
  public static String filterQueryString(String queryString){
	if(queryString==null)
	  return "";

	// 過濾 sort
	queryString = queryString.replace("[^&]sort=[^&]*","");
	
	// 過濾 order
	queryString = queryString.replace("[^&]order=[^&]*","");
	
	// 過濾 action
	queryString = queryString.replace("[^&]action=[^&]*","");
	
	// 過濾重複 &&
	queryString = queryString.replace("&{2,}","&");

	// 過濾開始字元 &
	queryString = queryString.replace("^&","");
	
	// 過濾結束字元 &
	queryString = queryString.replace("&$","");
	
	return queryString;  
  } // end filterQueryString(String queryString){
  
  
  
  
  
  
  public static void main(String args[]){  
	Employee e1 = getRandomEmployee();
	Employee e2 = getRandomEmployee();
	
	System.out.println("亂數產生  e1 name = "+e1.getName());
	System.out.println("亂數產生 e2 name = "+e2.getName());
  } // end main
  
  
  

  
  
}
