package com.helloweenvsfei.core.other;

public class InitializingBean02 {
  
  public void afterPropertiesSet() throws Exception {
	System.out.println(InitializingBean02.class.getName()+",LifeCycleBean  initializing.....");
  }
		  
}
