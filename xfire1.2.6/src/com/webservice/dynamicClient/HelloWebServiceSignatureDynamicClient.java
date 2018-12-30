package com.webservice.dynamicClient;

import java.net.URL;
import java.util.Properties;

import org.apache.ws.security.handler.WSHandlerConstants;
import org.codehaus.xfire.client.Client;
import org.codehaus.xfire.security.wss4j.WSS4JOutHandler;
import org.codehaus.xfire.util.dom.DOMOutHandler;

import com.webservice.signature.PasswordHandler;


/*
 *  【DynamicClient 方式的用戶端】
 *  
 *  ※ 《數位簽章(Signature)》進行身份證驗證的範例
 *  
 *  對於服務提供者，可以只提供服務和對應的WSDL，是有些情況下，服務提供者會提供SDK，
 *  這樣開發者就可以使用服務提供者的一些類別。例如 yahoo 的Web 服務不僅提供了服務，
 *  還提供了開發套件 SDK，下面就看一下這種方式的用戶端如何使用。
 * 
 */
public class HelloWebServiceSignatureDynamicClient {


  public static void main(String[] args) {
	try{		
	  Client client = new Client(new URL(" http://3w.eztravel.com.tw:8080/xfire1.2.6/services/HelloWebServiceSignature?wsdl"));
			  
	  
	  // ***********************************************************************************************
	  //  《數位簽章(Signature)》進行身份證驗證
	  
      // 負責解析 DOM 轉化為StAX
	  client.addOutHandler(new DOMOutHandler());
	  
	  Properties properties = new Properties();
	  
	  // 設定數位認證類型為數位憑證方式
	  properties.setProperty(WSHandlerConstants.ACTION,WSHandlerConstants.SIGNATURE);
	  
	  // 增加使用者名稱
	  properties.setProperty(WSHandlerConstants.USER,"admin");
	  
	  // 根據使用者名稱查詢出對應的密碼
	  properties.setProperty(WSHandlerConstants.PW_CALLBACK_CLASS,PasswordHandler.class.getName());

	  
	  properties.setProperty(WSHandlerConstants.SIG_PROP_FILE,"META-INF/xfire/outsecurity.properties");
	  
	  
	  properties.setProperty(WSHandlerConstants.SIG_KEY_ID,"IssuerSerial"); 
	  
	  
	  client.addOutHandler(new WSS4JOutHandler(properties));
	  // ***********************************************************************************************
	  
	  
 
	  
	  
	  Object [] results = client.invoke("sayHello",new Object[] {"kevin.... Demo dynamicClient 呼叫方式！！！"});
	  System.out.println(HelloWebServiceSignatureDynamicClient.class.getName());
	  System.out.println((String) results[0]);
			  
	}catch(Exception e){
	  e.printStackTrace();
	}	  
  }

}
