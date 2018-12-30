package com.helloweenvsfei.hibernate.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
 
  private static String CONFIG_FILE_LOCATION = "/hibernate.cfg.xml";
  private static String configFile = CONFIG_FILE_LOCATION;
  
  private static final SessionFactory sessionFactory;
  private static Configuration configuration = new AnnotationConfiguration();
  
  
  static{
	try{
	  // sessionFactory = new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();  
		
	  // 從  hibernate.cfg.xml 中載入設定
	  configuration.configure(configFile);
      sessionFactory = configuration.buildSessionFactory();
	}catch(Throwable ex){
	  System.err.println("Initial SessionFactory creation failed." + ex);
	  throw new ExceptionInInitializerError(ex);
	}
  } // end static 

  
  
  
  public static SessionFactory getSessionFactory(){
	return sessionFactory; 
  } // end SessionFactory getSessionFactory()
	
  
  
  
  public static Session getSession(){
	 return sessionFactory.openSession(); 
  }
  
 
  
}
