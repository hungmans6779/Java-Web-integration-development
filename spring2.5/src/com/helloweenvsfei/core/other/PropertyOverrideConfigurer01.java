package com.helloweenvsfei.core.other;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PropertyOverrideConfigurer01 {

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


  /**
   * @param args
   */
  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-core.xml");
    PropertyOverrideConfigurer01 poc01 = (PropertyOverrideConfigurer01)context.getBean("student");
    System.out.println("****************************************");
    System.out.println("01.name  = "+poc01.getName());
    System.out.println("02.age   = "+poc01.getAge());
    System.out.println("03.birth = "+poc01.getBirth());
    System.out.println("****************************************");
    
  }

}
