package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
//import com.internousdev.ecsite.dao.LoginDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
//import com.internousdev.ecsite.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemListAction extends ActionSupport implements SessionAware{
	private String itemId;
//	private String loginUserId;
//	private String loginPassword;
//	private String adminFlg;
	public Map<String,Object> session;
//	private LoginDAO loginDAO=new LoginDAO();
//	private LoginDTO loginDTO=new LoginDTO();

//	public ArrayList<BuyItemDTO> buyItemList=new ArrayList<BuyItemDTO>();

	public String execute() throws SQLException{
		String result=SUCCESS;
		session.put("buyItem_id", itemId);
//		int id=Integer.parseInt(session.get("id").toString());

		BuyItemDAO dao=new BuyItemDAO();
		BuyItemDTO dto=dao.getBuyItemInfo(itemId);
//		session.put("id",dto.getId());
		session.put("buyItem_name",dto.getItemName());
		session.put("buyItem_price",dto.getItemPrice());
//System.out.println(session.get("buyItem_id"));
			return result;
		}


	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	//	public String getLoginUserId() {
//		return loginUserId;
//	}
//	public void setLoginUserId(String loginUserId) {
//		this.loginUserId=loginUserId;
//	}
//	public String getLoginPassword() {
//		return loginPassword;
//	}
//	public void setLoginPassword(String loginPassword) {
//		this.loginPassword=loginPassword;
//	}
//	public String getAdminFlg() {
//		return adminFlg;
//	}
//	public void setAdminFlg(String adminFlg) {
//		this.adminFlg=adminFlg;
//	}
	@Override
	public void setSession(Map<String,Object> session) {
		this.session=session;
	}
//	public ArrayList<BuyItemDTO> getBuyItemList(){
//		return buyItemList;
//	}
}
