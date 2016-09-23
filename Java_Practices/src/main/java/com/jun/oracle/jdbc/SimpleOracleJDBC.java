package com.jun.oracle.jdbc;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Properties;

/**
 * 使用JDBC执行 select insert update delete
 */
public class SimpleOracleJDBC {

	String dbDriver;
	String dbHost;
	String dbPort;
	String dbInstance;
	String dbConnUsername;
	String dbConnPassword;

	/**
	 * Get oracle connection from db.properties
	 */
	public void getOracleConnection() {
		try {

			// create a object pro of Properties class
			Properties pro = new Properties();
			// create object inptStream of InputStream class, read db.properties
			// into object inptStream
			InputStream inptStream = this.getClass().getClassLoader()
					.getResourceAsStream("com/jun/oracle/jdbc/db.properties");
			// load object inptStream of InputStream class
			pro.load(inptStream);

			// get oracleDb_Driver value from db.properties
			dbDriver = pro.getProperty("oracleDb_Driver");
			// get oracleDb_Host value from db.properties
			dbHost = pro.getProperty("oracleDb_Host");
			// get oracleDb_Port value from db.properties
			dbPort = pro.getProperty("oracleDb_Port");
			// get oracleDb_Instance value from db.properties
			dbInstance = pro.getProperty("oracleDb_Instance");
			// get oracleDb_UserName value from db.properties
			dbConnUsername = pro.getProperty("oracleDb_UserName");
			// get oracleDb_Password value from db.properties
			dbConnPassword = pro.getProperty("oracleDb_Password");

			// Closes this input stream and releases any system resources
			// associated with the stream.
			inptStream.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("FAIL: Error when getting db properity.\n");
		}
	}

	/**
	 * Establishing a connection
	 */
	public Connection establishConnection() {

		// create a conn object of Connection class, this object is assigned
		Connection conn = null;

		// invoke dbGetProperity method
		this.getOracleConnection();
		try {
			// define oracle connection url
			String url = "jdbc:oracle:thin:@" + dbHost + ":" + dbPort + ":" + dbInstance + "";
			// load database driver
			Class.forName(dbDriver);
			// connect database
			conn = DriverManager.getConnection(url, dbConnUsername, dbConnPassword);
		} catch (ClassNotFoundException e) {
			// throws a ClassNotFound exception if driver load failure
			e.printStackTrace();
			System.out.println("FAIL: Class not found when load oracle driver.\n");
		} catch (SQLException e) {
			// throws a database access exception if database connection failure
			e.printStackTrace();
			System.out.println(
					"FAIL: Error when getting database connection.\n" + e.getErrorCode() + " : " + e.getMessage());
		}
		return conn;
	}

	
	/**
	 * 增加数据
	 */
	public void insertData(int userID, String userName, String createdBy, Date startTime) throws Exception {

		// declare pstmt object of PreparedStatement class
		PreparedStatement pstmt = null;
		// declare rs object of ResultSet class
		ResultSet rs = null;
		// declare conn object of Connection class
		Connection conn = null;

		// instantiate object myJdbcUtils of JdbcUtils class
		SimpleOracleJDBC myJdbcUtils = new SimpleOracleJDBC();
		// invoke dbConnection method of myJdbcUtils object
		conn = myJdbcUtils.establishConnection();

		// get the current state of this Connection object's auto-commit mode
		boolean defaultCommit = conn.getAutoCommit();
		/* 开启事务，设定不自动提交 */
		conn.setAutoCommit(false);

		// 插入
		try {
			String sq2 = "insert into DBUSER (USER_ID,USERNAME,CREATED_BY,CREATED_DATE) values (?,?,?,?)";
			// 创建该连接下的PreparedStatement对象
			pstmt = conn.prepareStatement(sq2);

			// 传递第一个参数值 ，代替第一个问号
			pstmt.setInt(1, userID);
			// 传递第二个参数值 ，代替第二个问号
			pstmt.setString(2, userName);
			// 传递第三个参数值 ，代替第三个问号
			pstmt.setString(3, createdBy);
			// 传递第四个参数值 ，代替第四个问号
			pstmt.setTimestamp(4, new Timestamp(System.currentTimeMillis()));

			// 执行查询语句，将数据保存到ResultSet对象中
			rs = pstmt.executeQuery();

			/* 正式提交 */
			conn.commit();
			System.out.println("插入成功");

		} catch (Exception ex) {
			/* 出错回滚 */
			conn.rollback();
			throw ex;
		}

		finally {
			/* 恢复原提交状态 */
			conn.setAutoCommit(defaultCommit);
			// close the connection
			myJdbcUtils.colseConnection(conn, pstmt, rs);
		}

	}
	
