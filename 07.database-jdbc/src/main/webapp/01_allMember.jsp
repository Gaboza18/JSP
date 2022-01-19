<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.sql.*" %> <!-- DB연결 하기 위한 JDBC import -->
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DB 연결 예제(회원조회)</title>
</head>
<body>
	<%!
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String uid="jsp_user"; // sql 아이디
		String pwd="ora123"; // sql 비번
		
		Connection conn = null; // jdbc에서 오라클 DB를 접속한 객체 저장
		Statement stmt = null; // SQL문 저장, 실행 객체
		ResultSet rs = null; // 데이터베이스 조회 결과 저장
	%>
	<table width="600" border="1">
		<tr>
			<th>이름</th><th>아이디</th><th>암호</th><th>이메일</th><th>전화번호</th><th>권한(1: 관리자, 0:회원)</th>
		</tr>
	<%
	try {
		// 오라클 JDBC 드라이버를 JVM 메모리로 로드 - (1)
		Class.forName("oracle.jdbc.driver.OracleDriver");

		// 오라클 DB에 연결시도 - (2)
		conn = DriverManager.getConnection(url, uid, pwd);

		// SQL문 실행을 위한 Statement 객체 생성 - (3)
		stmt = conn.createStatement();

		// SQL문 실행하여 결과를 얻어온다. - (4)
		rs = stmt.executeQuery("SELECT * FROM member");

		// 한행씩 출력후 반복한다
		while (rs.next()) {

			out.println("<tr>");
			out.println("<td>" + rs.getString("name") + "</td>");
			out.println("<td>" + rs.getString("userid") + "</td>");
			out.println("<td>" + rs.getString("pwd") + "</td>");
			out.println("<td>" + rs.getString("email") + "</td>");
			out.println("<td>" + rs.getString("phone") + "</td>");
			out.println("<td>" + rs.getInt("admin") + "</td>");
			out.println("</tr>");

		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		try {
			if (rs != null)
		rs.close();
			if (stmt != null)
		stmt.close();
			if (conn != null)
		conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	%>
</table>
</body>
</html>