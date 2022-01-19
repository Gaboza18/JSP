package util;

import java.sql.*;
import javax.naming.*;
import javax.sql.*;

public class DBManager {

	public static Connection getConnection() {

		Connection conn = null;

		try {
			// JNDI �ʱ�ȭ(��ü ����)
			Context initContext = new InitialContext();

			// lookup() - ������ �̸����� ��ϵ� ���� �ڿ��� ã�� �� ���
			Context envContext = (Context) initContext.lookup("java:/comp/env");

			// JDBC ���� ���� ���(resource name="jdbc/myoracle")
			DataSource ds = (DataSource) envContext.lookup("jdbc/myoracle");
			conn = ds.getConnection();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return conn;
	}

	/*
	 * SELECT���� ���� close() �޼ҵ�
	 */
	
	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (rs != null)
				stmt.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * UPDATE, DELETE���� ���� close() �޼ҵ�
	 */

	public static void close(Connection conn, Statement stmt) {
		try {
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
