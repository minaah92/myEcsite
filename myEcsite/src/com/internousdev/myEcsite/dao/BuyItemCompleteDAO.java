package com.internousdev.myEcsite.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.myEcsite.util.DBConnector;
import com.internousdev.myEcsite.util.DateUtil;


public class BuyItemCompleteDAO {
	private DBConnector db=new DBConnector();
	private Connection con=db.getConnection();
	private DateUtil dateUtil=new DateUtil();

//	購入したものの情報をデータベースに入れる　今回は６項目
	private String sql="INSERT INTO user_buy_item_transaction(item_transaction_id,total_price,total_count,user_master_id,pay,insert_date) VALUES(?,?,?,?,?,?)";

	public void buyItemInfo(
			String item_transaction_id,
			String user_master_id,
			String total_price,
			String total_count,
			String pay)throws SQLException{
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, item_transaction_id);
			ps.setString(2, total_price);
			ps.setString(3, total_count);
			ps.setString(4, user_master_id);
			ps.setString(5, pay);
			ps.setString(6, dateUtil.getDate());
//	PreparedStatementに入れたsql文を実行して、データベースに値を入れる
			ps.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			con.close();
		}
	}
}
