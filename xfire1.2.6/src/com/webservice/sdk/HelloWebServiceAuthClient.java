package com.webservice.sdk;

import java.net.MalformedURLException;

import org.codehaus.xfire.XFireFactory;
import org.codehaus.xfire.client.Client;
import org.codehaus.xfire.client.XFireProxyFactory;
import org.codehaus.xfire.service.Service;
import org.codehaus.xfire.service.binding.ObjectServiceFactory;
import org.codehaus.xfire.transport.http.CommonsHttpMessageSender;

import com.webservice.auth.ClientAuthenticationHandler;
import com.webservice.xfire.IHelloWebServiceAuth;


/*
 *  【SDK 方式的用戶端】
 *  
 *   ※《Web 服務安全》SOAP Header 中進行身份驗證的範例
 *   
 *  對於服務提供者，可以只提供服務和對應的WSDL，是有些情況下，服務提供者會提供SDK，
 *  這樣開發者就可以使用服務提供者的一些類別。例如 yahoo 的Web 服務不僅提供了服務，
 *  還提供了開發套件 SDK，下面就看一下這種方式的用戶端如何使用。
 * 
 */
public class HelloWebServiceAuthClient {


  private static IHelloWebServiceAuth service;   // Service 物件
	 
	  
  // 私有建構子
  private HelloWebServiceAuthClient(){}
	  
	  
  
	  
	  
  // 透過 WSDL 取得 IHelloWebServiceAuth 介面，以使用相對應的方法
  public static IHelloWebServiceAuth getService(String serviceURL) throws MalformedURLException {
		  	  
	if(service == null){
	    	
	  // 建立IHelloWebService的服務
      Service srvcModel = new ObjectServiceFactory().create(IHelloWebServiceAuth.class);
			
	  // 建立XFire對像
	  XFireProxyFactory factory = new XFireProxyFactory(XFireFactory.newInstance().getXFire());
			
	  // 呼叫Web服務
	  service = (IHelloWebServiceAuth) factory.create(srvcModel,serviceURL);

	  
	  // 設定客戶端呼叫的屬性
	  Client client = Client.getInstance(service);
		  
	  // 註冊 soap 訊息中增加身份資訊
	  client.addOutHandler(new ClientAuthenticationHandler("admin","1234"));
		  
       
	  client.setProperty(CommonsHttpMessageSender.HTTP_TIMEOUT,"300");
	  client.setProperty(CommonsHttpMessageSender.DISABLE_KEEP_ALIVE,"true");
	  client.setProperty(CommonsHttpMessageSender.DISABLE_EXPECT_CONTINUE,"true");
			
	  // 如果需要設定代理
	  client.setProperty(CommonsHttpMessageSender.HTTP_PROXY_HOST,"10.10.1.71");
	  client.setProperty(CommonsHttpMessageSender.HTTP_PROXY_PORT,"8080");
			
	} // end if(service == null){
		  
	return service;
  } // end getService
	  
	  
  
  
  
	  
	  
	  
	  
  public static void main(String[] args) {

	try{
			
	  // 呼叫用戶端
	  IHelloWebServiceAuth service = HelloWebServiceAuthClient.getService("http://3w.eztravel.com.tw:8080/xfire1.2.6/services/HelloWebServiceAuth");
	  
	  
	  System.out.println("***************************************************");
	  System.out.println(HelloWebServiceAuthClient.class.getName());
	  String result = service.sayHello("kevin,Demo SDK 呼叫方式！！！");  
	  System.out.println("result = "+result);
	  System.out.println("***************************************************");
	  
	}catch(MalformedURLException e){
	  e.printStackTrace(); 	
	}
		  
  } // end main

  
}


