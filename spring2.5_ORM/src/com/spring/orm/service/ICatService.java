package com.spring.orm.service;

import java.util.List;

import com.spring.orm.entity.Cat;


/*
 *  Service ざ
 *  
 *  Spring 箇砞 DAO 糷糤ユDAO 糷–よ猭ユ 
 *  Spring + Hibernate 祘Α砞璸い策篋暗猭琌 DAO 糷糤 Service 糷
 *  礛рユ砞﹚ Service 糷
 */
public interface ICatService {

	
  /*
   *  纗 Cat ン
   *  @param Cat ン
   */
  public void createCat(Cat cat);
  
  
  
  /*
   *  ┮Τ Cat
   *  @return List Cat ン 
   */
  public List<Cat> listCats();
 
  
  
  /*
   *  琩高 Cat 计秖
   *  @return int Cat 计秖
   */
  public int getCatsCount(); 
  
  
}
