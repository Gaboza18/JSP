<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Textarea/radio 기능연습</title>
</head>
<body>
	<form method="get" action="RadioServlet">
	
		<label for="gender">성별: </label>
		
		<!-- 기본값 설정할수 있다. checked -->
		<input type="radio" name="gender" id="gender" value="남자" checked>남자
		<input type="radio" name="gender" id="gender2" value="여자">여자<br><br>
		
		<label for="mail">메일 수신여부: </label>
		
		<input type="radio" name="checkmail" id="mail" value="yes" checked>수신
		<input type="radio" name="checkmail" id="mail" value="no">수신거부<br><br>
		
		<label for="content">가입 인사를 적어주세요</label><br><br>
		
		<textarea rows="3" cols="50" name="content" id="content"></textarea><br><br>
		
		<input type="submit" value="전송">
		
	</form>
</body>
</html>