package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UserListDAO;
import com.internousdev.ecsite.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserListAction extends ActionSupport implements SessionAware{
	public Map<String,Object> session;
	private UserListDAO dao=new UserListDAO();
//	private LoginDTO dto=new LoginDTO();
	public ArrayList<LoginDTO> userList=new ArrayList<LoginDTO>();

	public String execute()throws SQLException{
			userList=dao.getUserInfo();
//			session.put("listLoginId", dto.getLoginId());
//			session.put("listLoginPassword", dto.getLoginPassword());
//			session.put("listUserName", dto.getUserName());
//			session.put("listAdminFlg", dto.getAdminFlg());
//			dto.getLoginId();
//			dto.getLoginPassword();
//			dto.getUserName();
//			dto.getAdminFlg();
		String result=SUCCESS;
		return result;
	}

	@Override
	public void setSession(Map<String,Object> session) {
		this.session=session;
	}
	public ArrayList<LoginDTO> getUserList(){
		return userList;
	}

}
