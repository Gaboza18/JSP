<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자바코드/표현언어 방식결과</title>
</head>
<body>

	<h2>표현식과 표현언어의 구분자 사용 비교</h2>
	
	<!-- 변수 num1, num2에 대한 값을 INT 형태로 변환하여 가져온다 -->
	<%
		int n1 = Integer.parseInt(request.getParameter("num1"));
		int n2 = Integer.parseInt(request.getParameter("num2"));
		
		request.setAttribute("num1", request.getParameter("num1"));
		request.setAttribute("num2", request.getParameter("num2"));
	%>
	
	<!-- 표현식 내에 자바의 "변수"를 지정함 -->
	<%=n1%> + <%=n2%> =	<%=n1 + n2%><br>
	
	<h2>표현언어 방식</h2>
	
	<!-- 표현언어 내의 구분자는 "속성명"을 지정함 -->
	${param.num1} + ${param.num2} = ${param.num1+param.num2}<br>
		
</body>
</html>