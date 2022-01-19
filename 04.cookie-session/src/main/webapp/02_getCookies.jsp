<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 정보 읽어오기</title>
</head>
<body>
	<h3>클라이언트 에서 읽어온 쿠키정보</h3>
	<%
		Cookie[] cookies = request.getCookies();
	
		for (Cookie c : cookies) {
			out.print(c.getName() + " : " + c.getValue() + "<br>");
		}
	%>
</body>
</html>