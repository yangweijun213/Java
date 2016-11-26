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
 * 浣跨敤JDBC prepareStatement() 鎵ц select,insert,update,delete
 */
public class PrepareStatement {

	String dbDriver;
	String dbHost;
	String dbPort;
	String dbInstance;
	String dbConnUsername;
	String dbConnPassword;

	/**
	 * read file db.properities 璇绘枃浠禿b.properities (key and value pair 閿�煎)
	 */
	public void getOracleConnection() {
		try {

			// create a object pro of Properties class 鏂板缓涓�涓狿roperties绫荤殑瀵硅薄
			Properties pro = new Properties();
			// create object inptStream of InputStream class and read
			// db.properties
			// 鏂板缓涓�涓狪nputStream绫荤殑瀵硅薄锛岃鏂囦欢db.properties
			InputStream inptStream = this.getClass().getClassLoader()
					.getResourceAsStream("com/jun/oracle/jdbc/db.properties");
			// load object inptStream of InputStream class 鍔犺浇InputStream绫荤殑瀵硅薄
			pro.load(inptStream);

			// get oracleDb_Driver value 璇诲彇oracleDb_Driver鍊�
			dbDriver = pro.getProperty("oracleDb_Driver");
			// get oracleDb_Host value 璇诲彇 oracleDb_Host鍊�
			dbHost = pro.getProperty("oracleDb_Host");
			// get oracleDb_Port value 璇诲彇 oracleDb_Port绔彛
			dbPort = pro.getProperty("oracleDb_Port");
			// get oracleDb_Instance value 璇诲彇oracle瀹炰緥
			dbInstance = pro.getProperty("oracleDb_Instance");
			// get oracleDb_UserName value 璇诲彇oracle鐧诲綍鐢ㄦ埛鍚�
			dbConnUsername = pro.getProperty("oracleDb_UserName");
			// get oracleDb_Password value 璇诲彇oracle鐧诲綍瀵嗙爜
			dbConnPassword = pro.getProperty("oracleDb_Password");

			// Closes this inputstream and releases any system resources
			// associated with the stream.
			// 鍏抽棴杈撳叆娴佸拰閲婃斁鍏宠仈杈撳叆娴佺殑璧勬簮
			inptStream.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("FAIL: Error when getting db properity.\n");
		}
	}

	/**
	 * Establishing a connection 寤虹珛杩炴帴
	 */
	public Connection establishConnection() {

		Connection conn = null;

		try {
			// 娉ㄥ唽椹卞姩
			this.getOracleConnection();
			Class.forName(dbDriver);
			
			

			// 鑾峰彇杩炴帴
			String url = "jdbc:oracle:thin:@" + dbHost + ":" + dbPort + ":" + dbInstance + "";
			conn = DriverManager.getConnection(url, dbConnUsername, dbConnPassword);

		} catch (ClassNotFoundException e) {

			// throws a ClassNotFound exception if driver load failure
			// 濡傛灉椹卞姩鍔犺浇澶辫触鎶涘嚭寮傚父
			e.printStackTrace();
			System.out.println("FAIL: Class not found when load oracle driver.\n");
		} catch (SQLException e) {

			// throws a database access exception if database connection failure
			// 濡傛灉鏁版嵁搴撹繛鎺ュけ璐ユ姏鍑哄紓甯�
			e.printStackTrace();
			System.out.println(
					"FAIL: Error when getting database connection.\n" + e.getErrorCode() + " : " + e.getMessage());
		}
		return conn;
	}

	/**
	 * insert data 娣诲姞鏁版嵁
	 */
	public void insertData(int userID, String userName, String createdBy, Date startTime) throws Exception {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// 杩炴帴鏁版嵁搴�
		PrepareStatement myPreStmt = new PrepareStatement();
		conn = myPreStmt.establishConnection();

		// get the current state of this Connection object's auto-commit mode
		// 鑾峰緱鑷姩鎻愪氦鐨勭姸鎬�
		boolean defaultCommit = conn.getAutoCommit();

		/* 寮�鍚簨鍔★紝璁惧畾涓嶈嚜鍔ㄦ彁浜� */
		conn.setAutoCommit(false);

		try {
			// 瀹氫箟sql璇彞锛寁alues鐢紵浠ｆ浛
			String sq1 = "insert into DBUSER (USER_ID,USERNAME,CREATED_BY,CREATED_DATE) values (?,?,?,?)";

			// 鍒涘缓璇ヨ繛鎺ヤ笅鐨凱reparedStatement瀵硅薄
			pstmt = conn.prepareStatement(sq1);
			// 浼犻�掔涓�涓弬鏁板�� 锛屼唬鏇跨涓�涓棶鍙�
			pstmt.setInt(1, userID);
			// 浼犻�掔浜屼釜鍙傛暟鍊� 锛屼唬鏇跨浜屼釜闂彿
			pstmt.setString(2, userName);
			// 浼犻�掔涓変釜鍙傛暟鍊� 锛屼唬鏇跨涓変釜闂彿
			pstmt.setString(3, createdBy);
			// 浼犻�掔鍥涗釜鍙傛暟鍊� 锛屼唬鏇跨鍥涗釜闂彿
			pstmt.setTimestamp(4, new Timestamp(System.currentTimeMillis()));

			// 鎵цSQL锛屽皢鏁版嵁淇濆瓨鍒癛esultSet瀵硅薄涓�
			rs = pstmt.executeQuery();

			/* 姝ｅ紡鎻愪氦 */
			conn.commit();
			System.out.println("鎻掑叆鎴愬姛");

		} catch (Exception ex) {
			/* 鍑洪敊鍥炴粴 */
			conn.rollback();
			throw ex;
		}

		finally {
			/* 鎭㈠鍘熸彁浜ょ姸鎬� */
			conn.setAutoCommit(defaultCommit);
			// 閲婃斁璧勬簮
			myPreStmt.colseConnection(conn, pstmt, rs);
		}

	}

