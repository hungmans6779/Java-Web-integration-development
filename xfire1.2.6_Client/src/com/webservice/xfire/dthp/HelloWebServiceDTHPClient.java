
package com.webservice.xfire.dthp;

import java.net.MalformedURLException;

import java.util.Collection;
import java.util.HashMap;
import java.util.Properties;

import javax.xml.namespace.QName;

import org.apache.ws.security.WSConstants;
import org.apache.ws.security.handler.WSHandlerConstants;
import org.codehaus.xfire.XFireRuntimeException;
import org.codehaus.xfire.aegis.AegisBindingProvider;
import org.codehaus.xfire.annotations.AnnotationServiceFactory;
import org.codehaus.xfire.annotations.jsr181.Jsr181WebAnnotations;
import org.codehaus.xfire.client.Client;
import org.codehaus.xfire.client.XFireProxyFactory;
import org.codehaus.xfire.jaxb2.JaxbTypeRegistry;
import org.codehaus.xfire.security.wss4j.WSS4JOutHandler;
import org.codehaus.xfire.service.Endpoint;
import org.codehaus.xfire.service.Service;
import org.codehaus.xfire.soap.AbstractSoapBinding;
import org.codehaus.xfire.transport.TransportManager;
import org.codehaus.xfire.util.dom.DOMOutHandler;

import com.webservice.auth.ClientAuthenticationHandler;
import com.webservice.dthp.PasswordHandler;
import com.webservice.xfire.auth.HelloWebServiceAuthClient;
import com.webservice.xfire.auth.HelloWebServiceAuthPortType;


/*
 *  根據 WSDL 產生的用戶端
 *  本例的WSDL： http://3w.eztravel.com.tw:8080/xfire1.2.6/services/HelloWebServiceDTHP?wsdl 
 *  
 *  ※《WS-Security》進行身份證驗證的範例
 *    
 *  如果即沒有SDK，又需要在程式中呼叫Web 服務，那麼如何來實現呢？
 *  MyEclipse 的 Web 服務用戶端產生工具能夠根據WSDL 自動產生呼叫的程式碼。
 *  
 *  
 */
public class HelloWebServiceDTHPClient {

    private static XFireProxyFactory proxyFactory = new XFireProxyFactory();
    private HashMap endpoints = new HashMap();
    private Service service0;

    public HelloWebServiceDTHPClient() {
        create0();
        Endpoint HelloWebServiceDTHPHttpPortEP = service0 .addEndpoint(new QName("http://xfire.webservice.com", "HelloWebServiceDTHPHttpPort"), new QName("http://xfire.webservice.com", "HelloWebServiceDTHPHttpBinding"), "http://3w.eztravel.com.tw:8080/xfire1.2.6/services/HelloWebServiceDTHP");
        endpoints.put(new QName("http://xfire.webservice.com", "HelloWebServiceDTHPHttpPort"), HelloWebServiceDTHPHttpPortEP);
        Endpoint HelloWebServiceDTHPPortTypeLocalEndpointEP = service0 .addEndpoint(new QName("http://xfire.webservice.com", "HelloWebServiceDTHPPortTypeLocalEndpoint"), new QName("http://xfire.webservice.com", "HelloWebServiceDTHPPortTypeLocalBinding"), "xfire.local://HelloWebServiceDTHP");
        endpoints.put(new QName("http://xfire.webservice.com", "HelloWebServiceDTHPPortTypeLocalEndpoint"), HelloWebServiceDTHPPortTypeLocalEndpointEP);
    }

    public Object getEndpoint(Endpoint endpoint) {
        try {
            return proxyFactory.create((endpoint).getBinding(), (endpoint).getUrl());
        } catch (MalformedURLException e) {
            throw new XFireRuntimeException("Invalid URL", e);
        }
    }

    public Object getEndpoint(QName name) {
        Endpoint endpoint = ((Endpoint) endpoints.get((name)));
        if ((endpoint) == null) {
            throw new IllegalStateException("No such endpoint!");
        }
        return getEndpoint((endpoint));
    }

    public Collection getEndpoints() {
        return endpoints.values();
    }

    private void create0() {
        TransportManager tm = (org.codehaus.xfire.XFireFactory.newInstance().getXFire().getTransportManager());
        HashMap props = new HashMap();
        props.put("annotations.allow.interface", true);
        AnnotationServiceFactory asf = new AnnotationServiceFactory(new Jsr181WebAnnotations(), tm, new AegisBindingProvider(new JaxbTypeRegistry()));
        asf.setBindingCreationEnabled(false);
        service0 = asf.create((com.webservice.xfire.dthp.HelloWebServiceDTHPPortType.class), props);
        {
            AbstractSoapBinding soapBinding = asf.createSoap11Binding(service0, new QName("http://xfire.webservice.com", "HelloWebServiceDTHPPortTypeLocalBinding"), "urn:xfire:transport:local");
        }
        {
            AbstractSoapBinding soapBinding = asf.createSoap11Binding(service0, new QName("http://xfire.webservice.com", "HelloWebServiceDTHPHttpBinding"), "http://schemas.xmlsoap.org/soap/http");
        }
    }

    public HelloWebServiceDTHPPortType getHelloWebServiceDTHPHttpPort() {
        return ((HelloWebServiceDTHPPortType)(this).getEndpoint(new QName("http://xfire.webservice.com", "HelloWebServiceDTHPHttpPort")));
    }

    public HelloWebServiceDTHPPortType getHelloWebServiceDTHPHttpPort(String url) {
        HelloWebServiceDTHPPortType var = getHelloWebServiceDTHPHttpPort();
        org.codehaus.xfire.client.Client.getInstance(var).setUrl(url);
        return var;
    }

    public HelloWebServiceDTHPPortType getHelloWebServiceDTHPPortTypeLocalEndpoint() {
        return ((HelloWebServiceDTHPPortType)(this).getEndpoint(new QName("http://xfire.webservice.com", "HelloWebServiceDTHPPortTypeLocalEndpoint")));
    }

    public HelloWebServiceDTHPPortType getHelloWebServiceDTHPPortTypeLocalEndpoint(String url) {
        HelloWebServiceDTHPPortType var = getHelloWebServiceDTHPPortTypeLocalEndpoint();
        org.codehaus.xfire.client.Client.getInstance(var).setUrl(url);
        return var;
    }

    
    
    
    
    
    public static void main(String[] args) {
         
      // 用戶端
      HelloWebServiceDTHPClient client = new HelloWebServiceDTHPClient();
          
      // 建立服務
      HelloWebServiceDTHPPortType service = client.getHelloWebServiceDTHPHttpPort();
          

      // 設定客戶端呼叫的屬性
      Client clientService = Client.getInstance(service);  // service:客户端得到的服务对象
    	  
      
      
      

	  // ********************************************************************************************
	  // WS-Security  (WSS4J) 進行身份證驗證(開始)
	  // ********************************************************************************************
	  // 負責解析DOM轉化為StAX
      clientService.addOutHandler(new DOMOutHandler());
      
      
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
      clientService.addOutHandler(new WSS4JOutHandler(properties));	        
      
      // WS-Security  (WSS4J) 進行身份證驗證(結束)
      // ********************************************************************************************
      
      
      
      
      

      // 呼叫服務
      String result = service.sayHello("kevin,Demo WSDL 呼叫方式！！！");
      System.out.println(HelloWebServiceAuthClient.class.getName());
      System.out.println("result = "+result);
            
     
      System.exit(0);
      
    } // end main
    
    
    
    

}
