<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>c:if 태그 연습</title>
</head>
<body>
	
	<h3>색상을 선택하세요</h3>
	<form method="get" action="11_colorSelect.jsp">
	
		<select name="color">
			<option value="1">빨강</option>
			<option value="2">파랑</option>
			<option value="3">초록</option>
		</select>
		
		<input type="submit" value="전송">
		
	</form>
</body>
</html>