<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.sql.*" %>

<%!
	Connection conn = null; // jdbc에서 오라클 DB를 접속한 객체 저장
	PreparedStatement pstmt = null; // SQL문 저장, 실행 객체
	
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String uid = "jsp_user";
	String pass = "ora123";
	String sql = "INSERT INTO member VALUES(?,?,?,?,?,?)"; // 입력할 데이터 개수랑 ? 개수 일치
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DB insert문 연습(pstmt 연습)</title>
</head>
<body>
	<%
	request.setCharacterEncoding("UTF-8"); // 한글 작업하기 위한 선언
		
		// 입력받는 데이터 값(사용자가 입력하는 데이터)
		String name = request.getParameter("name");
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		int admin = Integer.parseInt(request.getParameter("admin"));
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url,uid,pass);
			pstmt = conn.prepareStatement(sql); // stmt 와 차이
			
			pstmt.setString(1,name); // 입력받을 파라메타 값
			pstmt.setString(2,userid);
			pstmt.setString(3,pwd);
			pstmt.setString(4,email);
			pstmt.setString(5,phone);
			pstmt.setInt(6,admin);
			
			
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
	
	<!-- insert가 완료후 회원목록이 있는 jsp 파일로 이동한다 -->
	<h3>회원가입 완료</h3>
	<a href="01_allMember.jsp">회원 전체 목록 보기</a>
</body>
</html>