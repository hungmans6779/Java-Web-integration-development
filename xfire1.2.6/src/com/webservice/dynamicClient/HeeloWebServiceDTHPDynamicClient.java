package com.webservice.dynamicClient;

import java.net.URL;
import java.util.Properties;

import org.apache.ws.security.WSConstants;
import org.apache.ws.security.handler.WSHandlerConstants;
import org.codehaus.xfire.client.Client;
import org.codehaus.xfire.security.wss4j.WSS4JOutHandler;
import org.codehaus.xfire.util.dom.DOMOutHandler;

import com.webservice.auth.ClientAuthenticationHandler;
import com.webservice.dthp.PasswordHandler;

/*
 *  【DynamicClient 方式的用戶端】
 *  
 *  ※《WS-Security》進行身份證驗證的範例
 *   
 *  對於服務提供者，可以只提供服務和對應的WSDL，是有些情況下，服務提供者會提供SDK，
 *  這樣開發者就可以使用服務提供者的一些類別。例如 yahoo 的Web 服務不僅提供了服務，
 *  還提供了開發套件 SDK，下面就看一下這種方式的用戶端如何使用。
 * 
 */
public class HeeloWebServiceDTHPDynamicClient {

  public static void main(String[] args) {
	try{
			
	  Client client = new Client(new URL("http://3w.eztravel.com.tw:8080/xfire1.2.6/services/HelloWebServiceDTHP?wsdl"));

	  
	  
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
      
      
      
      
	  Object [] results = client.invoke("sayHello",new Object[] {"kevin.... Demo dynamicClient 呼叫方式！！！"});
	  System.out.println(HeeloWebServiceDTHPDynamicClient.class.getName());
	  System.out.println((String) results[0]);
	  			  
	}catch(Exception e){
	   e.printStackTrace();
	}	 			
  } // end main
  

}
