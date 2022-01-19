<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 삭제</title>
</head>
<body>
	<%
		Cookie c = new Cookie("address", ""); // 주소 쿠키 삭제
		c.setMaxAge(0); // 유효기간 0으로 설정
		response.addCookie(c);
	%>

	<h3>쿠키가 삭제되었습니다.</h3>
	<a href="02_getCookies.jsp">쿠키 목록 확인</a>
</body>
</html>