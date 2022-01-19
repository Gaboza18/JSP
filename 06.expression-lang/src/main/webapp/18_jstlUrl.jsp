<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>c:url 예제</title>
</head>
<body>
	<c:url value="images/winter.jpg" var="data"/>
	<h3>${data}</h3> <!-- 이미지 경로 -->
	<img src="${data}" width="500" height="500"/>
</body>
</html>