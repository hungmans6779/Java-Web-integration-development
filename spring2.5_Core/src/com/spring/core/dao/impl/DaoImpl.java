package com.spring.core.dao.impl;

import java.util.Calendar;

import com.spring.core.dao.IDao;

/*
 *  實現 IDao 介面
 */
public class DaoImpl implements IDao {

  // 實現 sayHello()
  public String sayHello(String name) {
	System.out.println(DaoImpl.class.getName() + ",sayHell()  execute...");

	int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);

	if (hour < 6)
	  return "凌晨早," + name;
	if (hour < 12)
	  return "早上好," + name;
	if (hour < 13)
	  return "中午好," + name;
	if (hour < 18)
	  return "下午好," + name;
	return "晚上好," + name;
  } // end sayHello
  
}
