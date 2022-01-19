<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>secondPage</title>
</head>
<body>
		<!-- 데이터 출력 x -->
		페이지 영역 데이터: <%= pageContext.getAttribute("name") %><br>
		
		request 영역 데이터: <%= request.getAttribute("name") %><br>
		session 영역 데이터: <%= session.getAttribute("name") %><br>
		application 영역 데이터: <%= application.getAttribute("name") %><br>
		<br>
		
		<!-- request 정보를 전달하지 않고 페이지만 열기 -->
		<a href="05_thirdPage.jsp">세번째 페이지 열기</a>
</body>
</html>