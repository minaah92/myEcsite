package com.internousdev.myEcsite.action;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.myEcsite.dao.MyPageDAO;
import com.internousdev.myEcsite.dto.MyPageDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MyPageAction extends ActionSupport implements SessionAware{
	public Map<String,Object> session;
	private MyPageDAO dao=new MyPageDAO();
	private MyPageDTO dto=new MyPageDTO();
	public ArrayList<MyPageDTO> myPageList=new ArrayList<MyPageDTO>();
	public String deleteFlg;
	public String message;

	public String execute()throws SQLException{
		if(!session.containsKey("id")) {
			return ERROR;
		}
		if(deleteFlg==null) {
			String item_transaction_id=session.get("id").toString();
			String user_master_id=session.get("login_user_id").toString();
			myPageList=dao.getMyPageUserInfo(item_transaction_id, user_master_id);
			session.put("buyItem_name", dto.getItemName());
			session.put("total_price", dto.getTotalPrice());
			session.put("total_count", dto.getTotalCount());
			session.put("total_payment", dto.getPayment());
			session.put("message", "");
		}else if(deleteFlg.equals("1")) {
			delete();
		}
		String result=SUCCESS;
		return result;
	}

	public void delete()throws SQLException{
		String item_transaction_id=session.get("id").toString();
		String user_master_id=session.get("login_user_id").toString();
//	resはただの変数 buyItemHistoryDelete()の最後のreturnの結果で、削除された件数によって表示する文を変える
		int res=dao.buyItemHistoryDelete(item_transaction_id, user_master_id);
		if(res>0) {
			myPageList=null;
			setMessage("商品情報を正しく削除しました。");
		}else if(res==0) {
			setMessage("商品情報の削除に失敗しました。");
		}
	}

	public String setDeleteFlg() {
		return deleteFlg;
	}
	public void setDeleteFlg(String deleteFlg) {
		this.deleteFlg=deleteFlg;
	}
	@Override
	public void setSession(Map<String,Object> session) {
		this.session=session;
	}
	public String getMesssage() {
		return message;
	}
	public void setMessage(String message) {
		this.message=message;
	}
}
