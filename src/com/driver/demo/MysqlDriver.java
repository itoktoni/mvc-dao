package com.driver.demo;

import java.sql.DriverManager;
import java.sql.SQLException;
import com.connection.demo.AbstactSinglePatternConnection;
import com.connection.demo.InterfaceFactoryDriver;

public class MysqlDriver extends AbstactSinglePatternConnection implements InterfaceFactoryDriver {
	
	static String DRIVER;
	static String URL;
	static String USER;
	static String PASSWORD;

	@Override
	public void driver() {

		DRIVER = "com.mysql.jdbc.Driver";
		URL = "jdbc:mysql://localhost/test";
		USER = "root";
		PASSWORD = "mysql";
	}
	
	public MysqlDriver() {
		// TODO Auto-generated constructor stub
		driver();
		open();
	}

	@Override
	protected void open() {
		
		if (AbstactSinglePatternConnection.conn == null) {
			
			try {
				Class.forName(DRIVER);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				AbstactSinglePatternConnection.conn = DriverManager.getConnection(URL, USER, PASSWORD);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
