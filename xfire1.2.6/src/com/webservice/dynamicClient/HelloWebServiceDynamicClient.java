package com.webservice.dynamicClient;

import java.net.URL;


import org.codehaus.xfire.client.Client;

import com.webservice.auth.ClientAuthenticationHandler;

/*
 *  【DynamicClient 方式的用戶端】
 *  
 *  ※ 《一般呼叫》的範例
 *  
 *  對於服務提供者，可以只提供服務和對應的WSDL，是有些情況下，服務提供者會提供SDK，
 *  這樣開發者就可以使用服務提供者的一些類別。例如 yahoo 的Web 服務不僅提供了服務，
 *  還提供了開發套件 SDK，下面就看一下這種方式的用戶端如何使用。
 * 
 */
public class HelloWebServiceDynamicClient {


  public static void main(String[] args) {
	try{
		
	  Client client = new Client(new URL("http://3w.eztravel.com.tw:8080/xfire1.2.6/services/HelloWebService?wsdl"));
	  
	  Object [] results = client.invoke("sayHello",new Object[] {"kevin.... Demo dynamicClient 呼叫方式！！！"});
	  System.out.println(HelloWebServiceDynamicClient.class.getName());
	  System.out.println((String) results[0]);
	  
	}catch(Exception e){
	  e.printStackTrace();
    }	  
  } // end main

}
