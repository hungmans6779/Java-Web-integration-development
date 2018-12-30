package com.helloweenvsfei.hibernate.util;

import org.hibernate.HibernateException;

import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;


/**
 * Configures and provides access to Hibernate sessions, tied to the
 * current thread of execution.  Follows the Thread Local Session
 * pattern, see {@link http://hibernate.org/42.html }.
 */



/*
 *  HibernateSessionFactory 為 Hibernate 的工具類別，用於獲得 Session。
 *  Hibernate 的 Session 為 org.hibernate.Session ，代表一次完整的資料庫操作，
 *  與Servlet 裡的 Session 完全不同。一次Session 操作可以包括多次的資料庫讀寫、多個交易(Transaction)。
 */
public class HibernateSessionFactory {

 /** 
   * Location of hibernate.cfg.xml file.
   * Location should be on the classpath as Hibernate uses  
   * #resourceAsStream style lookup for its configuration file. 
   * The default classpath location of the hibernate config file is 
   * in the default package. Use #setConfigFile() to update 
   * the location of the configuration file for the current session.   
   */
  private static String CONFIG_FILE_LOCATION = "/hibernate.cfg.xml";
  private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
  
  // XML 設定時使用
  // private static Configuration configuration = new Configuration();           
  
  // @ 設定時使用
  private static Configuration configuration = new AnnotationConfiguration();  

  private static org.hibernate.SessionFactory sessionFactory;
  private static String configFile = CONFIG_FILE_LOCATION;

  
  static {
    try {
	  configuration.configure(configFile);
	  sessionFactory = configuration.buildSessionFactory();
	}catch(Exception e) {
	  System.err.println("%%%% Error Creating SessionFactory %%%%");
	  e.printStackTrace();
    }
  } // end static {

  
  
  
  
  private HibernateSessionFactory() {
  }

  
  
  
  
  /**
   * Returns the ThreadLocal Session instance.  Lazy initialize
   * the <code>SessionFactory</code> if needed.
   *
   *  @return Session
   *  @throws HibernateException
   */
  // 用 ThreadLocal 來維護 Session 。它的主要作用就是傳回一個 Session。  
  public static Session getSession() throws HibernateException {
    Session session = (Session) threadLocal.get();
	if(session == null || !session.isOpen()) {
	  if(sessionFactory == null) {
		rebuildSessionFactory();
	  }
	  session = (sessionFactory != null) ? sessionFactory.openSession(): null;
      threadLocal.set(session);
	}
    return session;
  } // end Session getSession()

  
  
  
  
  /**
   *  Rebuild hibernate session factory
   *
   */
  public static void rebuildSessionFactory() {
	try {
	  configuration.configure(configFile);
	  sessionFactory = configuration.buildSessionFactory();
	}catch (Exception e) {
	  System.err.println("%%%% Error Creating SessionFactory %%%%");
	  e.printStackTrace();
	}
  } // end void rebuildSessionFactory() 

  
  
  
  
  /**
   *  Close the single hibernate session instance.
   *
   *  @throws HibernateException
   */
  public static void closeSession() throws HibernateException{
    Session session = (Session) threadLocal.get();
    threadLocal.set(null);
    if(session != null) {
      session.close();
    }
  } // end void closeSession() 

  
  
  
  
  /**
   *  return session factory
   *
   */
  public static org.hibernate.SessionFactory getSessionFactory() {
	return sessionFactory;
  }

  
  
  
  
 /**
   *  return session factory
   *
   *	session factory will be rebuilded in the next call
   */
  public static void setConfigFile(String configFile) {
	HibernateSessionFactory.configFile = configFile;
	sessionFactory = null;
  } // end void setConfigFile(String configFile)

  
  
  
  
  /**
   *  return hibernate configuration
   *
   */
  public static Configuration getConfiguration() {
	return configuration;
  }

  
  
}