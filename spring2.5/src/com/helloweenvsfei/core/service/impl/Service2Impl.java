package com.helloweenvsfei.core.service.impl;


import com.helloweenvsfei.core.dao.IDao2;
import com.helloweenvsfei.core.service.IService2;

public class Service2Impl implements IService2 {


  // 定義一個IDao2 物件
  private IDao2 dao2;
	
  
  // 實現 service()方法
  public void service(String name) {
	System.out.println(dao2.sayHello(name));  // 呼叫IDao 介面的方法
  }


  /**
   * @return the dao2
   */
  public IDao2 getDao2() {
	return dao2;
  }


  /**
   * @param dao2 the dao2 to set
   */
  public void setDao2(IDao2 dao2) {
	this.dao2 = dao2;
  }
 
	 

}
