package com.internousdev.ecsite.action;
import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemCompleteDAO;
//import com.internousdev.ecsite.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemConfirmAction extends ActionSupport implements SessionAware{
	public Map<String,Object> session;
	private BuyItemCompleteDAO dao=new BuyItemCompleteDAO();
	private String pay;

	public String execute() throws SQLException{
//		BuyItemDTO dto=new BuyItemDTO();
		dao.buyItemInfo(
				session.get("buyItem_id").toString(),
				session.get("login_user_id").toString(),
				session.get("total_price").toString(),
				session.get("count").toString(),
				pay
//				session.get("pay").toString()
				);
		String result=SUCCESS;
		return result;
	}

	public void setPay(String pay) {
		this.pay=pay;
	}
	@Override
	public void setSession(Map<String,Object> session) {
		this.session=session;
	}

}
