
package com.webservice.xfire;

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
import com.webservice.xfire.auth.HelloWebServiceAuthClient;

/*
 *  根據 WSDL 產生的用戶端
 *  本例的WSDL： http://3w.eztravel.com.tw:8080/xfire1.2.6/services/HelloWebService?wsdl  
 *  
 *  
 *  ※ 《一般呼叫》的範例
 *  
 *  如果即沒有SDK，又需要在程式中呼叫Web 服務，那麼如何來實現呢？
 *  MyEclipse 的 Web 服務用戶端產生工具能夠根據WSDL 自動產生呼叫的程式碼。
 *  
 */
public class HelloWebServiceClient {

    private static XFireProxyFactory proxyFactory = new XFireProxyFactory();
    private HashMap endpoints = new HashMap();
    private Service service0;

    
    
    public HelloWebServiceClient() {
        create0();
        Endpoint HelloWebServicePortTypeLocalEndpointEP = service0 .addEndpoint(new QName("http://xfire.webservice.com", "HelloWebServicePortTypeLocalEndpoint"), new QName("http://xfire.webservice.com", "HelloWebServicePortTypeLocalBinding"), "xfire.local://HelloWebService");
        endpoints.put(new QName("http://xfire.webservice.com", "HelloWebServicePortTypeLocalEndpoint"), HelloWebServicePortTypeLocalEndpointEP);
        Endpoint HelloWebServiceHttpPortEP = service0 .addEndpoint(new QName("http://xfire.webservice.com", "HelloWebServiceHttpPort"), new QName("http://xfire.webservice.com", "HelloWebServiceHttpBinding"), "http://3w.eztravel.com.tw:8080/xfire1.2.6/services/HelloWebService");
        endpoints.put(new QName("http://xfire.webservice.com", "HelloWebServiceHttpPort"), HelloWebServiceHttpPortEP);
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
        service0 = asf.create((com.webservice.xfire.HelloWebServicePortType.class), props);
        {
            AbstractSoapBinding soapBinding = asf.createSoap11Binding(service0, new QName("http://xfire.webservice.com", "HelloWebServicePortTypeLocalBinding"), "urn:xfire:transport:local");
        }
        {
            AbstractSoapBinding soapBinding = asf.createSoap11Binding(service0, new QName("http://xfire.webservice.com", "HelloWebServiceHttpBinding"), "http://schemas.xmlsoap.org/soap/http");
        }
    }

    
    
    public HelloWebServicePortType getHelloWebServicePortTypeLocalEndpoint() {
        return ((HelloWebServicePortType)(this).getEndpoint(new QName("http://xfire.webservice.com", "HelloWebServicePortTypeLocalEndpoint")));
    }

    
    
    public HelloWebServicePortType getHelloWebServicePortTypeLocalEndpoint(String url) {
        HelloWebServicePortType var = getHelloWebServicePortTypeLocalEndpoint();
        org.codehaus.xfire.client.Client.getInstance(var).setUrl(url);
        return var;
    }

    
    public HelloWebServicePortType getHelloWebServiceHttpPort() {
        return ((HelloWebServicePortType)(this).getEndpoint(new QName("http://xfire.webservice.com", "HelloWebServiceHttpPort")));
    }

    
    public HelloWebServicePortType getHelloWebServiceHttpPort(String url) {
        HelloWebServicePortType var = getHelloWebServiceHttpPort();
        org.codehaus.xfire.client.Client.getInstance(var).setUrl(url);
        return var;
    }



    
    
    
    public static void main(String[] args) {
        
      // 用戶端
      HelloWebServiceClient client = new HelloWebServiceClient();

      // 建立服務
      HelloWebServicePortType service = client.getHelloWebServiceHttpPort();
          
      // 呼叫服務
      String result = service.sayHello("kevin,Demo WSDL 呼叫方式！！！");
      System.out.println(HelloWebServiceClient.class.getName());
      System.out.println("result = "+result);
        
	  
	  
      System.exit(0);
    } // end main
    
    
    
    
    

}
