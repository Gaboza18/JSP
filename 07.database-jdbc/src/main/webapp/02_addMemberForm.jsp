<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 입력 폼</title>
</head>
<style>
label {
	display: inline-block;
	width: 75px;
}
</style>
<body>

	<h2>회원 정보 입력</h2>
	
	<form method="post" action="02_addMember.jsp">
	
		<label>이름</label> <input type="text" name="name" size="20"><br>
		<label>아이디</label> <input type="text" name="userid" size="20"><br>
		<label>비밀번호</label> <input type="password" name="pwd" size="20"><br>
		<label>이메일 </label> <input type="email" name="email" size="20"><br>
		<label>전화번호 </label> <input type="text" name="phone" size="20"><br>
		<label>등급 </label> <input type="radio" value="1" name="admin">관리자
							<input type="radio" value="0" name="admin">일반회원 
		
		<br><br>
		
		<div id="buttons">
			<input type="submit" value="전송"> <input type="reset" value="취소">
		</div>

	</form>
</body>
</html>