package com.internousdev.myEcsite.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.myEcsite.dto.LoginDTO;
import com.internousdev.myEcsite.util.DBConnector;

public class LoginDAO {
	private DBConnector db=new DBConnector();
	private Connection con=db.getConnection();
	private LoginDTO loginDTO=new LoginDTO();

//	loginUserIdとloginPasswordはString型の変数
//	LoginDTO型は参照型 LoginDTOの住所があるから、そこにあるメソッドを動かせる
	public LoginDTO getLoginUserInfo(String loginUserId,String loginPassword) {
		String sql="SELECT *FROM login_user_transaction where login_id=? AND login_pass=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,loginUserId);
			ps.setString(2, loginPassword);

			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				loginDTO.setLoginId(rs.getString("login_id"));
				loginDTO.setLoginPassword(rs.getString("login_pass"));
				loginDTO.setUserName(rs.getString("user_name"));

				if(!(rs.getString("login_id").equals(null))) {
					loginDTO.setLoginFlg(true);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return loginDTO;
	}
	public LoginDTO getloginDTO() {
		return loginDTO;
	}
}
