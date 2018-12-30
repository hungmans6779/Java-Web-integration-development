package com.helloweenvsfei.core.service.impl;

import com.helloweenvsfei.core.dao.IDao;
import com.helloweenvsfei.core.service.IService;

// 實現 IService 介面的方法
public class ServiceImpl implements IService {

  // 定義一個IDao 物件
  private IDao dao;
  
  // 實現 service()方法
  public void service(String name) {
    System.out.println(dao.sayHello(name));  // 呼叫IDao 介面的方法
  }

  
  /**
   * @return the dao
   */
  public IDao getDao() {
	return dao;
  }

  
  /**
   * @param dao the dao to set
   */
  public void setDao(IDao dao) {
	this.dao = dao;
  }
  
 
  
  
	
}
