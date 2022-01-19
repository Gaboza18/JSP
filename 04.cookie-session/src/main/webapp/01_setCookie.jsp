<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 설정</title>
</head>
<body>

</body>
	
	<%
		// 쿠키 설정
		Cookie c = new Cookie("id", "hkhong");
		
		// 유효기간 설정
		c.setMaxAge(365*24*60*60); // 유효기간 1년설정: 365일*24시간*60분*60초
		
		// 클라이언트로 쿠키 전송
		response.addCookie(c);
		
		// 기타 다른 쿠키 생성 및 전송
		response.addCookie(new Cookie("pwd", "1234"));
		response.addCookie(new Cookie("address", "Seoul"));
	%>
	
	<h3>쿠키 설정 </h3>
</html>