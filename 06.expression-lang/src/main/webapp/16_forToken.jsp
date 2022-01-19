<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>c:forToken 연습</title>
</head>
<body>
	<h3>,로 구분된 문자열 분리</h3>
	
	<c:forTokens var="city" items="서울.대전,대구.광주" delims=","> <!-- , 나오면 그다음 구분 -->
		${city}<br>
	</c:forTokens>
	
	<hr>	
	
	<h3>, .로 구분된 문자열 분리</h3>
	<c:forTokens var="city" items="서울.대전,대구.광주" delims=",."> <!-- , 또는 . 나오면 구분 -->
		${city}<br>
	</c:forTokens>
</body>
</html>