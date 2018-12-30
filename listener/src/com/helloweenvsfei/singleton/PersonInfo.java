package com.helloweenvsfei.singleton;

import java.io.Serializable;
import java.util.Date;

public class PersonInfo implements Serializable {

	private static final long serialVersionUID = 4063725584941336123L;

	// 帳號
	private String account;

	// 登入IP地址
	private String ip;

	// 登入時間
	private Date loginDate;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof PersonInfo)) {
			return false;
		}
		return account.equalsIgnoreCase(((PersonInfo) obj).getAccount());
	}
}
