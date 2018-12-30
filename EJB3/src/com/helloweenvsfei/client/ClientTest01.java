package com.helloweenvsfei.client;

import java.util.Hashtable;

import javax.naming.InitialContext;
import javax.naming.Context;
import javax.rmi.PortableRemoteObject;

import com.helloweenvsfei.ejb3.HelloEJBServiceRemote;

public class ClientTest01 {

	private static Context context;
	 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	  try{
		Context ctx = getInitialContext();
		
		Object object = ctx.lookup("HelloEJBService/remote");
		
		HelloEJBServiceRemote service = (HelloEJBServiceRemote)PortableRemoteObject.narrow(object,HelloEJBServiceRemote.class);
		System.out.println(service.sayHelloEJB("Kevin"));
	  }catch(Exception e){
		  
	  }

	}
	
	
	protected static Context getInitialContext() throws Exception{
	  if(context==null){
	    Hashtable props = new Hashtable();
	    props.put(Context.INITIAL_CONTEXT_FACTORY,"org.jnp.interfaces.NamingContextFactory");
	    props.put(Context.URL_PKG_PREFIXES,"org.jboss.naming:org.jnp.interfaces");
	    props.put(Context.PROVIDER_URL,"jnp://localhost:1099");
	  }
	  return context;
	}

}
