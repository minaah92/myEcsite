package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.MyPageDTO;
import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;

public class CartDAO {
	DBConnector db=new DBConnector();
	Connection con=db.getConnection();
	DateUtil dateUtil=new DateUtil();

	public void cartInfo(String item_transaction_id,String item_name,String total_price,String total_count,String user_master_id)throws SQLException{
		String sql="INSERT INTO cart(item_transaction_id,item_name,total_price,total_count,user_master_id,insert_date) VALUES(?,?,?,?,?,?)";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, item_transaction_id);
			ps.setString(2, item_name);
			ps.setString(3, total_price);
			ps.setString(4, total_count);
			ps.setString(5, user_master_id);
			ps.setString(6, dateUtil.getDate());
			ps.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}
//		finally {
//			con.close();
//		}
	}
	public ArrayList<MyPageDTO> getCartInfo(String user_master_id)throws SQLException{
		ArrayList<MyPageDTO> cartList=new ArrayList<MyPageDTO>();

		String sql="SELECT *FROM cart WHERE user_master_id=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, user_master_id);

			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				MyPageDTO dto=new MyPageDTO();
//				dto.setId(rs.getString("id"));
				dto.setItemName(rs.getString("item_name"));
				System.out.println(dto.getItemName());
				dto.setTotalPrice(rs.getString("total_price"));
				System.out.println(dto.getTotalPrice());
				dto.setTotalCount(rs.getString("total_count"));
				System.out.println(dto.getTotalCount());
//				dto.setPayment(rs.getString("pay"));
				dto.setInsert_date(rs.getString("insert_date"));
				cartList.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			con.close();
		}
		return cartList;
	}


	public int cartHistoryDelete(String user_master_id)throws SQLException{
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();

		String sql="DELETE FROM cart WHERE user_master_id=?";
		PreparedStatement ps;
		int result=0;
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, user_master_id);
			result=ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			con.close();
		}
		return result;
	}

//	public int updateCartCount(String user_master_id, String item_transaction_id, int count){
//		//
//		DBConnector db = new DBConnector();
//		Connection con = db.getConnection();
//		String sql = "UPDATE cart SET total_count=(total_count + ?), update_date=? WHERE user_master_id=? AND item_transaction_id=?";
//
//		int result = 0;
//
//		try{
//			PreparedStatement ps = con.prepareStatement(sql);
//			ps.setInt(1,count);
//			ps.setString(2,dateUtil.getDate());
//			ps.setString(3,user_master_id);
//			ps.setString(4,item_transaction_id);
//			result = ps.executeUpdate();
//
//		}catch(SQLException e){
//			e.printStackTrace();
//		} finally {
//			try{
//				con.close();
//			}catch(SQLException e){
//				e.printStackTrace();
//			}
//		}
//		return result;
//	}
//
//	public boolean isExistsCartInfo (String user_master_id, int item_transaction_id) {
//		DBConnector db = new DBConnector();
//		Connection con = db.getConnection();
//		String sql = "SELECT COUNT(id) AS COUNT FROM cart WHERE user_master_id = ? and item_transaction_id=?";
//
//		boolean result = false;
//
//		try{
//			PreparedStatement ps = con.prepareStatement(sql);
//			ps.setString(1, user_master_id);
//			ps.setInt(2, item_transaction_id);
//			ResultSet rs = ps.executeQuery();
//
//			if(rs.next()){
//				if(rs.getInt("COUNT") > 0) {
//					result = true;
//				}
//			}
//		}catch(SQLException e){
//			e.printStackTrace();
//		} finally {
//			try{
//				con.close();
//			}catch(SQLException e){
//				e.printStackTrace();
//			}
//		}
//		return result;
//	}

}
