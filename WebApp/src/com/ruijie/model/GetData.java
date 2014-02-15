package com.ruijie.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class GetData {
	private static final String DB_DRIVER="com.mysql.jdbc.Driver";
	private static final String DB_URL="jdbc:mysql://127.0.0.1:3306/hackeratiAssignment";
	private static final String DB_USER="root";
	private static final String DB_PASSWORD="123456";
//	private static final String lineSeparator=System.getProperty("line.separator");	
	private static Connection conn=null;
	private Statement statement = null;
	private static ResultSet rs=null;
	
	public ResultSet myData(String interval){
		System.out.println(interval);
		try {
			Class.forName(DB_DRIVER);
			conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
			statement = conn.createStatement();
			if(interval.equals("second")){				
			    rs=statement.executeQuery("select * from secondTable");
			}else if(interval.equals("minute")){
				rs=statement.executeQuery("select * from minuteTable");
			}else if(interval.equals("hour")){
				rs=statement.executeQuery("select * from hourTable");
			}else if(interval.equals("day")){
				rs=statement.executeQuery("select * from dayTable");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
