package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport implements SessionAware{
	public Map<String,Object> session;
	public ArrayList<BuyItemDTO> buyItemList=new ArrayList<BuyItemDTO>();

	public String execute() {
		String result="login";
		if(session.containsKey("adminFlg")) {
//			BuyItemDAO buyItemDAO=new BuyItemDAO();
//			BuyItemDTO buyItemDTO=buyItemDAO.getBuyItemInfo();
//			session.put("id", buyItemDTO.getId());
//			session.put("buyItem_name", buyItemDTO.getItemName());
//			session.put("buyItem_price", buyItemDTO.getItemPrice());

			result="admin";
		}else if(session.containsKey("login_user_id")) {
			BuyItemDAO dao=new BuyItemDAO();
			try {
				buyItemList=dao.getBuyItemListInfo();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			result=SUCCESS;
		}
		return result;
	}
	@Override
	public void setSession(Map<String,Object> session) {
		this.session=session;
	}
	public Map<String,Object> getSession(){
		return this.session;
	}
}
