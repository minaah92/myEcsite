package com.internousdev.ecsite.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;

public class ItemCreateCompleteDAO {
	 private DateUtil dateUtil=new DateUtil();
	 private String sql="INSERT INTO item_info_transaction(item_name,item_price,item_stock,insert_date) VALUES(?,?,?,?)";
	public void createItem(String sellName,int sellPrice,int sellStock) throws SQLException{
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, sellName);
			ps.setInt(2, sellPrice);
			ps.setInt(3, sellStock);
			ps.setString(4, dateUtil.getDate());

			ps.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			con.close();
		}
	}
}
