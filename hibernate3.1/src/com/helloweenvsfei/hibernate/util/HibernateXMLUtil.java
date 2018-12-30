package com.helloweenvsfei.hibernate.util;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.helloweenvsfei.hibernate.bean.Cat;
import com.helloweenvsfei.hibernate.bean.Event;

public class HibernateXMLUtil {

  private static String CONFIG_FILE_LOCATION = "/hibernate_xml.cfg.xml";
  private static String configFile = CONFIG_FILE_LOCATION;
	  
  private static SessionFactory sessionFactory = null;
  private static Configuration configuration = new Configuration();
  
  static{
	try{
	  // 從  hibernate.cfg.xml 中載入設定
	  configuration.configure("hibernate_xml.cfg.xml");
		
	  sessionFactory = configuration.buildSessionFactory();
	}catch(Exception ex){
	  ex.printStackTrace();
	  
	  System.out.println("Initial SessionFactory creation failed."+ex);
	  
	  throw new ExceptionInInitializerError(ex);
	}
  } // end static 
  
  
  
  public static SessionFactory getSessionFactory(){
	return sessionFactory;  
  } // end getSessionFactory()
  
  
  
  public static Session getSession(){
	return sessionFactory!=null?sessionFactory.openSession():null;
  }
  
  
  
  public static void main(String [] args){
	

	Cat cat = new Cat();
	
	cat.setName("Kevin");
	cat.setDescription("Kevin's name");
	cat.setCreateDate(new Date());
	

	Session session = getSessionFactory().openSession();
	Transaction trans = session.beginTransaction();
	
	session.persist(cat);
	
	trans.commit();
	
	session.close();

	
	
	
	
	

    /*
      	  
	Cat cat = new Cat();
	cat.setName("加菲貓");
    cat.setDescription("Kevin's name");
	cat.setCreateDate(new Date());
	
	

	Event event = new Event();
	event.setDescription("吃早飯");
	event.setCat(cat);

	
	
	
	
	
	Session session = getSessionFactory().openSession();
	
	Transaction trans = session.beginTransaction();
	// session.beginTransaction();
	
	session.persist(cat);
	// session.persist(event);
	
	// session.flush();
	// session.getTransaction().commit();
	trans.commit();
	session.close();
	
	
 	
	session = getSessionFactory().openSession();
	trans = session.beginTransaction();
	Cat cc = (Cat)session.get(Cat.class,cat.getId());
	// session.getTransaction().commit();
    trans.commit();	
	
	session.close();
	*/

	  
	  
  }  // end main
  
  // end main
  
	
}
