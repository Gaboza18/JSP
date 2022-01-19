<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>fmt:formatNumber 예제</title>
</head>
<body>
	<fmt:formatNumber value="1234567.89"/><br> <!-- 3자리씩 끊어서 출력 -->
	<fmt:formatNumber value="0.5" type="percent"/><br>
	<fmt:formatNumber value="10000" type="currency"/><br> <!-- currency = won(원)- -->
	<fmt:formatNumber value="121.534" pattern="#,#00.0#" /><br> <!-- 3자리씩 끊어서 출력 빈자리는 0으로 채워진다 / 00.0 으로 출력-->
</body>
</html>