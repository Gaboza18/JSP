<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>설문조사 폼 만들기</title>
<style>
#container {
	margin: 0 auto;
	width: 600px;
	border: 1px solid #000;
	padding: 20px;
}
label {
	display: inline-block;
	width: 120px;
	margin-bottom: 10px;
}
</style>
</head>
<body>
<div id="container">
	<h2>설문 조사</h2>
	<form method="post" action="02_research.jsp">
		<label for="name">이름:</label>
		<input type="text" name="name" id="name">
		<br>
		<label for="gender">성별:</label>
		<input type="radio" name="gender" id="gender" value="남자" checked>남자
		<input type="radio" name="gender" id="gender1" value="여자">여자
		<br>
		<label for="season">좋아하는 계절: </label>
		<input type="checkbox" name="season" id="season" value="1">봄
		<input type="checkbox" name="season" id="season" value="2">여름
		<input type="checkbox" name="season" id="season" value="3">가을
		<input type="checkbox" name="season" id="season" value="4">겨울
		<br>
		<input type="submit" value="전송" style="margin-right: 20px;">
		<input type="reset" value="취소">
	</form>
</div>
</body>
</html>