package com.jun.oracle.jdbc;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Properties;

/**
 * 使用JDBC createStatement() 执行 select,insert,update,delete
 */
public class CreateStatement {
	
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
	public void insertData() throws Exception {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		// 连接数据库
		CreateStatement myCreateStmt = new CreateStatement();
		conn = myCreateStmt.establishConnection();

		// get the current state of this Connection object's auto-commit mode
		// 获得自动提交的状态
		boolean defaultCommit = conn.getAutoCommit();

		/* 开启事务，设定不自动提交 */
		conn.setAutoCommit(false);

		try {
			// 定义sql语句
			String sql1 = "insert into DBUSER (USER_ID,USERNAME,CREATED_BY,CREATED_DATE) values (1,'createStatement','createStatement','')";

			// 创建该连接下的CreateStatement对象
			stmt = conn.createStatement();
			// 执行SQL，将数据保存到ResultSet对象中
			rs = stmt.executeQuery(sql1);

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
			myCreateStmt.colseConnection(conn, stmt, rs);
		}

	}

	/**
	 * select data 查询数据
	 */
	public void selectData() throws Exception {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		// 连接数据库
		CreateStatement myCreateStmt = new CreateStatement();
		conn = myCreateStmt.establishConnection();

		// get the current state of this Connection object's auto-commit mode
		boolean defaultCommit = conn.getAutoCommit();
		/* 开启事务，设定不自动提交 */
		conn.setAutoCommit(false);

		try {
			
			String username ="createStatement";
			String CREATED_BY = "name' OR 'a'='a";
			//String CREATED_BY = "createStatement";
			String sql2 = "select * from DBUSER where username="+ "'"+username+"'"+"AND CREATED_BY ="+"'"+CREATED_BY+"'";

			// 创建该连接下的CreateStatement对象
			stmt = conn.createStatement();

			// 执行SQL，将数据保存到ResultSet对象中
			rs = stmt.executeQuery(sql2);

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
			myCreateStmt.colseConnection(conn, stmt, rs);
		}

	}

	/**
	 * update data 更新数据
	 */
	public void updateData() throws Exception {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		// 连接数据库
		CreateStatement myCreateStmt = new CreateStatement();
		conn = myCreateStmt.establishConnection();

		// get the current state of this Connection object's auto-commit mode
		boolean defaultCommit = conn.getAutoCommit();
		/* 开启事务，设定不自动提交 */
		conn.setAutoCommit(false);

		try {
			String sql3 = "update DBUSER set username='Jeff' where created_by='createStatement'";
			// 创建该连接下的createStatement对象
			stmt = conn.createStatement();

			// 执行查询语句，将数据保存到ResultSet对象中
			rs = stmt.executeQuery(sql3);

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
			myCreateStmt.colseConnection(conn, stmt, rs);
		}

	}

	/**
	 * delete data 删除数据
	 */
	public void deleteData() throws Exception {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		// 连接数据库
		CreateStatement myCreateStmt = new CreateStatement();
		conn = myCreateStmt.establishConnection();

		// get the current state of this Connection object's auto-commit mode
		boolean defaultCommit = conn.getAutoCommit();
		/* 开启事务，设定不自动提交 */
		conn.setAutoCommit(false);

		try {
			String sql4 = "delete from DBUSER where created_by='createStatement'";
			// 创建该连接下的createStatement对象
			stmt = conn.createStatement();

			// 执行SQL，将数据保存到ResultSet对象中
			rs = stmt.executeQuery(sql4);

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
			myCreateStmt.colseConnection(conn, stmt, rs);
		}

	}

	/**
	 * close the connection 释放资源
	 */
	public void colseConnection(Connection conn, Statement stmt, ResultSet rs) {

		if (rs != null) {
			try {
				// 关闭存储查询结果的ResultSet对象
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			rs = null;
		}
		if (stmt != null) {
			try {
				// 关闭负责执行SQL命令的CreateStatement对象
				stmt.close();
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
