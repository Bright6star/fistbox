package dao;

import java.sql.*;;

public class Connect {
	//连接数据库
	public static void main(String[] args) {
		
		String name="root";
		String pass="root";
		String dbname="text";
		String url="jdbc:mysql://localhost:3306/";
		try{
		Connection con=DriverManager.getConnection(url+dbname,name,pass);
		Statement sta=con.createStatement();
		
		String select="SELECT userName FROM `user`";
		ResultSet res=sta.executeQuery(select);
		while(res.next()){
			
			System.out.println(res.getString(1));
		}
		}catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
