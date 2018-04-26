package com.dao.demo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.connection.demo.AbstactSinglePatternConnection;
import com.connection.demo.FactoryPatternConnection;
import com.entity.demo.UserModel;

public class UserDao implements InterfaceUser{

	List<UserModel> data = new ArrayList<UserModel>();
	@Override
	public void create(UserModel user) {
		// TODO Auto-generated method stub
		AbstactSinglePatternConnection MySql = FactoryPatternConnection.Driver("mysql");
		
		PreparedStatement insert = MySql.prepare("insert into users(username,email,password) values(?,?,?)");
		try {
			insert.setString(1, user.username);
			insert.setString(2, user.password);
			insert.setString(3, user.email);
			insert.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<UserModel> read() {
		
		AbstactSinglePatternConnection Sqlite = FactoryPatternConnection.Driver("sqlite");
		ResultSet rs = Sqlite.query("select * from users");
		
		try {
			while(rs.next()) {
				try {
					data.add(new UserModel(rs.getString("username"), rs.getString("password"), rs.getString("email")));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return data;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}
	
	
}
