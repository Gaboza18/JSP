<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>표현언어</title>
</head>
<body>

	<%-- 표현식 --%>
		<%= "Hello" %><br><br>
		
	<%-- 스크립트릿 --%>
		<%
			out.print("Hello<br><br>");
	 	%>
	 
	<%-- 표현언어 --%>
		${"Hello"}<br><br>
				
</body>
</html>