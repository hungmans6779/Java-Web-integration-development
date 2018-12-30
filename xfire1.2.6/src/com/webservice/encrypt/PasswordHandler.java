package com.webservice.encrypt;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.ws.security.WSPasswordCallback;


/*
 *   一般情況下，使用者的密碼存在檔案中或資料庫中，這就需要PasswordHandler 回檔類來根據使用者名稱獲得對應密碼的類別，
 * 它需要實現 org.apache.ws.security.WSPasswordCallback 介面，並透過 WSHandlerConstants.PW_CALLBACK_CALSS 來設定。
 * 
 */

public class PasswordHandler implements CallbackHandler{

  // 儲存使用者名稱和密碼的雜湊表
  private Map <String,String> passwords = new HashMap<String,String>();
  
  
  // 建構子
  public PasswordHandler(){
	passwords.put("admin","admin123");
  } 
	
  
  
  
  
  // 回檔該方法
  public void handle(Callback[] callbacks) throws IOException,UnsupportedCallbackException {
	
	// 獲得密碼回檔方法
	WSPasswordCallback pc = (WSPasswordCallback)callbacks[0];
	
	// 獲得使用者名稱
	String id = pc.getIdentifer();
	System.out.println(PasswordHandler.class.getName()+", handle() execute...");
	System.out.println("id:"+id+" ,password:"+(String) passwords.get(id));
	
	// 根據使用者名稱在雜源湊表中取出密碼，並設定到密碼回檔方法中
	pc.setPassword(passwords.get(id));
	
  } // end handle
  


}