<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문자열 비교</title>
</head>
<body>

	<h3>문자열 비교(자바코드)</h3>
	== 연산자: <%= request.getParameter("id") == "gildong" %> <br> <!-- 주소값 비교 -->
	equals() 연산자: <%= request.getParameter("id").equals("gildong") %><br> <!-- 문자비교 -->
	
	<h3>문자열 비교(EL)</h3>
	== 연산자: ${param.id == "gildong"}<br>
	equals() 연산자: ${param.id.equals("gildong")}<br>
	
</body>
</html>