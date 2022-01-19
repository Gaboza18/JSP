<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자바코드/표현언어 방식결과</title>
</head>
<body>

	<h3>고전적인 방식(자바 코드)</h3>
	
	<!-- 변수 num1, num2에 대한 값을 INT 형태로 변환하여 가져온다 -->
	<%
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
	%>

	<%=num1%> + <%=num2%> =	<%=num1 + num2%><br>
	
	<h3>표현언어 방식</h3>
	${param.num1} + ${param.num2} = ${param.num1+param.num2}<br>
		
</body>
</html>