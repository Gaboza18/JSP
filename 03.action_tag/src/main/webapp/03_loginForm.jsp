<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 폼</title>
<style>
	#container{
		margin: 0 auto;
		width: 600px;
		border: 1px solid #000;
		padding: 20px;
	}
	label{
		display: inline-block;
		width: 80px;
	}
</style>
</head>
<body>
  <div id="container">
	<form method="post" action="03_testLogin.jsp">
	
		<label for="id">아이디: </label>
		<input type="text" name="id" id="id">
		<br>
		<label for="password">암 호: </label>
		<input type="password" name="password" id="password">
		<br>
		<input type="submit" value="로그인">
		
	</form>
</div>		
</body>
</html>