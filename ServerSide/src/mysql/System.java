package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class System {
	private static final String DB_DRIVER="com.mysql.jdbc.Driver";
	private static final String DB_URL="jdbc:mysql://127.0.0.1:3306/hackeratiAssignment";
	private static final String DB_USER="root";
	private static final String DB_PASSWORD="123456";
//	private static final String lineSeparator=System.getProperty("line.separator");	
	private static Connection conn=null;
	private static PreparedStatement preparedStatement = null;
	
	public static void main(String[] args){
		try {
			Class.forName(DB_DRIVER);
			conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		initTables(conn, "secondTable");
		initTables(conn, "minuteTable");
		initTables(conn, "hourTable");
		initTables(conn, "dayTable");
		
		ConcreteSubject concreteSubject=new ConcreteSubject();
	    secondObserver concreteObserver=new secondObserver(concreteSubject);
	    minuteObserver minuteObserver=new minuteObserver(concreteSubject);
	    hourObserver hourObserver=new hourObserver(concreteSubject);
	    dayObserver dayObserver=new dayObserver(concreteSubject);
	    concreteSubject.dataChanged();
	    
	    try {
			conn.close();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	    
	}
	
	public static void initTables(Connection conn, String tableName){
		String dropTableSQL="drop table if exists "+tableName;
		try {
			preparedStatement = conn.prepareStatement(dropTableSQL);
			preparedStatement.executeUpdate();
			String creatTableSQL="CREATE TABLE "+tableName+"(data int, date varchar(20))";
			preparedStatement = conn.prepareStatement(creatTableSQL);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
