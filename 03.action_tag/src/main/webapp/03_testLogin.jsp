<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 비밀번호 확인</title>
</head>
<body>
	<%
	String id = "sslee";
	String password = "1234";
	String name = "이순신";

	request.setCharacterEncoding("UTF-8");

	// 선언한 id값.equals(요청한 id값) 같은지 문자열 비교
	if (id.equals(request.getParameter("id")) && password.equals(request.getParameter("password"))) {
		// 로그인 성공시
		response.sendRedirect("03_main.jsp?name= " + URLEncoder.encode(name,"UTF-8"));
		// main jsp파일에 name 변수를 넘긴다 -> 한글형식으로 출력하기 위해 URLEncoder import
	} else {
		// 로그인 실패시
		response.sendRedirect("03_loginForm.jsp");
	}
	%>
</body>
</html>