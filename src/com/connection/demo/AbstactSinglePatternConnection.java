package com.connection.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class AbstactSinglePatternConnection {

	protected static Connection conn;
	private static Statement stmt;
	private static ResultSet rs;
	
	public static ResultSet query(String sql) {
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql.toUpperCase().trim());
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public static PreparedStatement prepare(String sql) {
		PreparedStatement pre = null;
		try {
			pre = conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pre;
	}

	
	protected abstract void open();

}
