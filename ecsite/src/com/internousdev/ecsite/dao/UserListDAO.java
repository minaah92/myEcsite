package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.LoginDTO;
import com.internousdev.ecsite.util.DBConnector;

public class UserListDAO {
	public ArrayList<LoginDTO> getUserInfo()throws SQLException{
		ArrayList<LoginDTO> userList=new ArrayList<LoginDTO>();
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();

		String sql="SELECT *FROM login_user_transaction ORDER BY insert_date DESC";
		try {
			PreparedStatement ps=con.prepareStatement(sql);

			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				LoginDTO dto=new LoginDTO();
				dto.setLoginId(rs.getString("login_id"));
				dto.setLoginPassword(rs.getString("login_pass"));
				dto.setUserName(rs.getString("user_name"));
				if(rs.getString("admin_flg")!=null){
					dto.setAdminFlg("☆");
				}else {
					dto.setAdminFlg("");
				}
//				dto.setAdminFlg(rs.getString("admin_flg"));
				userList.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			con.close();
		}
		return userList;
	}

}
