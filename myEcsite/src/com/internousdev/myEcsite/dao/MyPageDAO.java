package com.internousdev.myEcsite.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.myEcsite.dto.MyPageDTO;
import com.internousdev.myEcsite.util.DBConnector;

public class MyPageDAO {
	public ArrayList<MyPageDTO> getMyPageUserInfo(String item_transaction_id,
			String user_master_id)throws SQLException{
		ArrayList<MyPageDTO> myPageList=new ArrayList<MyPageDTO>();
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();

		String sql="SELECT ubit.id,iit.item_name,ubit.total_price,ubit.total_count,ubit.pay,ubit.insert_date FROM user_buy_item_transaction ubit LEFT JOIN item_info_transaction iit ON ubit.item_transaction_id=iit.id WHERE ubit.item_transaction_id=? AND ubit.user_master_id=? ORDER BY insert_date DESC";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, item_transaction_id);
			ps.setString(2, user_master_id);

			ResultSet rs=ps.executeQuery();
//	DTOにデータを入れる
			while(rs.next()){
				MyPageDTO dto=new MyPageDTO();
				dto.setId(rs.getString("id"));
				dto.setItemName(rs.getString("item_name"));
				dto.setTotalPrice(rs.getString("total_price"));
				dto.setTotalCount(rs.getString("total_count"));
				dto.setPayment(rs.getString("pay"));
				dto.setInsert_date(rs.getString("insert_date"));
//	DTOをArrayListに格納
				myPageList.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			con.close();
		}
		return myPageList;
	}

	public int buyItemHistoryDelete(String item_transaction_id,String user_master_id)
	throws SQLException{
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();

		String sql="DELETE FROM user_buy_item_transaction "
				+ "WHERE item_transaction_id=? AND user_master_id=?";
		int result=0;
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, item_transaction_id);
			ps.setString(2, user_master_id);
//	削除を実行（データベースの変更＝Update）
			result=ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			con.close();
		}
//	Actionクラスに削除した件数を返す
		return result;
	}
}
