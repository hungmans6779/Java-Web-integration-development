package com.helloweenvsfei.util;

import java.util.Date;
import java.io.Serializable;


public class PersonInfo implements Serializable {

	private static final long serialVersionUID = 4063725584941336123L;

	// �b��
	private String account;

	// �n�JIP�a�}
	private String ip;

	// �n�J�ɶ�
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