package model;

import java.sql.*;

public class DBtool {
	private static Connection conn = null;
	private static PreparedStatement pst = null;
	private static Statement st = null;
	private static ResultSet rs = null;

	public static Connection getConnection() throws Exception {

		if (conn == null || conn.isClosed()) {
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/mywebsite?serverTimezone" + "=UTC&characterEncoding=utf-8&useSSL=false",
					"root", "123456");

		}

		return conn;

	}

	public static void closeResource(Connection conn, PreparedStatement pst, Statement st, ResultSet rs)
			throws Exception {

		if (rs != null) {
			rs.close();
			rs = null;
		} else if (pst != null) {
			pst.close();
			pst = null;
		}

		else if (st != null) {
			st.close();
			st = null;

		} else if (conn != null) {
			conn.close();
			conn = null;

		}

	}

}