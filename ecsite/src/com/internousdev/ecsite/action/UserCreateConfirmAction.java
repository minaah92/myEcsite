package com.internousdev.ecsite.action;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserCreateConfirmAction extends ActionSupport implements SessionAware{
	private String loginUserId;
	private String loginPassword;
	private String userName;
	private String admin_Flg;
	public Map<String,Object> session;
	private String errorMessage;
	public LoginDTO dto=new LoginDTO();

	public String execute() {
		String result=SUCCESS;

		if(!(loginUserId.equals(""))
				&& !(loginPassword.equals(""))
				&& !(userName.equals(""))) {
			session.put("createLoginUserId", loginUserId);
			session.put("createLoginPassword", loginPassword);
			session.put("createUserName", userName);
//			dto.setLoginId(loginUserId);
//			dto.setLoginPassword(loginPassword);
//			dto.setUserName(userName);
			session.put("createAdminFlg",admin_Flg);
//			dto.setAdminFlg(admin_Flg);
			System.out.println(session.get("createLoginUserId"));
			System.out.println(session.get("createLoginPassword"));
			System.out.println(session.get("createUserName"));
			System.out.println(session.get("admin_Flg"));
		}else {
			setErrorMessage("未入力の項目があります。");
			result=ERROR;
		}
		return result;
	}

	public String getLoginUserId() {
		return loginUserId;
	}
	public void setLoginUserId(String loginUserId) {
		this.loginUserId=loginUserId;
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
	public String getAdmin_Flg() {
		return admin_Flg;
	}
	public void setAdmin_Flg(String admin_Flg) {
		this.admin_Flg=admin_Flg;
	}
	public Map<String,Object> getSession(){
		return session;
	}
	@Override
	public void setSession(Map<String,Object> session) {
		this.session=session;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage=errorMessage;
	}

}
