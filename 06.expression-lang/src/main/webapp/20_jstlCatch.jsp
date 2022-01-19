<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>c:catch 예제</title>
</head>
<body>
	<c:catch var="errmsg">
	예외 발생전<br>
	<%= 2/0 %><br>
	예외 발생후<br> <!-- 예외가 발생하면 실행되지 않고 c:catch문 빠져나간다 -->
	</c:catch>
	<c:out value="${errmsg}"/>
</body>
</html>