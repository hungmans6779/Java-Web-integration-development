package com.helloweenvsfei.hibernate.run;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.helloweenvsfei.hibernate.bean.Sailor;
import com.helloweenvsfei.hibernate.bean.Ship;
import com.helloweenvsfei.hibernate.util.HibernateUtil;
import com.helloweenvsfei.hibernate.util.HibernateXMLUtil;



//單邊的一對一關聯性：艦船管理
@SuppressWarnings("all")
public class TestXMLShipSailor {

	
  public static void main(String[] args) {
	
	// *********************************************************************
	// 第一艘 :華盛頓號  
	
	// 艦船  
	Ship ship1 = new Ship();  
    ship1.setName("華盛頓號");
	
    // 船長
    Sailor captain1 = new Sailor();
	captain1.setName("史密斯");
    captain1.setShip(ship1);
	
 
    // 船員1
    Sailor sailor11 = new Sailor();
    sailor11.setName("傑克");
    sailor11.setShip(ship1);
 
    // 船員2
    Sailor sailor12 = new Sailor();
    sailor12.setName("海倫");
    sailor12.setShip(ship1);
 
    // 船員3
    Sailor sailor13 = new Sailor();
    sailor13.setName("凱尼休士頓");
    sailor13.setShip(ship1);
 
 
    ship1.setCaptain(captain1);
    ship1.getSailors().add(sailor11);
    ship1.getSailors().add(sailor12);
    ship1.getSailors().add(sailor13);
    // *********************************************************************
 
 
 
    // *********************************************************************
    // 第二艘 :瓦良格號
    Ship ship2 = new Ship();
    ship2.setName("瓦良格號");
 
    // 船長 
    Sailor captain2 = new Sailor();
    captain2.setName("kevin");
    captain2.setShip(ship2);
 
    // 船員1
    Sailor sailor21 = new Sailor();
    sailor21.setName("一生懸命");
    sailor21.setShip(ship2);
 
    // 船員2
    Sailor sailor22 = new Sailor();
    sailor22.setName("山口裡子");
    sailor22.setShip(ship2);    
 
    ship2.setCaptain(captain2);
    ship2.getSailors().add(sailor21);
    ship2.getSailors().add(sailor22);
    // *********************************************************************   
 
 
 
    // 開啟階段 
    Session session  = HibernateXMLUtil.getSession();
 
    // 開啟交易
    Transaction trans =session.beginTransaction(); 

    // 持久化物件
    session.persist(ship1);
    session.persist(ship2);
 
    
    
    
    System.out.println("查詢【華盛頓號】 的所有船員\n");
    // 查詢【華盛頓號】 的所有船員
    List<Sailor> list1 = session.createQuery(" select s from Sailor s where s.ship.name = :name").setParameter("name","華盛頓號").list();
    for(Sailor s:list1){
      System.out.print("***************************************************\n");
      System.out.println("水手："+s.getName());
      System.out.println("艦船 ："+s.getShip().getName());
      System.out.println("船長："+s.getShip().getCaptain().getName());
      System.out.print("***************************************************\n");
    } // end for(Sailor s:list){
 
 
 
    System.out.println("查詢【瓦良格號】 的所有船員\n");
 
 
    // 查詢【瓦良格號】 的所有船員
    List<Sailor> list2 = session.createQuery(" select s from Sailor s where s.ship.name = :name").setParameter("name","瓦良格號").list();
    for(Sailor s:list2){
      System.out.print("***************************************************\n");
      System.out.println("水手："+s.getName());
      System.out.println("艦船 ："+s.getShip().getName());
      System.out.println("船長："+s.getShip().getCaptain().getName());
      System.out.print("***************************************************\n");
    } // end for(Sailor s:list){
 
 
    // 關閉交易
    trans.commit();
 
    // 關閉階段
    session.close();
 
  } // end main

}
