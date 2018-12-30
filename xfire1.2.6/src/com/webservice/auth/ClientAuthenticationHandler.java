package com.webservice.auth;

import org.codehaus.xfire.MessageContext;
import org.codehaus.xfire.handler.AbstractHandler;
import org.jdom.Element;
import org.jdom.Namespace;

/*
 *  【SOAP Header 中進行身份驗證】
 *   
 *  如果在SOAP Header 中身份證驗證的方式比較特殊，是自己義的一種方式，可以透過Handler 來處理，
 *  事實上 Handler 不僅僅能處理 SOAP Header ，它也可以處理 SOAP Body。 
 *  
 *  那麼則需要在用戶端和伺服器端增加發送認證資訊和處理認證資訊的Handler。
 *  
 *  用戶端發送SOAP 訊息時，透過增加 outHandler 使 SOAP 的頭資訊中增加身份的資訊；
 *  伺服器端要在呼叫服務前透過增加 inHandler 來負責認用戶端的請求，由認證是否透過來決定是否提供服務。
 *  無論是伺服器端的 Handler 是用戶端的Handler ，都要繼承 org.codehaus.xfire.handler.AbstractHandler 類別，實現其中的 invoke 方法。
 *  
 *  
 *  此範例為用戶端：
 *  (1) 在用戶端增加攜帶身份的 ClientAuthenticationHandler 類別，該類別負責在 soap 訊息表頭中增加身份資訊。
 *  (2) 將 Handler 註到到用戶端的程式碼中。
 *  
 */
public class ClientAuthenticationHandler extends AbstractHandler {

  // soap訊息的命名空間
  public final Namespace ns = Namespace.getNamespace("http://xfire.webservice.com");
  
  private String username = null;   // 使用者名稱
  private String password = null;   // 密碼
  
  
  // 未帶有參數的建構子
  public ClientAuthenticationHandler(){}
  
  // 帶有參數的建構子
  public ClientAuthenticationHandler(String username,String password){
	 this.username = username;
	 this.password = password;
  }

  
  
  public String getUsername() {
	return username;
  }

  public void setUsername(String username) {
	this.username = username;
  }

  public String getPassword() {
	return password;
  }

  public void setPassword(String password) {
	this.password = password;
  }


  
  
  
  
  
   
  public void invoke(MessageContext context) throws Exception {

	// 建立 header 節點
	Element el = new Element("header",ns);
	
	// 增加到 soap 中
	context.getOutMessage().setHeader(el);

	Element auth = new Element("AuthenticationToken",ns);
	
	
	
	
	// 增加認證身份資訊
	Element usernameElement = new Element("username",ns);
	usernameElement.addContent(username);
	auth.addContent(usernameElement);
	
	Element passwordElement = new Element("password",ns);
	passwordElement.addContent(password);
	auth.addContent(passwordElement);
	
	
	// 將認證身份增加到 header 中  
	el.addContent(auth);

  } // end invoke
 
  
  
  
  
  
  
	 
}
