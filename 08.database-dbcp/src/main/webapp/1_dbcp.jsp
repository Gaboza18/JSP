<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.sql.*" %>
<%@ page import="javax.naming.*" %>
<%@ page import="javax.sql.*" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>DBCP 영역 테스트</h3>
	
	<%
		// JNDI 초기화(객체 생성)	
		Context initContext = new InitialContext();
	
		// lookup() - 지정된 이름으로 등록된 서비스 자원을 찾을 때 사용
		Context envContext = (Context)initContext.lookup("java:/comp/env");
		
		// JDBC 연결 서비스 등록(resource name="jdbc/myoracle")
		DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle"); 
		Connection conn = ds.getConnection(); 
		
		if(conn != null){
			out.println("DBCP 연결 성공");	
		}else{
			out.println("DBCP 연결 실패");
		}
	%>
	
</body>
</html>