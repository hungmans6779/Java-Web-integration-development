package com.helloweenvsfei.util;


import java.util.Date;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import com.helloweenvsfei.util.ApplicationConstants;

public class MyContextListener implements ServletContextListener {

	// 啟動時，記錄服務器啟動時間
	public void contextInitialized(ServletContextEvent event) {
	  ApplicationConstants.START_DATE = new Date();    // 記錄服務器啟動時間
	}

	
	// 關閉時，將結果清除。也可以將結果儲存到硬碟上。
	public void contextDestroyed(ServletContextEvent event) {	
	  ApplicationConstants.START_DATE = null;              // 清空服務器啟動時間
	  ApplicationConstants.MAX_ONLINE_COUNT_DATE = null;   // 清空最高在線時間
	}
	
	
	
}
