package com.helloweenvsfei.i18n;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Vector;

public class Message {
  
  private static final String BUNDLE_NAME="com.helloweenvsfei.i18n.param";
  
  private static final ResourceBundle RESOURCE_BUNDLE=ResourceBundle.getBundle(BUNDLE_NAME);

  private static Properties props;
  
  
  public static String getString(String key){
	 try{
	   return RESOURCE_BUNDLE.getString(key);	 
	 }catch(MissingResourceException e){
	   return "!"+key+"!";	 
	 }
  }
  
  public static String getString(String key,Object ...param){
	try{
      String value=RESOURCE_BUNDLE.getString(key);
      System.out.println("kevintest value = "+value);
      return MessageFormat.format(value,param);
	}catch(MissingResourceException e){
	  return "!"+key+"!";	
	}
  }

  
  
  public static void main(String [] args){
	  
	 System.out.println("================================================================");
	 System.out.println(getString("hello","192.168.1.1","zh_CN","簡體中文"));
	 
	 
	 
	 System.out.println("================================================================");
	 String [] param1={"168.95.1.1","zh_TW","繁體中文"};
	 String value1=getString("hello");
	 System.out.println("kevintest value1 = "+value1);
	 System.out.println(MessageFormat.format(value1,param1));
	 
	 
	 
  }
  
}
