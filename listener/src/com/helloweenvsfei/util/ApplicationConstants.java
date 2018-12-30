package com.helloweenvsfei.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

public class ApplicationConstants {
	
	public static Map<String, HttpSession> SESSION_MAP = new HashMap<String, HttpSession>(); // 所有的 Session
	public static int CURRENT_LOGIN_COUNT = 0;             // 目前登入的使用者總數
	public static int TOTAL_HISTORY_COUNT = 0;             // 歷史訪客總數
	public static Date START_DATE = new Date();            // 服務器啟動時間
	public static Date MAX_ONLINE_COUNT_DATE = new Date(); // 最高在線時間
	public static int MAX_ONLINE_COUNT = 0;                // 最高在線人數
	
}
