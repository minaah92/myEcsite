package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class BuyItemAction extends ActionSupport implements SessionAware{
	public Map<String,Object> session;
	private int totalCount;
	private int totalPrice;
	private String itemName;
//	private String checkbox;
//	private String pay;

	public String execute() {
		String result=SUCCESS;

		session.put("buyConfirm_name", itemName);
		session.put("buyConfirm_count", totalCount);
		session.put("buyConfirm_price", totalCount);

		System.out.println(session.get("buyConfirm_name"));
		System.out.println(session.get("buyConfirm_count"));
		System.out.println(session.get("buyConfirm_price"));
//		session.put("count", count);
//		int intCount=Integer.parseInt(session.get("count").toString());
//		int intPrice=Integer.parseInt(session.get("buyItem_price").toString());
//		session.put("total_price", intCount*intPrice);
//		String payment;
//		if(pay.equals("1")) {
//			payment="現金払い";
//			session.put("pay", payment);
//		}else {
//			payment="クレジットカード";
//			session.put("pay", payment);
//		}
		return result;
	}


public int getTotalCount() {
		return totalCount;
	}


	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}


public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	//	public void setPay(String pay) {
//		this.pay=pay;
//	}
	@Override
	public void setSession(Map<String,Object> session) {
		this.session=session;
	}
}
