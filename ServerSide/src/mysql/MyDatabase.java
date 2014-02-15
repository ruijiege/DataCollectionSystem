package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import data.MyData;

public class MyDatabase {
	private static final String DB_DRIVER="com.mysql.jdbc.Driver";
	private static final String DB_URL="jdbc:mysql://127.0.0.1:3306/hackeratiAssignment";
	private static final String DB_USER="root";
	private static final String DB_PASSWORD="123456";
//	private static final String lineSeparator=System.getProperty("line.separator");	
	private static Connection conn=null;
	private static PreparedStatement preparedStatement = null;
	
	public static void writeDatabase(MyData mydata, final String tableName){
		try {
			//load the MySQL driver
			Class.forName(DB_DRIVER);
			conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
		    
			preparedStatement = conn.prepareStatement("insert into "+tableName+" values (?, ?)");
		    preparedStatement.setInt(1, mydata.getData());
		    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		    preparedStatement.setString(2,dateFormat.format(mydata.getDate()));
		    preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
		    try {
				conn.close();
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
	}
	
	
	public static void main(String[] args){
		
	}
}
