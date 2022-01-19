<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>thirdPage</title>
</head>
<body>
		<!-- 데이터 출력 x -->
		페이지 영역 데이터: <%= pageContext.getAttribute("name") %><br>
		<!-- 데이터 출력 x -->
		request 영역 데이터: <%= request.getAttribute("name") %><br>
		
		session 영역 데이터: <%= session.getAttribute("name") %><br>
		application 영역 데이터: <%= application.getAttribute("name") %><br>
		
</body>
</html>