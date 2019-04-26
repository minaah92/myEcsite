package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.util.DBConnector;

public class BuyItemDAO {
	public DBConnector db=new DBConnector();
	public Connection con=db.getConnection();

	public ArrayList<BuyItemDTO> getBuyItemListInfo()throws SQLException{
		ArrayList<BuyItemDTO> buyItemList=new ArrayList<BuyItemDTO>();

		String sql="SELECT *FROM item_info_transaction ORDER BY id DESC";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				BuyItemDTO dto=new BuyItemDTO();
				dto.setId(rs.getInt("id"));
				dto.setItemName(rs.getString("item_name"));
				dto.setItemPrice(rs.getString("item_price"));
				buyItemList.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			con.close();
		}
		return buyItemList;
	}
	private BuyItemDTO buyItemDTO=new BuyItemDTO();

	public BuyItemDTO getBuyItemInfo(String itemId) {
		String sql="SELECT id,item_name,item_price FROM item_info_transaction WHERE id=?";

		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, itemId);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				buyItemDTO.setId(rs.getInt("id"));
				buyItemDTO.setItemName(rs.getString("item_name"));
				buyItemDTO.setItemPrice(rs.getString("item_price"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return buyItemDTO;
	}

//	public BuyItemDTO getBuyItemDTO() {
//		return buyItemDTO;
//	}

}
