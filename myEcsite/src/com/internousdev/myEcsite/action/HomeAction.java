package com.internousdev.myEcsite.action;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.myEcsite.dao.BuyItemDAO;
import com.internousdev.myEcsite.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport implements SessionAware{
//	使う変数とその型を宣言
	public Map<String,Object> session;

//	新しいメソッド
	public String execute() {
//	resultっていう変数にloginっていう文字列を入れる→stuts.xmlのやつ
		String result="login";
		if(session.containsKey("id")) {
			BuyItemDAO buyItemDAO=new BuyItemDAO();
			BuyItemDTO buyItemDTO=buyItemDAO.getBuyItemInfo();
//	session.putはkey,valueを定義、入れる
			session.put("id",buyItemDTO.getId());
			session.put("buyItem_name",buyItemDTO.getItemName());
			session.put("buyItem_price",buyItemDTO.getItemPrice());
//	ifの通りやったらresultがSUCCESSに変わるよ
			result=SUCCESS;
		}
//	ifの通りではなかったら　変数result="login"に返す
		return result;
	}
//	super classにあるメソッドの処理方法を変えて利用
	@Override
	public void setSession(Map<String,Object> session) {
		this.session=session;
	}
	public Map<String,Object> getSession(){
		return this.session;
	}
}
