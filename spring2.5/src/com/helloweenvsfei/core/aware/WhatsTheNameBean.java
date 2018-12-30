package com.helloweenvsfei.core.aware;

import org.springframework.beans.factory.BeanNameAware;

public class WhatsTheNameBean implements BeanNameAware {

  private String beanName;                    // 感知 Bean 的名字
  
  public void setBeanName(String beanName) {  // 儲存名字
	this.beanName=beanName;                   // Spring 會呼叫該方法   
  }

  public void showBean(){
	System.out.println("Bean name : "+this.beanName);  
  }
  
}
