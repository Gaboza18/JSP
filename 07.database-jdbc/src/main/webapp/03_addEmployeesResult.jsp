<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.sql.*" %>

<%!
	Connection conn = null; // jdbc에서 오라클 DB를 접속한 객체 저장
	PreparedStatement pstmt = null; // SQL문 저장, 실행 객체
	
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String uid = "jsp_user";
	String pass = "ora123";
	String sql ="INSERT INTO employee VALUES(?,?,?)"; // 입력할 데이터 개수랑 ? 개수 일치
%>  
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원정보 결과</title>
</head>
<body>

	<%
	request.setCharacterEncoding("UTF-8"); // 한글 작업하기 위한 선언
			
			// 입력받는 데이터 값(사용자가 입력하는 데이터)
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			String jumin_no = request.getParameter("jumin_no1") + "-" + request.getParameter("jumin_no2");

			try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(url, uid, pass);
		pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, name);
		pstmt.setString(2, address);
		pstmt.setString(3, jumin_no);

		int result = pstmt.executeUpdate(); // 데이터베이스에 INSERT 수행

			} catch (Exception e) {
		e.printStackTrace();
			} finally {
		try {
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
			}
	%>
	
	<h3>사원정보 입력완료</h3>
	<a href="03_allEmployees.jsp">사원 전체 목록 보기</a>
</body>
</html>