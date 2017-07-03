package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dto.Type;
import dto.User;
import dto.noice;
import uitls.ConnectionManager;

public class UserDao {
	
	private Connection conn = null;
	PreparedStatement ps = null;
	//验证用户名和密码
	public User getUser(User user) {
			
		User u=null;
		
		conn = ConnectionManager.getConnection();
		String select = "select * from user where userName = ? and userPass = ?";
		
		try {		
			ps = conn.prepareStatement(select);
			
			ps.setString(1, user.getName());
			ps.setString(2, user.getPassword());
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				int id = rs.getInt("id");
				
				String name = rs.getString("userName");
					
				String password = rs.getString("userPass");
				
				Date loginTime = rs.getDate("createtime");
				
				int root=rs.getInt("root");
				
				u=new User();
				u.setId(id);
				u.setName(name);
				u.setPassword(password);
				u.setLoginTime(loginTime);
				u.setRoot(root);

			}
			System.out.println(u);
		} catch (Exception e) {

		}
		return u;
	}
	//根据id查用户信息
	public User getUserById(int userId){
		User u = null;
		conn = ConnectionManager.getConnection();
		String selectSQL = "select * from user where id = ?";
		try {
			ps = conn.prepareStatement(selectSQL);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				//获取列数据
				int id = rs.getInt("id");
				String name = rs.getString("userName");
				String password = rs.getString("userPass");
				Date loginTime = rs.getTimestamp("createtime");
				u = new User();
				u.setId(id);
				u.setPassword(password);
				u.setName(name);
				u.setLoginTime(loginTime);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return u;
	}
	

}
