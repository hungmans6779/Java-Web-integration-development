package com.helloweenvsfei.logging;

import org.apache.log4j.Logger;
import org.apache.log4j.Priority;


public class Log4jConfigTest {
  
  public static Logger log=Logger.getLogger(Log4jConfigTest.class);	
	
  public static void main(String [] args){

	log.trace("trace 資訊");
	
	if(log.isEnabledFor(Priority.DEBUG))  
	  log.debug("debug 資訊");
	
	if(log.isEnabledFor(Priority.INFO))
	  log.info("info 資訊");
	
	if(log.isEnabledFor(Priority.WARN))
	  log.warn("warn 資訊");
	
	if(log.isEnabledFor(Priority.ERROR))
	  log.error("error 資訊");
	
	if(log.isEnabledFor(Priority.FATAL))
	  log.fatal("fatal 資訊");
	
	try{
	  String s=null;
	  s.length();
	}catch(Exception e){
		
	  if(log.isTraceEnabled())
	    log.trace("trace 一個例外",e);
	  
	  if(log.isDebugEnabled())
	    log.debug("debug 一個例外",e);
	  
	  if(log.isInfoEnabled())
	    log.info("info 一個例外",e);
	  
	  log.warn("warn 一個例外",e);  
	  log.error("error 一個例外",e);
	  log.fatal("fatal 一個例外",e);
	}
	
  }
  
  
  
}
