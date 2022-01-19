<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>악세사리</h1>
	   관심 항목을 선택하세요.
	<hr>
	
	<form method="get" action="15_forEachEx2.jsp">
	
		<input type="checkbox" name="Accessories" value="신발">신발
		<input type="checkbox" name="Accessories" value="가방">가방
		<input type="checkbox" name="Accessories" value="벨트">벨트
		<br>
		<input type="checkbox" name="Accessories" value="모자">모자
		<input type="checkbox" name="Accessories" value="시계">시계
		<input type="checkbox" name="Accessories" value="쥬얼리">쥬얼리
		<br>
		<input type="submit" value="전송">
		
	</form> 
	
</body>
</html>