	/**
	 *  查询数据           
	 */
	public void selectData() throws Exception {

		// declare pstmt object of PreparedStatement class
		PreparedStatement pstmt = null;
		// declare rs object of ResultSet class
		ResultSet rs = null;
		// declare conn object of Connection class
		Connection conn = null;

		// instantiate object myJdbcUtils of JdbcUtils class
		SimpleOracleJDBC myJdbcUtils = new SimpleOracleJDBC();
		// invoke dbConnection method of myJdbcUtils object
		conn = myJdbcUtils.establishConnection();

		// get the current state of this Connection object's auto-commit mode
		boolean defaultCommit = conn.getAutoCommit();
		/* 开启事务，设定不自动提交 */
		conn.setAutoCommit(false);

		try {
			String sql1 = "select * from DBUSER";
			// 创建该连接下的PreparedStatement对象
			pstmt = conn.prepareStatement(sql1);

			// 执行查询语句，将数据保存到ResultSet对象中
			rs = pstmt.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getInt("USER_ID") + rs.getString("USERNAME") + rs.getString("CREATED_BY")
						+ rs.getTimestamp("CREATED_DATE"));
			}
			
			/* 正式提交 */
			conn.commit();
			System.out.println("查询成功");
		} catch (Exception ex) {
			/* 出错回滚 */
			conn.rollback();
			throw ex;
		}
				
		finally {
			/* 恢复原提交状态 */
			conn.setAutoCommit(defaultCommit);
			// close the connection
			myJdbcUtils.colseConnection(conn, pstmt, rs);
		}

	}
	
	/**
	 *  更新数据       
	 */
	public void updateData() throws Exception {

		// declare pstmt object of PreparedStatement class
		PreparedStatement pstmt = null;
		// declare rs object of ResultSet class
		ResultSet rs = null;
		// declare conn object of Connection class
		Connection conn = null;

		// instantiate object myJdbcUtils of JdbcUtils class
		SimpleOracleJDBC myJdbcUtils = new SimpleOracleJDBC();
		// invoke dbConnection method of myJdbcUtils object
		conn = myJdbcUtils.establishConnection();

		// get the current state of this Connection object's auto-commit mode
		boolean defaultCommit = conn.getAutoCommit();
		/* 开启事务，设定不自动提交 */
		conn.setAutoCommit(false);

		try {
			String sql3 = "update DBUSER set username='Jack' where created_by='jeff'";
			// 创建该连接下的PreparedStatement对象
			pstmt = conn.prepareStatement(sql3);

			// 执行查询语句，将数据保存到ResultSet对象中
			rs = pstmt.executeQuery();
			
			/* 正式提交 */
			conn.commit();
			System.out.println("更新成功");
			
		} catch (Exception ex) {
			/* 出错回滚 */
			conn.rollback();
			throw ex;
		}
				
		finally {
			/* 恢复原提交状态 */
			conn.setAutoCommit(defaultCommit);
			// close the connection
			myJdbcUtils.colseConnection(conn, pstmt, rs);
		}

	}
	
	/**
	 *  删除数据       
	 */
	public void deleteData() throws Exception {

		// declare pstmt object of PreparedStatement class
		PreparedStatement pstmt = null;
		// declare rs object of ResultSet class
		ResultSet rs = null;
		// declare conn object of Connection class
		Connection conn = null;

		// instantiate object myJdbcUtils of JdbcUtils class
		SimpleOracleJDBC myJdbcUtils = new SimpleOracleJDBC();
		// invoke dbConnection method of myJdbcUtils object
		conn = myJdbcUtils.establishConnection();

		// get the current state of this Connection object's auto-commit mode
		boolean defaultCommit = conn.getAutoCommit();
		/* 开启事务，设定不自动提交 */
		conn.setAutoCommit(false);

		try {
			String sql4 = "delete from DBUSER where created_by='jeff'";
			// 创建该连接下的PreparedStatement对象
			pstmt = conn.prepareStatement(sql4);

			// 执行查询语句，将数据保存到ResultSet对象中
			rs = pstmt.executeQuery();
			
			/* 正式提交 */
			conn.commit();
			System.out.println("删除成功");
			
		} catch (Exception ex) {
			/* 出错回滚 */
			conn.rollback();
			throw ex;
		}
				
		finally {
			/* 恢复原提交状态 */
			conn.setAutoCommit(defaultCommit);
			// close the connection
			myJdbcUtils.colseConnection(conn, pstmt, rs);
		}

	}

	/**
	 * 关闭连接 close the connection
	 */
	public void colseConnection(Connection conn, PreparedStatement pstmt, ResultSet rs) {

		if (rs != null) {
			try {
				// 关闭存储查询结果的ResultSet对象
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			rs = null;
		}
		if (pstmt != null) {
			try {
				// 关闭负责执行SQL命令的PreparedStatement对象
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (conn != null) {
			try {
				// 关闭Connection数据库连接对象
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
