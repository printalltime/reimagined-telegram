package com.example.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcDaoHelper {

	private static final String USER = "root";

	private static final String PASSWORD = "";

	private static final String URL = "jdbc:mysql://localhost:3306/usermanager";

	private static Connection con;

	// ��ȡ���ݿ����Ӷ���
	public static Connection getConnection() {

		if (con == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(URL, USER, PASSWORD);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			return con;
		}
		return con;
	}

	public static PreparedStatement getPreparedStatement(String sql)
			throws SQLException {

		return getConnection().prepareStatement(sql);
	}

	public static PreparedStatement setPreparedStatementParam(
			PreparedStatement statement, Object obj[]) throws SQLException {

		for (int i = 0; i < obj.length; i++) {
			statement.setObject(i + 1, obj[i]);
		}
		return statement;
	}

	// �ͷ���Դ
	public static void release(PreparedStatement ps, ResultSet rs) {
		try {
			if (con != null) {
				con.close();
				con = null;
			}
			if (ps != null) {
				ps.close();
				ps = null;
			}
			if (rs != null) {
				rs.close();
				rs = null;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
