/*
 *  BeanFactoryAware 介面明JavaBean 知道哪個BeanFactory 產生實體了自己。
 *  BeanFactoryAware 介面中有setBeanFactory 的回檔方法，初始化該物件後，會回檔該方法，將BeanFactory 傳遞進來。
 *  
 *  實現了BeanFactoryAware介面的JavaBean能夠獲得BeanFactory，從BeanFactory 中能夠獲得到該BeanFactory中設定的其他JavaBean。
 *  Spring不推薦這樣做，因為這樣會與Spring耦合。獲得其他JavaBean一般透過設定getter、setter方法，用相依植入實現。
 */
package com.helloweenvsfei.core.aware;

import org.springframework.beans.BeansException;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component("a")
public class A implements BeanFactoryAware {

  @Autowired
  @Qualifier("b")
  private B b;
	
  private BeanFactory factory;	
  
  /**
   * @return the b
   */
  public B getB() {
	return (B)factory.getBean("b");
  }

  /**
   * @param b the b to set
   */
  public void setB(B b) {
	this.b = b;
  }

  public void printB(){
	 System.out.println(getB()); 
  }
  
  
 
  // 容器在實例化實現了BeanFactoryAware 接口的Bean 時，會自動將容器本身注入該Bean
  public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
    this.factory = beanFactory;
  }
  
  

}
