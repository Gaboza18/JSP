<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>액세서리</h3>
		관심 항목을 선택하세요<br>
		
		<form method="get" action="CheckBoxServlet">
		
			<input type="checkbox" name="item" value="신발">신발
			<input type="checkbox" name="item" value="가방">가방
			<input type="checkbox" name="item" value="모자">모자
			<br>
			<input type="checkbox" name="item" value="벨트">벨트
			<input type="checkbox" name="item" value="시계">시계
			<input type="checkbox" name="item" value="주얼리">주얼리
			<br><br>
			<input type="submit" value="전송">
			
			
		</form>
</body>
</html>