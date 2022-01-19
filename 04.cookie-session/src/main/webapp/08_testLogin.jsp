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

	request.setCharacterEncoding("UTF-8"); // post 방식에서 한글작업 하기 위한 선언

	// 선언한 id값.equals(요청한 id값) password값.equals(요청한 password값) 일치한지 확인
	if (id.equals(request.getParameter("id")) && password.equals(request.getParameter("password"))) {
		
		// 세션 생성 (저장할 값의 이름, 저장할 값)
		session.setAttribute("login_user",name); // 조건이 일치하면 선언한 name 값을 가지는 login_user 세션 생성
			
		// 로그인 성공시
		response.sendRedirect("08_main.jsp"); // 조건이 일치하고 세션이 생성되면 메인 화면으로 보낸다
		
		
	} else {
		// 로그인 실패시
		response.sendRedirect("08_loginForm.jsp"); // 조건 불일치시 로그인 화면으로 보낸다
	}
	
	%>
</body>
</html>