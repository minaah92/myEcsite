package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class ItemCreateConfirmAction extends ActionSupport implements SessionAware{
	private String sellName;
	private String sellPrice;
	private String sellStock;
	public Map<String,Object> session;
	private String errorMessage;

	public String execute() {
		String result=SUCCESS;

		if(!(sellName.equals(""))
				&& !(sellPrice.equals(""))
				&& !(sellStock.equals(""))) {
			session.put("sellName", sellName);
			session.put("sellPrice", sellPrice);
			session.put("sellStock", sellStock);
		}else {
			setErrorMessage("未入力の項目があります。");
			result=ERROR;
		}
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
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage=errorMessage;
	}

}
