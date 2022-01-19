<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>c:import 예제</title>
</head>
<body>
	<!-- jsp:include 와 기능이 유사하지만 다른 페이지의 내용을 변수에 저장할수 있다. -->
	<c:import url="02_elOperator.jsp" var="data"></c:import>
	~<br>
	~<br>
	~<br>
	~<br>
	${data}
	~<br>
	~<br>
	~<br>
	~<br>
</body>
</html>