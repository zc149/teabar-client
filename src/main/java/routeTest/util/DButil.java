package routeTest.util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DButil {
	
	private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";

	public static String getDriverName() {
		return DRIVER_NAME;
	}
	
	
	
	public static Connection getConnection() {
	
		try {

			final String DB_URL = "jdbc:mysql://192.168.0.170/"; // 교육장 IP로 수정해야함
			final String DATABASE_NAME = "teabar";
			final String USER = "guest";
			final String PASSWORD = "1234";
			
			return DriverManager.getConnection(DB_URL + DATABASE_NAME, USER, PASSWORD);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
