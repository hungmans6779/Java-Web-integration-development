package com.spring.core.aware;

import org.springframework.beans.factory.BeanNameAware;

/*
 *  BeanNameAware 介面明  JavaBean 知道自己在設定檔中的id 。實現 BeanNameAware 介面，實現方法過為 setBeanName() 方法，
 *  初始化該物件後 Spring 就會執行該回檔方法，將 id 設定進來。Bean 中設定一個寫程式，接收 id 名稱即可。
 */
public class WhatsTheNameBean implements BeanNameAware {

  private String beanName;                    // 感知 Bean 的名字
	  
  public void setBeanName(String beanName) {  // 儲存名字
    System.out.println(WhatsTheNameBean.class.getName()+",setBeanName execute...");
    System.out.println("beanName = "+beanName);
    
	this.beanName=beanName;                    // Spring 會呼叫該方法   
  }

  public void showBean(){
	System.out.println(this.beanName);  
  }
	  
}