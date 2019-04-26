package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.internousdev.ecsite.util.DBConnector;

public class ItemListDAO {
	public ArrayList<ItemInfoDTO> getItemInfo()throws SQLException{
		ArrayList<ItemInfoDTO> itemList=new ArrayList<ItemInfoDTO>();
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();

		String sql="SELECT *FROM item_info_transaction ORDER BY insert_date DESC";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
//			ps.setString(1, item_transaction_id);
//			ps.setString(2, user_master_id);

			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				ItemInfoDTO dto=new ItemInfoDTO();
				dto.setId(rs.getString("id"));
				dto.setItemName(rs.getString("item_name"));
				dto.setItemPrice(rs.getString("item_price"));
				dto.setItemStock(rs.getString("item_stock"));
//				dto.setInsert_date(rs.getString("insert_date"));
//				dto.setUpdate_date(rs.getString("update_date"));
				itemList.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			con.close();
		}
		return itemList;
	}

//	public int itemHistoryDelete()throws SQLException{
//		DBConnector db=new DBConnector();
//		Connection con=db.getConnection();
//
//		String sql="DELETE FROM item_info_transaction";
//		PreparedStatement ps;
//		int result=0;
//		try {
//			ps=con.prepareStatement(sql);
//			ps.setString(1, item_transaction_id);
//			ps.setString(2, user_master_id);
//			result=ps.executeUpdate();
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}finally {
//			con.close();
//		}
//		return result;
//	}

}
