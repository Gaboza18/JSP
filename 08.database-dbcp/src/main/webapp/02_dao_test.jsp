<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.green.dao.MemberDAO" %>
<%@ page import="java.sql.*" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DAO 테스트</title>
</head>
<body>

	<%
		// 이미 만들어진 객체의 주소를 얻어옴
		MemberDAO mDao = MemberDAO.getInstance();
		// 데이터 베이스 연결 수행
		Connection conn = mDao.getConnection();
		
		if(conn != null){
			out.print("데이터베이스 연결 성공!");
			
			conn.close();
		}
	%>
	
</body>
</html>