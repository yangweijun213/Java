package com.jun.jdbc;

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
 * 使用JDBC prepareStatement() 执行 select,insert,update,delete
 */
public class PrepareStatement {

	String dbDriver;
	String dbHost;
	String dbPort;
	String dbInstance;
	String dbConnUsername;
	String dbConnPassword;

	/**
	 * read file db.properities 读文件db.properities (key and value pair 键值对)
	 */
	public void getOracleConnection() {
		try {

			// create a object pro of Properties class 新建一个Properties类的对象
			Properties pro = new Properties();
			// create object inptStream of InputStream class and read
			// db.properties
			// 新建一个InputStream类的对象，读文件db.properties
			InputStream inptStream = this.getClass().getClassLoader()
					.getResourceAsStream("com/jun/oracle/jdbc/db.properties");
			// load object inptStream of InputStream class 加载InputStream类的对象
			pro.load(inptStream);

			// get oracleDb_Driver value 读取oracleDb_Driver值
			dbDriver = pro.getProperty("oracleDb_Driver");
			// get oracleDb_Host value 读取 oracleDb_Host值
			dbHost = pro.getProperty("oracleDb_Host");
			// get oracleDb_Port value 读取 oracleDb_Port端口
			dbPort = pro.getProperty("oracleDb_Port");
			// get oracleDb_Instance value 读取oracle实例
			dbInstance = pro.getProperty("oracleDb_Instance");
			// get oracleDb_UserName value 读取oracle登录用户名
			dbConnUsername = pro.getProperty("oracleDb_UserName");
			// get oracleDb_Password value 读取oracle登录密码
			dbConnPassword = pro.getProperty("oracleDb_Password");

			// Closes this inputstream and releases any system resources
			// associated with the stream.
			// 关闭输入流和释放关联输入流的资源
			inptStream.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("FAIL: Error when getting db properity.\n");
		}
	}

	/**
	 * Establishing a connection 建立连接
	 */
	public Connection establishConnection() {

		Connection conn = null;

		try {
			// 注册驱动
			this.getOracleConnection();
			Class.forName(dbDriver);

			// 获取连接
			String url = "jdbc:oracle:thin:@" + dbHost + ":" + dbPort + ":" + dbInstance + "";
			conn = DriverManager.getConnection(url, dbConnUsername, dbConnPassword);

		} catch (ClassNotFoundException e) {

			// throws a ClassNotFound exception if driver load failure
			// 如果驱动加载失败抛出异常
			e.printStackTrace();
			System.out.println("FAIL: Class not found when load oracle driver.\n");
		} catch (SQLException e) {

			// throws a database access exception if database connection failure
			// 如果数据库连接失败抛出异常
			e.printStackTrace();
			System.out.println(
					"FAIL: Error when getting database connection.\n" + e.getErrorCode() + " : " + e.getMessage());
		}
		return conn;
	}

	/**
	 * insert data 添加数据
	 */
	public void insertData(int userID, String userName, String createdBy, Date startTime) throws Exception {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// 连接数据库
		PrepareStatement myPreStmt = new PrepareStatement();
		conn = myPreStmt.establishConnection();

		// get the current state of this Connection object's auto-commit mode
		// 获得自动提交的状态
		boolean defaultCommit = conn.getAutoCommit();

		/* 开启事务，设定不自动提交 */
		conn.setAutoCommit(false);

		try {
			// 定义sql语句，values用？代替
			String sq1 = "insert into DBUSER (USER_ID,USERNAME,CREATED_BY,CREATED_DATE) values (?,?,?,?)";

			// 创建该连接下的PreparedStatement对象
			pstmt = conn.prepareStatement(sq1);
			// 传递第一个参数值 ，代替第一个问号
			pstmt.setInt(1, userID);
			// 传递第二个参数值 ，代替第二个问号
			pstmt.setString(2, userName);
			// 传递第三个参数值 ，代替第三个问号
			pstmt.setString(3, createdBy);
			// 传递第四个参数值 ，代替第四个问号
			pstmt.setTimestamp(4, new Timestamp(System.currentTimeMillis()));

			// 执行SQL，将数据保存到ResultSet对象中
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
			// 释放资源
			myPreStmt.colseConnection(conn, pstmt, rs);
		}

	}

	/**
	 * select data 查询数据
	 */
	public void selectData() throws Exception {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// 连接数据库
		PrepareStatement myPreStmt = new PrepareStatement();
		conn = myPreStmt.establishConnection();

		// get the current state of this Connection object's auto-commit mode
		boolean defaultCommit = conn.getAutoCommit();
		/* 开启事务，设定不自动提交 */
		conn.setAutoCommit(false);

		try {
			String sql2 = "select * from DBUSER";

			// 创建该连接下的PreparedStatement对象
			pstmt = conn.prepareStatement(sql2);

			// 执行SQL，将数据保存到ResultSet对象中
			rs = pstmt.executeQuery();

			// 每次循环，都取出一条记录
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
			// 释放资源
			myPreStmt.colseConnection(conn, pstmt, rs);
		}

	}

	/**
	 * update data 更新数据
	 */
	public void updateData() throws Exception {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = null;

		// 连接数据库
		PrepareStatement myPreStmt = new PrepareStatement();
		conn = myPreStmt.establishConnection();

		// get the current state of this Connection object's auto-commit mode
		boolean defaultCommit = conn.getAutoCommit();
		/* 开启事务，设定不自动提交 */
		conn.setAutoCommit(false);

		try {
			String sql3 = "update DBUSER set username='Jeff' where created_by='PrepareStatement'";
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
			// 释放资源
			myPreStmt.colseConnection(conn, pstmt, rs);
		}

	}

	/**
	 * delete data 删除数据
	 */
	public void deleteData() throws Exception {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// 连接数据库
		PrepareStatement myPreStmt = new PrepareStatement();
		conn = myPreStmt.establishConnection();

		// get the current state of this Connection object's auto-commit mode
		boolean defaultCommit = conn.getAutoCommit();
		/* 开启事务，设定不自动提交 */
		conn.setAutoCommit(false);

		try {
			String sql4 = "delete from DBUSER where created_by='PrepareStatement'";
			// 创建该连接下的PreparedStatement对象
			pstmt = conn.prepareStatement(sql4);

			// 执行SQL，将数据保存到ResultSet对象中
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
			// 释放资源
			myPreStmt.colseConnection(conn, pstmt, rs);
		}

	}

	/**
	 * close the connection 释放资源
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