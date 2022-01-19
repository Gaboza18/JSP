<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관심사항 선택결과</title>
</head>
<body>
	<h3>당신이 좋아하는 운동</h3>
	
	<c:choose>
	
		<c:when test="${param.interest==1}">
			<span style="color:blue;">수영</span>
		</c:when>
		
		<c:when test="${param.interest==2}">
			<span style="color:red;">헬스</span>
		</c:when>
		
		<c:when test="${param.interest==3}">
			<span style="color:green;">골프</span>
		</c:when>
			
	</c:choose>
	
</body>
</html>