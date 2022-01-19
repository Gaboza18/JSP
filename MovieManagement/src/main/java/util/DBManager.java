package util;

import java.sql.*;
import javax.naming.*;
import javax.sql.*;

public class DBManager {

	public static Connection getConnection() {

		Connection conn = null;

		try {
			// JNDI 초기화(객체 생성)
			Context initContext = new InitialContext();

			// lookup() - 지정된 이름으로 등록된 서비스 자원을 찾을 때 사용
			Context envContext = (Context) initContext.lookup("java:/comp/env");

			// JDBC 연결 서비스 등록(resource name="jdbc/myoracle")
			DataSource ds = (DataSource) envContext.lookup("jdbc/myoracle");
			conn = ds.getConnection();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return conn;
	}

	/*
	 * SELECT문을 위한 close() 메소드
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
	 * UPDATE, DELETE문을 위한 close() 메소드
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
