package com.webservice.sdk;

import java.net.MalformedURLException;
import java.util.Properties;

import org.apache.ws.security.handler.WSHandlerConstants;
import org.codehaus.xfire.XFireFactory;
import org.codehaus.xfire.client.Client;
import org.codehaus.xfire.client.XFireProxyFactory;
import org.codehaus.xfire.security.wss4j.WSS4JOutHandler;
import org.codehaus.xfire.service.Service;
import org.codehaus.xfire.service.binding.ObjectServiceFactory;
import org.codehaus.xfire.transport.http.CommonsHttpMessageSender;
import org.codehaus.xfire.util.dom.DOMOutHandler;


import com.webservice.encrypt.PasswordHandler;
import com.webservice.xfire.IHelloWebServiceEnc;
import com.webservice.xfire.IHelloWebServiceSignature;

/*
 *  【SDK 方式的用戶端】
 *  
 *  ※《加密(Encryption)》進行身份證驗證的範例
 *   
 *  對於服務提供者，可以只提供服務和對應的WSDL，是有些情況下，服務提供者會提供SDK，
 *  這樣開發者就可以使用服務提供者的一些類別。例如 yahoo 的Web 服務不僅提供了服務，
 *  還提供了開發套件 SDK，下面就看一下這種方式的用戶端如何使用。
 * 
 */
public class HelloWebServiceEncryptClient {

  private static IHelloWebServiceEnc service ; // Service 物件
  
  // 私有建構子 
  private HelloWebServiceEncryptClient(){}
  
  
  
  // 透過 WSDL 取得  IHelloWebServiceSignature 介面，以使用相對應的方法
  public static IHelloWebServiceEnc getService(String serviceURL) throws MalformedURLException{
	
	if(service == null){
	
	  // 建立 IHelloWebServiceDTHP 的服務
	  Service srvcModel = new ObjectServiceFactory().create(IHelloWebServiceEnc.class);
	  
	  // 建立 XFire 對象
	  XFireProxyFactory factory = new XFireProxyFactory(XFireFactory.newInstance().getXFire());
	 
	  // 呼叫 Web 服務
	  service = (IHelloWebServiceEnc) factory.create(srvcModel,serviceURL);
	  
	  
	  // 設定客戶端呼叫的屬性
	  Client client = Client.getInstance(service);
	  
	  // ***********************************************************************************************
	  //  《數位簽章(Signature)》進行身份證驗證
	  
      // 負責解析 DOM 轉化為StAX
	  client.addOutHandler(new DOMOutHandler());
	  
	  Properties properties = new Properties();
	  
	  // 設定數位認證類型為數位憑證方式
	  properties.setProperty(WSHandlerConstants.ACTION,WSHandlerConstants.ENCRYPT);
	  
	  // 增加使用者名稱
	  properties.setProperty(WSHandlerConstants.ENCRYPTION_USER,"admin");
	  
	  // 根據使用者名稱查詢出對應的密碼
	  properties.setProperty(WSHandlerConstants.PW_CALLBACK_CLASS,PasswordHandler.class.getName());

	  
	  properties.setProperty(WSHandlerConstants.ENC_PROP_FILE,"META-INF/xfire/outsecurity.properties");
	  
	  
	 //  properties.setProperty(WSHandlerConstants.SIG_KEY_ID,"IssuerSerial"); 
	  
	  
	  client.addOutHandler(new WSS4JOutHandler(properties));
	  // ***********************************************************************************************
	  
 
	  client.setProperty(CommonsHttpMessageSender.HTTP_TIMEOUT,"300");
	  client.setProperty(CommonsHttpMessageSender.DISABLE_KEEP_ALIVE,"true");
	  client.setProperty(CommonsHttpMessageSender.DISABLE_EXPECT_CONTINUE,"true");
	  
	  // 如果需要設定代理
	  client.setProperty(CommonsHttpMessageSender.HTTP_PROXY_HOST,"10.10.1.71");
	  client.setProperty(CommonsHttpMessageSender.HTTP_PROXY_PORT,"8080");
	} // end if(service == null){
	
	return service;
  }  // end  getService
  
  
  
  
  
  
  
  
  public static void main(String[] args) {
	  
	try{
	  IHelloWebServiceEnc service = HelloWebServiceEncryptClient.getService("http://3w.eztravel.com.tw:8080/xfire1.2.6/services/HelloWebServiceEnc");	
	  			  
	  System.out.println("***************************************************");
	  System.out.println(HelloWebServiceEncryptClient.class.getName());
	  String result = service.sayHello("kevin,Demo SDK 呼叫方式！！！");  
	  System.out.println("result = "+result);
	  System.out.println("***************************************************");	  
	}catch(MalformedURLException e){
	  e.printStackTrace();	
	}
	
  } // end main
  
  

}
