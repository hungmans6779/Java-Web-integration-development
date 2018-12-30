package com.helloweenvsfei.logging;

import java.util.logging.ConsoleHandler;

import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;


public class JDKLogTest {
  
  public static Logger log = Logger.getLogger(JDKLogTest.class.toString());
  
  static{
    Handler console=new ConsoleHandler(); // 增加一個控制台的輸出
    console.setLevel(Level.FINE);         // 設定為FINE級別
    log.addHandler(console);              // 增加到log 中
  }
  
  
  public static void main(String [] args){
	log.setLevel(Level.FINE);
	
	log.finest("first");
	log.finer("finer");
	log.fine("fine");
	log.config("config");
	log.info("info");
	log.warning("warning");
	log.severe("severe");
  }
  
  
}
