package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemCreateCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemCreateCompleteAction extends ActionSupport implements SessionAware{
	private String sellName;
	private String sellPrice;
	private String sellStock;
	public Map<String,Object> session;

	public String execute() throws SQLException{
		ItemCreateCompleteDAO itemCreateCompleteDAO=new ItemCreateCompleteDAO();
		itemCreateCompleteDAO.createItem(session.get("sellName").toString(),
				Integer.parseInt(session.get("sellPrice").toString()),
				Integer.parseInt(session.get("sellStock").toString()));
		String result=SUCCESS;

		return result;
	}

	public String getSellName() {
		return sellName;
	}
	public void setSellName(String sellName) {
		this.sellName=sellName;
	}
	public String getSellPrice() {
		return sellPrice;
	}
	public void setSellPrice(String sellPrice) {
		this.sellPrice=sellPrice;
	}
	public String getSellStock() {
		return sellStock;
	}
	public void setSellStock(String sellStock) {
		this.sellStock=sellStock;
	}
	public Map<String,Object> getSession(){
		return session;
	}
	@Override
	public void setSession(Map<String,Object> session) {
		this.session=session;
	}

}
