package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dao.LoginDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware{
	private String loginUserId;
	private String loginPassword;
	private String adminFlg;
	public Map<String,Object> session;
	private LoginDAO loginDAO=new LoginDAO();
	private LoginDTO loginDTO=new LoginDTO();
//	private BuyItemDAO buyItemDAO=new BuyItemDAO();
	public ArrayList<BuyItemDTO> buyItemList=new ArrayList<BuyItemDTO>();

	public String execute() throws SQLException{
		String result=ERROR;
		loginDTO=loginDAO.getLoginUserInfo(loginUserId,loginPassword);
		session.put("loginUser", loginDTO);
		System.out.println(session.get("loginUser"));

		if(((LoginDTO) session.get("loginUser")).getLoginFlg()) {
			result=SUCCESS;
			BuyItemDAO dao=new BuyItemDAO();
			buyItemList=dao.getBuyItemListInfo();
//			BuyItemDTO buyItemDTO=new BuyItemDTO();

			session.put("login_user_id", loginUserId);
			System.out.println(session.get("login_user_id"));
			session.put("login_user_name", loginDTO.getUserName());
			System.out.println(session.get("login_user_name"));
//			session.put("id",buyItemDTO.getId());
//			session.put("buyItem_name", buyItemDTO.getItemName());
//			session.put("buyItem_price", buyItemDTO.getItemPrice());
//			System.out.println(session.get("buyItem_name"));
//			System.out.println(session.get("buyItem_price"));

			session.put("adminFlg", loginDTO.getAdminFlg());

			if(session.get("adminFlg")!=null) {
				result="admin";

				return result;
			}

			return result;
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
	public String getAdminFlg() {
		return adminFlg;
	}
	public void setAdminFlg(String adminFlg) {
		this.adminFlg=adminFlg;
	}
	@Override
	public void setSession(Map<String,Object> session) {
		this.session=session;
	}
	public ArrayList<BuyItemDTO> getBuyItemList(){
		return buyItemList;
	}
}
