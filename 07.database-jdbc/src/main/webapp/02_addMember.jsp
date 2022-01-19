<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.sql.*" %>

<%!
	Connection conn = null; // jdbc에서 오라클 DB를 접속한 객체 저장
	Statement stmt = null; // SQL문 저장, 실행 객체
	
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String uid = "jsp_user";
	String pass = "ora123";
	
	/* 테이블에 넣을 insert문 선언
	   String sql = "INSERT INTO member VALUES('강감찬', 'kcgang', '1234', 'kcgang@email.com', '010-1234-5678', 0)"; */
	
	   String sql ="";
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DB insert문 연습(stmt 연습)</title>
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
			stmt = conn.createStatement();
			
			/* Statement 객체를 이용해서 화면의 파라메터를 이용하여 insert 할 경우 */
			sql = "INSERT INTO member VALUES('" + name + "','" + userid + "','" + pwd + "','" + email + "','" + phone + "',"+ admin + ")";

			int result = stmt.executeUpdate(sql); // 위에서 선언한 sql문을 실행후 result 변수에 담는다

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
		if (stmt != null)
			stmt.close();
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