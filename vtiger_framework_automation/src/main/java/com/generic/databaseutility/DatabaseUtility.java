package com.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DatabaseUtility {
	Connection conn=null;
	public void getConnectionToDatabase(String url,String username,String password) throws SQLException {
		try {
		Driver driverref=new  Driver();
		DriverManager.registerDriver(driverref);
		conn=DriverManager.getConnection(url,username,password);
	}catch(Exception e) {
		System.out.println(e.getMessage());
	}

}
	public void getConnectionToDatabase() throws SQLException {
		Connection conn=null;
		try {
		Driver driverref=new  Driver();
		DriverManager.registerDriver(driverref);
		conn=DriverManager.getConnection("jdbc:Mysql://localhost:3306/company","root","root");
	}catch(Exception e) {
		System.out.println(e.getMessage());
	}

}
	public void closeDatabaseConnection() {
		try {
			conn.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
			
		}
	}
	public ResultSet executeSelectQuery(String query) {
		ResultSet result=null;
		try {
			 Statement stat=conn.createStatement();
               result= stat.executeQuery(query);			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return  result;
	}
	public int executeNonSelectQuery(String query) {
		int value=0;
		try {
		Statement stat=	conn.createStatement();
	value=	stat.executeUpdate(query);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		return value;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}