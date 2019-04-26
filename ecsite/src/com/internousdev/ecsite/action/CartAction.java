package com.internousdev.ecsite.action;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.CartDAO;
import com.internousdev.ecsite.dto.MyPageDTO;
//import com.internousdev.ecsite.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CartAction extends ActionSupport implements SessionAware{
	public Map<String,Object> session;
	ArrayList<MyPageDTO> cartList=new ArrayList<MyPageDTO>();
	private CartDAO dao=new CartDAO();
	private int count;
//	private String ItemName;
//	private String ItemPrice;
	private String itemId;
	public String deleteFlg;
	public String message;


	public String execute() throws SQLException{
		session.put("count", count);
//		System.out.println(session.get("count"));
		int intCount=Integer.parseInt(session.get("count").toString());
		int intPrice=Integer.parseInt(session.get("buyItem_price").toString());
		session.put("total_price", intCount*intPrice);

		dao.cartInfo(
				session.get("buyItem_id").toString(),
				session.get("buyItem_name").toString(),
				session.get("total_price").toString(),
				session.get("count").toString(),
				session.get("login_user_id").toString()
				);

		if(!session.containsKey("login_user_id")) {
			return ERROR;
		}
		if(deleteFlg==null) {
//			String item_transaction_id=session.get("id").toString();
			String user_master_id=session.get("login_user_id").toString();
			cartList=dao.getCartInfo(user_master_id);

//			System.out.println(cartList.get(5).getItemName());
//			String result=SUCCESS;
//			return result;
			session.put("message", "");
		}else if(deleteFlg.equals("1")) {
			delete();
		}
		String result=SUCCESS;
		return result;
	}

	public void delete()throws SQLException{
//		String item_transaction_id=session.get("id").toString();
		String user_master_id=session.get("login_user_id").toString();

		int res=dao.cartHistoryDelete(user_master_id);
		if(res>0) {
			cartList=null;
			setMessage("商品情報を正しく削除しました。");
		}else if(res==0) {
			setMessage("商品情報の削除に失敗しました。");
		}
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDeleteFlg() {
		return deleteFlg;
	}
	public void setDeleteFlg(String deleteFlg) {
		this.deleteFlg=deleteFlg;
	}
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	@Override
	public void setSession(Map<String,Object> session) {
		this.session=session;
	}
	public ArrayList<MyPageDTO> getCartList() {
		return cartList;
	}

	public void setCartList(ArrayList<MyPageDTO> cartList) {
		this.cartList = cartList;
	}

}
