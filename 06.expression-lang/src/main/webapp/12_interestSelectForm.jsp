<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>c:chooes 태그 연습</title>
</head>
<body>
	<h3>관심사항을 선택해주세요</h3>
		<form method="get" action="12_interestSelect.jsp">
		
			<select name="interest">
				<option value="1">수영</option>
				<option value="2">헬스</option>
				<option value="3">골프</option>
			</select>
			
			<input type="submit" value="전송">
			
		</form>
</body>
</html>