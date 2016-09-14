package priv.practices.common;

import java.sql.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import org.sqlite.*;

/**
 * @author jeff yang get FireFox history URLs. FireFox Sqlite database is
 *         located in C:\Users\jeff
 *         yang.LONDON\AppData\Roaming\Mozilla\Firefox\Profiles\atlkuvql.default
 *         \places.sqlite
 */
public class FireFoxGetHistoryURL {

	public static void main(String args[]) {
		Connection c = null;
		Statement stmt = null;
		String id = null;
        String url = null; 
        
		HashMap<String, String> res = new HashMap<String, String>();//存uid的字符串map 
		
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:"
					+ "C:\\Users\\jeff yang.LONDON\\AppData\\Roaming\\Mozilla\\Firefox\\Profiles\\6u2u75xg.default\\places.sqlite");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");

			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM moz_places where visit_count=1;");
			while (rs.next()) {
				id = rs.getString("id");//选择uid这列数据
				url = rs.getString("url");//选择uid这列数据
				id = new String(id.getBytes("GBK"),"GB2312");
                url = new String(url.getBytes("GBK"),"GB2312");
				res.put(id, url);
			}
			
			Collection cl = res.values();
		    Iterator itr = cl.iterator();
		    while (itr.hasNext()) {
		        System.out.println(itr.next());
		     }
		    
			rs.close();
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("get history urls done successfully");
	}

}
