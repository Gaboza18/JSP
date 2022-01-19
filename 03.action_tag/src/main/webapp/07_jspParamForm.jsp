<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인(고객/관리자) 페이지</title>
<style>
label {
	display: inline-block;
	width: 120px;
	margin-bottom: 10px;
}
</style>
</head>
<body>
<form method="post" action="07_jspParamTest.jsp">
		<label for="id">아이디: </label>
		<input type="text" name="id" id="id">
		<br>
		<label for="id">암 호: </label>
		<input type="password" name="password" id="password">
		<br>
		<input type="radio" name="user_type" id="user" value="user" checked>사용자
		<input type="radio" name="user_type" id="manager" value="manager">관리자
		<br>
		<input type="submit" value="로그인"><br>
	</form>	
</body>
</html>