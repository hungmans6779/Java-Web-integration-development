
package com.webservice.xfire.signature;

import java.net.MalformedURLException;

import java.util.Collection;
import java.util.HashMap;
import java.util.Properties;

import javax.xml.namespace.QName;

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

import com.webservice.signature.PasswordHandler;
import com.webservice.xfire.auth.HelloWebServiceAuthClient;
import com.webservice.xfire.dthp.HelloWebServiceDTHPClient;
import com.webservice.xfire.dthp.HelloWebServiceDTHPPortType;


/*
 *  根據 WSDL 產生的用戶端
 *  本例的WSDL： http://3w.eztravel.com.tw:8080/xfire1.2.6/services/HelloWebServiceSignature?wsdl
 *  
 *  ※《數位簽章(Signature)》進行身份證驗證的範例
 *    
 *  如果即沒有SDK，又需要在程式中呼叫Web 服務，那麼如何來實現呢？
 *  MyEclipse 的 Web 服務用戶端產生工具能夠根據WSDL 自動產生呼叫的程式碼。
 *  
 *  
 */

public class HelloWebServiceSignatureClient {

    private static XFireProxyFactory proxyFactory = new XFireProxyFactory();
    private HashMap endpoints = new HashMap();
    private Service service0;

    public HelloWebServiceSignatureClient() {
        create0();
        Endpoint HelloWebServiceSignatureHttpPortEP = service0 .addEndpoint(new QName("http://xfire.webservice.com", "HelloWebServiceSignatureHttpPort"), new QName("http://xfire.webservice.com", "HelloWebServiceSignatureHttpBinding"), "http://3w.eztravel.com.tw:8080/xfire1.2.6/services/HelloWebServiceSignature");
        endpoints.put(new QName("http://xfire.webservice.com", "HelloWebServiceSignatureHttpPort"), HelloWebServiceSignatureHttpPortEP);
        Endpoint HelloWebServiceSignaturePortTypeLocalEndpointEP = service0 .addEndpoint(new QName("http://xfire.webservice.com", "HelloWebServiceSignaturePortTypeLocalEndpoint"), new QName("http://xfire.webservice.com", "HelloWebServiceSignaturePortTypeLocalBinding"), "xfire.local://HelloWebServiceSignature");
        endpoints.put(new QName("http://xfire.webservice.com", "HelloWebServiceSignaturePortTypeLocalEndpoint"), HelloWebServiceSignaturePortTypeLocalEndpointEP);
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
        service0 = asf.create((com.webservice.xfire.signature.HelloWebServiceSignaturePortType.class), props);
        {
            AbstractSoapBinding soapBinding = asf.createSoap11Binding(service0, new QName("http://xfire.webservice.com", "HelloWebServiceSignaturePortTypeLocalBinding"), "urn:xfire:transport:local");
        }
        {
            AbstractSoapBinding soapBinding = asf.createSoap11Binding(service0, new QName("http://xfire.webservice.com", "HelloWebServiceSignatureHttpBinding"), "http://schemas.xmlsoap.org/soap/http");
        }
    }

    public HelloWebServiceSignaturePortType getHelloWebServiceSignatureHttpPort() {
        return ((HelloWebServiceSignaturePortType)(this).getEndpoint(new QName("http://xfire.webservice.com", "HelloWebServiceSignatureHttpPort")));
    }

    public HelloWebServiceSignaturePortType getHelloWebServiceSignatureHttpPort(String url) {
        HelloWebServiceSignaturePortType var = getHelloWebServiceSignatureHttpPort();
        org.codehaus.xfire.client.Client.getInstance(var).setUrl(url);
        return var;
    }

    public HelloWebServiceSignaturePortType getHelloWebServiceSignaturePortTypeLocalEndpoint() {
        return ((HelloWebServiceSignaturePortType)(this).getEndpoint(new QName("http://xfire.webservice.com", "HelloWebServiceSignaturePortTypeLocalEndpoint")));
    }

    public HelloWebServiceSignaturePortType getHelloWebServiceSignaturePortTypeLocalEndpoint(String url) {
        HelloWebServiceSignaturePortType var = getHelloWebServiceSignaturePortTypeLocalEndpoint();
        org.codehaus.xfire.client.Client.getInstance(var).setUrl(url);
        return var;
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static void main(String[] args) {
        
      // 用戶端
      HelloWebServiceSignatureClient client = new HelloWebServiceSignatureClient();
        
      // 建立服務
      HelloWebServiceSignaturePortType service = client.getHelloWebServiceSignatureHttpPort();
      
        
      // 設定客戶端呼叫的屬性
      Client clientService = Client.getInstance(service);  // service:客户端得到的服务对象
      	  
      
      
	  
	  // ***********************************************************************************************
	  //  《數位簽章(Signature)》進行身份證驗證
	  
      // 負責解析 DOM 轉化為StAX
      clientService.addOutHandler(new DOMOutHandler());
	  
	  Properties properties = new Properties();
	  
	  // 設定數位認證類型為數位憑證方式
	  properties.setProperty(WSHandlerConstants.ACTION,WSHandlerConstants.SIGNATURE);
	  
	  // 增加使用者名稱
	  properties.setProperty(WSHandlerConstants.USER,"admin");
	  
	  // 根據使用者名稱查詢出對應的密碼
	  properties.setProperty(WSHandlerConstants.PW_CALLBACK_CLASS,PasswordHandler.class.getName());

	  
	  properties.setProperty(WSHandlerConstants.SIG_PROP_FILE,"META-INF/xfire/outsecurity.properties");
	  
	  
	  properties.setProperty(WSHandlerConstants.SIG_KEY_ID,"IssuerSerial"); 
	  
	  
	  clientService.addOutHandler(new WSS4JOutHandler(properties));
	  // ***********************************************************************************************
	  
	  
      
      // 呼叫服務
      String result = service.sayHello("kevin,Demo WSDL 呼叫方式！！！");
      System.out.println(HelloWebServiceSignatureClient.class.getName());
      System.out.println("result = "+result);
            
      
	  System.exit(0);
    } // end main
    
    
    

}
