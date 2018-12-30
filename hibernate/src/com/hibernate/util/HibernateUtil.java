package com.hibernate.util;

import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.AnnotationConfiguration;

import org.hibernate.SessionFactory;


public class HibernateUtil {
	
	// XML 設定時使用
	// private  static Configuration configuration = new Configuration();    
	
	// @ 設定時使用 
	private static Configuration configuration = new AnnotationConfiguration();
	

	// 單一狀態模式的 SessionFactory
	private static final SessionFactory sessionFactory;
	
	
	// static 程式碼區塊，類別載入時初始化 Hibernate
	static{
	  
	  try{	
		configuration.configure("hibernate.cfg.xml");
	      		
		// 從 hibernate.cfg.xml 中載入設定
		sessionFactory = configuration.buildSessionFactory();	
	  }catch (Throwable ex) {
		System.err.println("Initial SessionFactory creation failed." + ex);
		throw new ExceptionInInitializerError(ex);
	  }
	  
	} // end static{

	
	
	public static SessionFactory getSessionFactory() {
	  return sessionFactory;
	}
	
}
