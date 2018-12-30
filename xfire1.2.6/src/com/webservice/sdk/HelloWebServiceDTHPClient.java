package com.webservice.sdk;

import java.net.MalformedURLException;

import java.util.Properties;

import org.apache.ws.security.WSConstants;
import org.apache.ws.security.handler.WSHandlerConstants;
import org.codehaus.xfire.XFireFactory;
import org.codehaus.xfire.client.Client;
import org.codehaus.xfire.client.XFireProxyFactory;
import org.codehaus.xfire.security.wss4j.WSS4JOutHandler;
import org.codehaus.xfire.service.Service;
import org.codehaus.xfire.service.binding.ObjectServiceFactory;
import org.codehaus.xfire.transport.http.CommonsHttpMessageSender;
import org.codehaus.xfire.util.dom.DOMOutHandler;

import com.webservice.dthp.PasswordHandler;
import com.webservice.xfire.IHelloWebServiceDTHP;

/*
 *  【SDK 方式的用戶端】
 *  
 *  ※《WS-Security》進行身份證驗證的範例
 *   
 *  對於服務提供者，可以只提供服務和對應的WSDL，是有些情況下，服務提供者會提供SDK，
 *  這樣開發者就可以使用服務提供者的一些類別。例如 yahoo 的Web 服務不僅提供了服務，
 *  還提供了開發套件 SDK，下面就看一下這種方式的用戶端如何使用。
 * 
 */
public class HelloWebServiceDTHPClient {

  private static IHelloWebServiceDTHP service; // Service 物件
	
  
  // 私有建構子
  private HelloWebServiceDTHPClient(){
	  
  }
  
  
  // 透過 WSDL 取得  IHelloWebServiceDTHP 介面，以使用相對應的方法
  public static IHelloWebServiceDTHP getService(String serviceURL) throws MalformedURLException{
	
	if(service == null){
	
	  // 建立 IHelloWebServiceDTHP 的服務
	  Service srvcModel = new ObjectServiceFactory().create(IHelloWebServiceDTHP.class);
	  
	  // 建立 XFire 對象
	  XFireProxyFactory factory = new XFireProxyFactory(XFireFactory.newInstance().getXFire());
	 
	  // 呼叫 Web 服務
	  service = (IHelloWebServiceDTHP) factory.create(srvcModel,serviceURL);
	  
	  
	  // 設定客戶端呼叫的屬性
	  Client client = Client.getInstance(service);
 
	  client.setProperty(CommonsHttpMessageSender.HTTP_TIMEOUT,"300");
	  client.setProperty(CommonsHttpMessageSender.DISABLE_KEEP_ALIVE,"true");
	  client.setProperty(CommonsHttpMessageSender.DISABLE_EXPECT_CONTINUE,"true");
	  
	  // 如果需要設定代理
	  client.setProperty(CommonsHttpMessageSender.HTTP_PROXY_HOST,"10.10.1.71");
	  client.setProperty(CommonsHttpMessageSender.HTTP_PROXY_PORT,"8080");
	  
	  

	  
	  // ********************************************************************************************
	  // WS-Security  (WSS4J) 進行身份證驗證(開始)
	  // ********************************************************************************************
	  // 負責解析DOM轉化為StAX
      client.addOutHandler(new DOMOutHandler());
      
      Properties properties = new Properties();

      // 設定認證類型為使用者名稱密碼方式
      properties.setProperty(WSHandlerConstants.ACTION,WSHandlerConstants.USERNAME_TOKEN);
      
      // 設定使用者名稱
      properties.setProperty(WSHandlerConstants.USER,"admin");   
      
      // 根據使用者名稱查出對應的密碼
      properties.setProperty(WSHandlerConstants.PW_CALLBACK_CLASS,PasswordHandler.class.getName());
      
      // 設定密碼為Base64 寫程式的 SHA-1 散列值方式，可以設定密碼的傳輸安全
      // 如果設定為明文，值為 WSConstants.PW_TEXT
      // properties.setProperty(WSHandlerConstants.PASSWORD_TYPE,WSConstants.PW_TEXT);
      properties.setProperty(WSHandlerConstants.PASSWORD_TYPE,WSConstants.PW_DIGEST);   
  
      // 負責組裝 WS-Security 規範的資訊
      client.addOutHandler(new WSS4JOutHandler(properties));	        
      
      // WS-Security  (WSS4J) 進行身份證驗證(結束)
      // ********************************************************************************************
      
      
      
      
	} // end if(service == null){
	
	return service;
  } 
  
  
  
  
  
  
  public static void main(String[] args) {
	
	try{
	  IHelloWebServiceDTHP service = HelloWebServiceDTHPClient.getService("http://3w.eztravel.com.tw:8080/xfire1.2.6/services/HelloWebServiceDTHP");	
	  
	  System.out.println("***************************************************");
	  System.out.println(HelloWebServiceDTHPClient.class.getName());
	  String result = service.sayHello("kevin,Demo SDK 呼叫方式！！！");  
	  System.out.println("result = "+result);
	  System.out.println("***************************************************");
		
	}catch(Exception e){
	  e.printStackTrace();	
	}
	
  } // end main

  
}
