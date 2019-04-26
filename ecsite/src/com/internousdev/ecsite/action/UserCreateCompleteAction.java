package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UserCreateCompleteDAO;
//import com.internousdev.ecsite.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserCreateCompleteAction extends ActionSupport implements SessionAware{
	private String loginUserId;
	private String loginPassword;
	private String userName;
	private String admin_Flg;
	public Map<String,Object> session;
	UserCreateCompleteDAO userCreateCompleteDAO=new UserCreateCompleteDAO();

	public String execute() throws SQLException{
//		LoginDTO dto=new LoginDTO();
		String result=SUCCESS;
		if(session.get("createAdminFlg")=="1") {
			userCreateCompleteDAO.createUser(
					session.get("createLoginUserId").toString(),
					session.get("createLoginPassword").toString(),
					session.get("createUserName").toString(),
//					dto.getLoginId(),
//					dto.getLoginPassword(),
//					dto.getUserName(),
					session.get("createAdminFlg").toString()
					);
			System.out.println(session.get("createLoginId"));
			System.out.println(session.get("createLoginPassword"));
			System.out.println(session.get("createUserName"));
			System.out.println(session.get("createAdminFlg"));
		}else{
			userCreateCompleteDAO.createUser(
				session.get("createLoginUserId").toString(),
				session.get("createLoginPassword").toString(),
				session.get("createUserName").toString()
//				dto.getLoginId(),
//				dto.getLoginPassword(),
//				dto.getUserName()
				);
			System.out.println(session.get("createLoginId"));
			System.out.println(session.get("createLoginPassword"));
			System.out.println(session.get("createUserName"));

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

}
