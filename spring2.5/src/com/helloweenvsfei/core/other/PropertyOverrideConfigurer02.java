package com.helloweenvsfei.core.other;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PropertyOverrideConfigurer02 {

  String name;
  String age;
  String birth;
	    
  /**
   * @return the name
   */
  public String getName() {
	return name;
  }


  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }


  /**
	* @return the age
	*/
  public String getAge() {
	return age;
  }


  /**
   * @param age the age to set
   */
  public void setAge(String age) {
	this.age = age;
  }


  /**
   * @return the birth
   */
  public String getBirth() {
	return birth;
  }

  /**
   * @param birth the birth to set
   */
  public void setBirth(String birth) {
	this.birth = birth;
  }


	
  public static void main(String[] args) {
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-core.xml");
	PropertyOverrideConfigurer02 poc02 = (PropertyOverrideConfigurer02)context.getBean("kevin");
	System.out.println("****************************************");
	System.out.println("01.name  = "+poc02.getName());
	System.out.println("02.age   = "+poc02.getAge());
	System.out.println("03.birth = "+poc02.getBirth());
	System.out.println("****************************************");    
  }

}
