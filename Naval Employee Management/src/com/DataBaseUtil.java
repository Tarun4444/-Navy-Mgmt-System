package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseUtil {
	/*Code for getConnection() method:*/
	public static Connection connection=null;
	static String url="jdbc:oracle:thin:@localhost:1521:XE";
	
	public static Connection getConnection(){
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			closeConnection();
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection(url,"SYSTEM","Rfh63100@");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	/* Code for CloseConnection():*/
	public static void closeConnection(){
		try{
			if(connection != null && connection.isClosed() == false){
				connection.close();
				connection = null;
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
}
