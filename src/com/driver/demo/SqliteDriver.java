package com.driver.demo;

import java.sql.DriverManager;
import javax.servlet.Servlet;
import java.sql.SQLException;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;

import org.apache.tomcat.jni.File;

import com.connection.demo.AbstactSinglePatternConnection;
import com.connection.demo.InterfaceFactoryDriver;

import sun.misc.Resource;

public class SqliteDriver extends AbstactSinglePatternConnection implements InterfaceFactoryDriver {
	
	static String DRIVER;
	static String URL;
	static String USER;
	static String PASSWORD;

	@Override
	public void driver() {

		DRIVER = "org.sqlite.JDBC";
		URL = "jdbc:sqlite:D:/sqlite.db";
	}
	
	public SqliteDriver() {
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
				String local = System.getProperty("user.dir");
				AbstactSinglePatternConnection.conn = DriverManager.getConnection(URL);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
	}

}
