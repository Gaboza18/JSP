<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GET, POST 전송방식</title>
</head>
<body>
	<form method="get" action="MethodServlet">
		<input type="submit" value="GET 방식으로 호출하기">
	</form>
	<br><br>
	<form method="post" action="MethodServlet">
		<input type="submit" value="POST 방식으로 호출하기">
	</form>
</body>
</html>