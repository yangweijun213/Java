package com.lrm.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseConnection {
	private static final String DBDRIVER="oracle.jdbc.driver.OracleDriver";
	private static final String DBURL="jdbc:oracle:thin:@172.20.20.35:1521:ora11g";
	private static final String DBUSER="PERF_SANITYTESTREPORT";
	private static final String DBPASSWORD="creditderivative";
	private Connection conn =null;
	
	public DatabaseConnection(){
		try {
			Class.forName(DBDRIVER);
			this.conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		System.out.println("连接数据库成功");
	}
	
	public Connection getConnection(){
		return this.conn;
	}
	
	public void close(){
		if(this.conn != null){
			try {
				this.conn.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}

}
