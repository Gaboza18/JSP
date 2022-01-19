<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>application 내장객체</title>
</head>
<body>
	웹 애플리케이션의 컨텍스트 패스: 
	<b><%= application.getContextPath() %></b><br>
	
	웹 애플리케이션의 실제 경로명:
	<b><%= application.getRealPath("04_application.jsp") %></b>
</body>
</html>