package uitls;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionManager { 
	private static Connection conn = null;

	private ConnectionManager() {

	}

	public static Connection getConnection() {
		try {
			if (conn == null || conn.isClosed()) {
				Class.forName("com.mysql.jdbc.Driver");
				InputStream in=ConnectionManager.class.getResourceAsStream("/db.properties");			
				Properties pro = new Properties();
				pro.load(in);
				conn =DriverManager.getConnection(
						pro.getProperty("url")+
						pro.getProperty("dbname"),
						pro.getProperty("name"),
						pro.getProperty("pass"));
				
			}
		} catch (Exception e) { 
			System.err.println("数据连接失败");
			e.printStackTrace();
		}
		return conn;

	}

}
