package com.spring.core.service.impl;

import com.spring.core.dao.IDao;
import com.spring.core.service.IService;

/*
 *  ¹ê²{ IService ¤¶­±
 */
public class ServiceImpl implements IService {

  IDao dao = null;

  public IDao getDao() {
	return dao;
  }

  public void setDao(IDao dao) {
	this.dao = dao;
  }


  public void service(String name) {
    System.out.println(dao.sayHello(name));   
  }
	
  
  
}
