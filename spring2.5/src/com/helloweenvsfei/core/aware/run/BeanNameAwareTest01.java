package com.helloweenvsfei.core.aware.run;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.helloweenvsfei.core.aware.WhatsTheNameBean;

/*
   BeanNameAware 介面獲得Bean的id
   BeanNameAware 介面明 JavaBean 知道自己在設定檔中的id。實現BeanNameAware 介面，實現方法名為setBeanName() 方法，
        初始化該物件後Spring 就會執行該回檔方法，將id設定進來。Bean中設定一個寫法，接受id 名稱即可。
 */
public class BeanNameAwareTest01 {

  /**
   * @param args
  */
  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-core.xml");
    WhatsTheNameBean bean = (WhatsTheNameBean)context.getBean("whatsTheNameBean");
    System.out.println(context);
    bean.setBeanName("whatsTheNameBean");
    bean.showBean();
  }
  

}
