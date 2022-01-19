<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 결과</title>
</head>
<body>
	당신이 입력한 정보입니다.(Java 문법의 표현식 방식)<br>
	아이디: <%= request.getParameter("id") %><br>
	비밀번호: <%= request.getParameter("password") %><br><br>
	
	당신이 입력한 정보입니다.(표현언어 방식(EL) 방식)<br>
	아이디: ${param.id}<br> <!-- ${param.파라미터 값} -->
	비밀번호: ${param["password"]}<br>
</body>
</html>