	/**
	 * select data 鏌ヨ鏁版嵁
	 */
	public void selectData() throws Exception {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// 杩炴帴鏁版嵁搴�
		PrepareStatement myPreStmt = new PrepareStatement();
		conn = myPreStmt.establishConnection();

		// get the current state of this Connection object's auto-commit mode
		boolean defaultCommit = conn.getAutoCommit();
		/* 寮�鍚簨鍔★紝璁惧畾涓嶈嚜鍔ㄦ彁浜� */
		conn.setAutoCommit(false);

		try {
			String sql2 = "select * from DBUSER";

			// 鍒涘缓璇ヨ繛鎺ヤ笅鐨凱reparedStatement瀵硅薄
			pstmt = conn.prepareStatement(sql2);

			// 鎵цSQL锛屽皢鏁版嵁淇濆瓨鍒癛esultSet瀵硅薄涓�
			rs = pstmt.executeQuery();

			// 姣忔寰幆锛岄兘鍙栧嚭涓�鏉¤褰�
			while (rs.next()) {
				System.out.println(rs.getInt("USER_ID") + rs.getString("USERNAME") + rs.getString("CREATED_BY")
						+ rs.getTimestamp("CREATED_DATE"));
			}

			/* 姝ｅ紡鎻愪氦 */
			conn.commit();
			System.out.println("鏌ヨ鎴愬姛");
		} catch (Exception ex) {
			/* 鍑洪敊鍥炴粴 */
			conn.rollback();
			throw ex;
		}

		finally {
			/* 鎭㈠鍘熸彁浜ょ姸鎬� */
			conn.setAutoCommit(defaultCommit);
			// 閲婃斁璧勬簮
			myPreStmt.colseConnection(conn, pstmt, rs);
		}

	}

	/**
	 * update data 鏇存柊鏁版嵁
	 */
	public void updateData() throws Exception {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = null;

		// 杩炴帴鏁版嵁搴�
		PrepareStatement myPreStmt = new PrepareStatement();
		conn = myPreStmt.establishConnection();

		// get the current state of this Connection object's auto-commit mode
		boolean defaultCommit = conn.getAutoCommit();
		/* 寮�鍚簨鍔★紝璁惧畾涓嶈嚜鍔ㄦ彁浜� */
		conn.setAutoCommit(false);

		try {
			String sql3 = "update DBUSER set username='Jeff' where created_by='PrepareStatement'";
			// 鍒涘缓璇ヨ繛鎺ヤ笅鐨凱reparedStatement瀵硅薄
			pstmt = conn.prepareStatement(sql3);

			// 鎵ц鏌ヨ璇彞锛屽皢鏁版嵁淇濆瓨鍒癛esultSet瀵硅薄涓�
			rs = pstmt.executeQuery();

			/* 姝ｅ紡鎻愪氦 */
			conn.commit();
			System.out.println("鏇存柊鎴愬姛");

		} catch (Exception ex) {
			/* 鍑洪敊鍥炴粴 */
			conn.rollback();
			throw ex;
		}

		finally {
			/* 鎭㈠鍘熸彁浜ょ姸鎬� */
			conn.setAutoCommit(defaultCommit);
			// 閲婃斁璧勬簮
			myPreStmt.colseConnection(conn, pstmt, rs);
		}

	}

	/**
	 * delete data 鍒犻櫎鏁版嵁
	 */
	public void deleteData() throws Exception {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// 杩炴帴鏁版嵁搴�
		PrepareStatement myPreStmt = new PrepareStatement();
		conn = myPreStmt.establishConnection();

		// get the current state of this Connection object's auto-commit mode
		boolean defaultCommit = conn.getAutoCommit();
		/* 寮�鍚簨鍔★紝璁惧畾涓嶈嚜鍔ㄦ彁浜� */
		conn.setAutoCommit(false);

		try {
			String sql4 = "delete from DBUSER where created_by='PrepareStatement'";
			// 鍒涘缓璇ヨ繛鎺ヤ笅鐨凱reparedStatement瀵硅薄
			pstmt = conn.prepareStatement(sql4);

			// 鎵цSQL锛屽皢鏁版嵁淇濆瓨鍒癛esultSet瀵硅薄涓�
			rs = pstmt.executeQuery();

			/* 姝ｅ紡鎻愪氦 */
			conn.commit();
			System.out.println("鍒犻櫎鎴愬姛");

		} catch (Exception ex) {
			/* 鍑洪敊鍥炴粴 */
			conn.rollback();
			throw ex;
		}

		finally {
			/* 鎭㈠鍘熸彁浜ょ姸鎬� */
			conn.setAutoCommit(defaultCommit);
			// 閲婃斁璧勬簮
			myPreStmt.colseConnection(conn, pstmt, rs);
		}

	}

	/**
	 * close the connection 閲婃斁璧勬簮
	 */
	public void colseConnection(Connection conn, PreparedStatement pstmt, ResultSet rs) {

		if (rs != null) {
			try {
				// 鍏抽棴瀛樺偍鏌ヨ缁撴灉鐨凴esultSet瀵硅薄
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			rs = null;
		}
		if (pstmt != null) {
			try {
				// 鍏抽棴璐熻矗鎵цSQL鍛戒护鐨凱reparedStatement瀵硅薄
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (conn != null) {
			try {
				// 鍏抽棴Connection鏁版嵁搴撹繛鎺ュ璞�
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}