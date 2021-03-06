package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;

public class UserListDeleteCompleteDAO {
//	public ArrayList<ItemInfoDTO> getItemInfo()throws SQLException{
//		ArrayList<ItemInfoDTO> itemList=new ArrayList<ItemInfoDTO>();
//		DBConnector db=new DBConnector();
//		Connection con=db.getConnection();

//		String sql="SELECT ubit.id,iit.item_name,ubit.total_price,ubit.total_count,ubit.pay,ubit.insert_date FROM user_buy_item_transaction ubit LEFT JOIN item_info_transaction iit ON ubit.item_transaction_id=iit.id WHERE ubit.item_transaction_id=? AND ubit.user_master_id=? ORDER BY insert_date DESC";
//		try {
//			PreparedStatement ps=con.prepareStatement(sql);
//			ps.setString(1, item_transaction_id);
//			ps.setString(2, user_master_id);
//
//			ResultSet rs=ps.executeQuery();
//			while(rs.next()) {
//				MyPageDTO dto=new MyPageDTO();
//				dto.setId(rs.getString("id"));
//				dto.setItemName(rs.getString("item_name"));
//				dto.setTotalPrice(rs.getString("total_price"));
//				dto.setTotalCount(rs.getString("total_count"));
//				dto.setPayment(rs.getString("pay"));
//				dto.setInsert_date(rs.getString("insert_date"));
//				myPageList.add(dto);
//			}
//		}catch(Exception e) {
//			e.printStackTrace();
//		}finally {
//			con.close();
//		}
//		return myPageList;
//	}

	public int userHistoryDelete()throws SQLException{
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();

		String sql="DELETE FROM login_user_transaction where admin_flg IS NULL";
		PreparedStatement ps;
		int result=0;
		try {
			ps=con.prepareStatement(sql);
//			ps.setString(1, item_transaction_id);
//			ps.setString(2, user_master_id);
			result=ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			con.close();
		}
		return result;
	}

}
