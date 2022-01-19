<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>null 값 처리 비교</title>
</head>
<body>	
	<h3>null 값 처리 비교</h3>
	
		<!-- 항상 null이 나오기 때문에 if문을 통해 null을 확인해야 한다 -->
		자바코드: <%= request.getParameter("id") %> <br> 
		EL 방식: ${param.id}
		
</body>
</html>