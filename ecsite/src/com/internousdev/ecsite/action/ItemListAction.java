package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemListDAO;
import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemListAction extends ActionSupport implements SessionAware{
	public Map<String,Object> session;
	private ItemListDAO dao=new ItemListDAO();
//	private ItemInfoDTO dto=new ItemInfoDTO();
	public ArrayList<ItemInfoDTO> itemList=new ArrayList<ItemInfoDTO>();
//	public String deleteFlg;
//	public String message;

	public String execute()throws SQLException{
//		if(!session.containsKey("id")) {
//			return ERROR;
//		}
//		if(deleteFlg==null) {
//			String item_transaction_id=session.get("id").toString();
//			String user_master_id=session.get("login_user_id").toString();
			itemList=dao.getItemInfo();
//			session.put("itemName", dto.getItemName());
//			session.put("itemPrice", dto.getItemPrice());
//			session.put("itemStock", dto.getItemStock());
//			session.put("message", "");
//		}else if(deleteFlg.equals("1")) {
//			delete();
//		}
		String result=SUCCESS;
		return result;
	}

//	public void delete()throws SQLException{
//		String item_transaction_id=session.get("id").toString();
////		String user_master_id=session.get("login_user_id").toString();
//
//		int res=dao.createItemHistoryDelete(item_transaction_id);
//		if(res>0) {
//			itemList=null;
//			setMessage("商品情報を正しく削除しました。");
//		}else if(res==0) {
//			setMessage("商品情報の削除に失敗しました。");
//		}
//	}

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
//	public String getMessage() {
//		return this.message;
//	}
//	public void setMessage(String message) {
//		this.message=message;
//	}

}
