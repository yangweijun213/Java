package priv.practices.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class FireFoxClearHistoryURL {

	public static void main(String args[]) {
		Connection c = null;
		Statement stmt = null;

		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:"
					+ "C:\\Users\\jeff yang.LONDON\\AppData\\Roaming\\Mozilla\\Firefox\\Profiles\\atlkuvql.default\\places.sqlite");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");

			stmt = c.createStatement();
			String sql1 = "delete from moz_places where id in ( select place_id from (select place_id,max(visit_date) as mdate from moz_historyvisits group by place_id) as c where   c.mdate < strftime('%s',datetime('now','-0 days'))*1000000);";
			stmt.executeUpdate(sql1);
			String sql2 = "delete from moz_historyvisits where place_id not in (select id from moz_places);";
			stmt.executeUpdate(sql2);
			String sql3 = "update moz_places set visit_count=(select count(*) from moz_historyvisits where moz_historyvisits.place_id = moz_places.id); ";
			stmt.executeUpdate(sql3);
			c.commit();

			stmt.close();
			c.close();
		} catch (

		Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("clear history urls done successfully");
	}

}
