package do_an1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import do_an1.Data;

public class Data {

	static Connection getConnection() throws ClassNotFoundException, SQLException {	
		try {
			Connection connection = null;
			String userName = "sa";
			String password = "123456789";
			String url = "jdbc:sqlserver://THUONG\\SQLEXPRESS:1433;databaseName=doanjava";
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				connection = DriverManager.getConnection(url, userName,password );		
				return connection;	
		} catch(Exception e) {
			System.out.println("connect error");
		}
		return null;
		
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection connection = Data.getConnection();
	}

}
