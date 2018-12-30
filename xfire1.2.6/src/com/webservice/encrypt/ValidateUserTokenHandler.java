package com.webservice.encrypt;

import java.security.cert.X509Certificate;

import java.util.Vector;

import org.apache.ws.security.WSConstants;
import org.apache.ws.security.WSSecurityEngineResult;
import org.apache.ws.security.WSUsernameTokenPrincipal;
import org.apache.ws.security.handler.WSHandlerConstants;
import org.apache.ws.security.handler.WSHandlerResult;
import org.codehaus.xfire.MessageContext;
import org.codehaus.xfire.handler.AbstractHandler;

import sun.security.x509.X500Name;


/*
 *  認證身份的 ValidateUserTokenHandler
 */
public class ValidateUserTokenHandler extends AbstractHandler {

	
	
	  public void invoke(MessageContext context) throws Exception {
		  
	    Vector result = (Vector)context.getProperty(WSHandlerConstants.RECV_RESULTS);
	    for(int i = 0 ; i < result.size() ; i++){
	      WSHandlerResult res = (WSHandlerResult) result.get(i);
	      
	      for(int j = 0 ; j < res.getResults().size() ; j++){
	    	WSSecurityEngineResult secRes = (WSSecurityEngineResult)res.getResults().get(j);
	    	int action = secRes.getAction();
	    	System.out.println(ValidateUserTokenHandler.class.getName());
	    	System.out.println("01. action         = "+action);
	    	System.out.println("02. WSConstants.UT = "+WSConstants.UT);
	    	
	    	// 如果是使用者名稱密碼的方式
	    	if((action & WSConstants.UT ) > 0){
	          System.out.println("使用者名稱密碼的方式！！！");
	          
	    	  WSUsernameTokenPrincipal principal = (WSUsernameTokenPrincipal) secRes.getPrincipal();
	    	  
	    	  // 以加密方式設定請求使用者名稱
	    	  context.setProperty(WSHandlerConstants.ENCRYPTION_USER,principal.getName());
	    	}  // end if((action & WSConstants.UT ) > 0){
	    	
	    	// 如果是簽名的方式
	    	if((action & WSConstants.SIGN ) > 0 ){
	    	  System.out.println("簽名的方式！！！");
	    		
	    	  X509Certificate cert = secRes.getCertificate();
	    	  X500Name principal = (X500Name)secRes.getPrincipal();
	    	} // end if((action & WSConstants.SIGN ) > 0 ){
	    	
	    	
	      } // end for(int j = 0 ; j < res.getResults().size() ; j++){
	      
	    } // end for(int i = 0;i < result.size() ; i++){
	    
	    
	  } // end invoke
	  

}
