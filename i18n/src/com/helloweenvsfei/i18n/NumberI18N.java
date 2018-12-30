package com.helloweenvsfei.i18n;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;

public class NumberI18N {

  public static void main(String [] args){
	
	System.out.println("================================================================");  
	String s1=DateFormat.getDateInstance().format(new Date());
	String s2=DateFormat.getTimeInstance().format(new Date());
	String s3=DateFormat.getDateTimeInstance().format(new Date());
    System.out.println("s1 = "+s1);
    System.out.println("s2 = "+s2);
    System.out.println("s3 = "+s3);
    System.out.println("================================================================");
    String n1=NumberFormat.getInstance().format(10000.2345);
    String n2=NumberFormat.getCurrencyInstance().format(23.34);
    String n3=NumberFormat.getPercentInstance().format(2345.0d);
    System.out.println("n1 = "+n1);
    System.out.println("n2 = "+n2);
    System.out.println("n3 = "+n3);
    System.out.println("================================================================");
   
    
  }
  
  
  
}
