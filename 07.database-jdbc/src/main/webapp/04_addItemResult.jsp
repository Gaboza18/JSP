<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.sql.*" %>

<%!
	Connection conn = null; // jdbc에서 오라클 DB를 접속한 객체 저장
	PreparedStatement pstmt = null; // SQL문 저장, 실행 객체
	
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String uid = "jsp_user";
	String pass = "ora123";
	String sql ="INSERT INTO item VALUES(?,?,?)"; // 입력할 데이터 개수랑 ? 개수 일치
%>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 정보 결과</title>
</head>
<body>
	<%
	request.setCharacterEncoding("UTF-8"); // 한글 작업하기 위한 선언
		
		// 입력받는 데이터 값(사용자가 입력하는 데이터)
		String itemname = request.getParameter("itemname");
		String price = request.getParameter("price");
		String description = request.getParameter("description");
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url,uid,pass);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,itemname);
			pstmt.setString(2,price);
			pstmt.setString(3,description);
						
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
	
	<h3>상품정보 입력완료</h3>
	<a href="04_allItem.jsp">상품 전체 목록 보기</a>
</body>
</html>