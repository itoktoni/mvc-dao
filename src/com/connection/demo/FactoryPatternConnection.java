package com.connection.demo;

import com.driver.demo.MysqlDriver;
import com.driver.demo.SqliteDriver;

public class FactoryPatternConnection{
	
	public static AbstactSinglePatternConnection Driver(String driver) {
		if(driver == "mysql") {
			return new MysqlDriver();
		}
		else if(driver == "sqlite") {
			return new SqliteDriver();
		}
		return null;
	}
	
}
