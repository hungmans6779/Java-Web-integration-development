
package com.webservice.xfire.auth;

import java.net.MalformedURLException;
import java.util.Collection;
import java.util.HashMap;
import javax.xml.namespace.QName;
import org.codehaus.xfire.XFireRuntimeException;
import org.codehaus.xfire.aegis.AegisBindingProvider;
import org.codehaus.xfire.annotations.AnnotationServiceFactory;
import org.codehaus.xfire.annotations.jsr181.Jsr181WebAnnotations;
import org.codehaus.xfire.client.Client;
import org.codehaus.xfire.client.XFireProxyFactory;
import org.codehaus.xfire.jaxb2.JaxbTypeRegistry;
import org.codehaus.xfire.service.Endpoint;
import org.codehaus.xfire.service.Service;
import org.codehaus.xfire.soap.AbstractSoapBinding;
import org.codehaus.xfire.transport.TransportManager;

import com.webservice.auth.ClientAuthenticationHandler;

/*
 *  根據 WSDL 產生的用戶端
 *  本例的WSDL： http://3w.eztravel.com.tw:8080/xfire1.2.6/services/HelloWebServiceAuth?wsdl  
 *  
 *  ※《Web 服務安全》SOAP Header 中進行身份驗證的範例
 *    
 *  如果即沒有SDK，又需要在程式中呼叫Web 服務，那麼如何來實現呢？
 *  MyEclipse 的 Web 服務用戶端產生工具能夠根據WSDL 自動產生呼叫的程式碼。
 *  
 *  
 */
public class HelloWebServiceAuthClient {

    private static XFireProxyFactory proxyFactory = new XFireProxyFactory();
    private HashMap endpoints = new HashMap();
    private Service service0;

    public HelloWebServiceAuthClient() {
        create0();
        Endpoint HelloWebServiceAuthHttpPortEP = service0 .addEndpoint(new QName("http://xfire.webservice.com", "HelloWebServiceAuthHttpPort"), new QName("http://xfire.webservice.com", "HelloWebServiceAuthHttpBinding"), "http://3w.eztravel.com.tw:8080/xfire1.2.6/services/HelloWebServiceAuth");
        endpoints.put(new QName("http://xfire.webservice.com", "HelloWebServiceAuthHttpPort"), HelloWebServiceAuthHttpPortEP);
        Endpoint HelloWebServiceAuthPortTypeLocalEndpointEP = service0 .addEndpoint(new QName("http://xfire.webservice.com", "HelloWebServiceAuthPortTypeLocalEndpoint"), new QName("http://xfire.webservice.com", "HelloWebServiceAuthPortTypeLocalBinding"), "xfire.local://HelloWebServiceAuth");
        endpoints.put(new QName("http://xfire.webservice.com", "HelloWebServiceAuthPortTypeLocalEndpoint"), HelloWebServiceAuthPortTypeLocalEndpointEP);
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
        service0 = asf.create((com.webservice.xfire.auth.HelloWebServiceAuthPortType.class), props);
        {
            AbstractSoapBinding soapBinding = asf.createSoap11Binding(service0, new QName("http://xfire.webservice.com", "HelloWebServiceAuthPortTypeLocalBinding"), "urn:xfire:transport:local");
        }
        {
            AbstractSoapBinding soapBinding = asf.createSoap11Binding(service0, new QName("http://xfire.webservice.com", "HelloWebServiceAuthHttpBinding"), "http://schemas.xmlsoap.org/soap/http");
        }
    }

    public HelloWebServiceAuthPortType getHelloWebServiceAuthHttpPort() {
        return ((HelloWebServiceAuthPortType)(this).getEndpoint(new QName("http://xfire.webservice.com", "HelloWebServiceAuthHttpPort")));
    }

    public HelloWebServiceAuthPortType getHelloWebServiceAuthHttpPort(String url) {
        HelloWebServiceAuthPortType var = getHelloWebServiceAuthHttpPort();
        org.codehaus.xfire.client.Client.getInstance(var).setUrl(url);
        return var;
    }

    public HelloWebServiceAuthPortType getHelloWebServiceAuthPortTypeLocalEndpoint() {
        return ((HelloWebServiceAuthPortType)(this).getEndpoint(new QName("http://xfire.webservice.com", "HelloWebServiceAuthPortTypeLocalEndpoint")));
    }

    public HelloWebServiceAuthPortType getHelloWebServiceAuthPortTypeLocalEndpoint(String url) {
        HelloWebServiceAuthPortType var = getHelloWebServiceAuthPortTypeLocalEndpoint();
        org.codehaus.xfire.client.Client.getInstance(var).setUrl(url);
        return var;
    }

    
    
    
    
    
    
    public static void main(String[] args) {
        
      // 用戶端
      HelloWebServiceAuthClient client = new HelloWebServiceAuthClient();
        
      // 建立服務
      HelloWebServiceAuthPortType service = client.getHelloWebServiceAuthHttpPort();
        

      // 設定客戶端呼叫的屬性
  	  Client clientService = Client.getInstance(service);  // service:客户端得到的服务对象
  	  
  	  // 註冊 soap 訊息中增加身份資訊
  	  clientService.addOutHandler(new ClientAuthenticationHandler("admin","1234"));
  	  

      // 呼叫服務
      String result = service.sayHello("kevin,Demo WSDL 呼叫方式！！！");
      System.out.println(HelloWebServiceAuthClient.class.getName());
      System.out.println("result = "+result);
          
    
      System.exit(0);
    } // end main

}
