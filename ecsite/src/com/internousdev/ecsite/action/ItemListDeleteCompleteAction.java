package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemListDeleteCompleteDAO;
import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemListDeleteCompleteAction extends ActionSupport implements SessionAware{
	public Map<String,Object> session;
	private ItemListDeleteCompleteDAO dao=new ItemListDeleteCompleteDAO();
//	private ItemInfoDTO dto=new ItemInfoDTO();
	public ArrayList<ItemInfoDTO> itemList=new ArrayList<ItemInfoDTO>();
//	public String deleteFlg;
	public String message;

	public String execute()throws SQLException{
//		if(!session.containsKey("id")) {
//			return ERROR;
//		}
//		if(deleteFlg==null) {
//			String item_transaction_id=session.get("id").toString();
//			String user_master_id=session.get("login_user_id").toString();
//			myPageList=dao.getMyPageUserInfo(item_transaction_id,user_master_id);
//			session.put("buyItem_name", dto.getItemName());
//			session.put("total_price", dto.getTotalPrice());
//			session.put("total_count", dto.getTotalCount());
//			session.put("total_payment", dto.getPayment());
//			session.put("message", "");
//		}else if(deleteFlg.equals("1")) {
//			delete();
//		}
//		String result=SUCCESS;
//		return result;
//	}

//	public void delete()throws SQLException{
//		String item_transaction_id=session.get("id").toString();
//		String user_master_id=session.get("login_user_id").toString();
		String result=SUCCESS;

		int res=dao.itemHistoryDelete();
		if(res>0) {
			itemList=null;
			setMessage("商品情報を正しく削除しました。");
		}else if(res==0) {
			setMessage("商品情報の削除に失敗しました。");
		}
		return result;
	}

//	public String getDeleteFlg() {
//		return deleteFlg;
//	}
//	public void setDeleteFlg(String deleteFlg) {
//		this.deleteFlg=deleteFlg;
//	}
	@Override
	public void setSession(Map<String,Object> session) {
		this.session=session;
	}
	public ArrayList<ItemInfoDTO> getItemList(){
		return itemList;
	}
	public String getMessage() {
		return this.message;
	}
	public void setMessage(String message) {
		this.message=message;
	}

}
