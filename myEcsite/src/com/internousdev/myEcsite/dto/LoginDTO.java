package com.internousdev.myEcsite.dto;

public class LoginDTO {
	private String loginId;
	private String loginPassword;
	private String userName;
//	LoginActionのifを動かすため
	private boolean loginFlg=false;


	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId=loginId;
	}
	public String getLoginPassword() {
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword) {
		this.loginPassword=loginPassword;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName=userName;
	}
	public boolean getLoginFlg() {
		return loginFlg;
	}
	public void setLoginFlg(boolean loginFlg) {
		this.loginFlg=loginFlg;
	}

}