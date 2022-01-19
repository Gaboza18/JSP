<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>표현언어 연산자</title>
</head>
<body>
	<!-- \ 붙히면 $ 의미가 없어짐 ->  \${숫자1 연산자 숫자2} : 결과값 -->
	\${5 + 2} : ${5 + 2}<br>
	\${5 / 2} : ${5 / 2}<br>
	
	<!--  연산자 대신 문장을 사용가능 -->
	<!-- \${5 div 3} : ${5 div 3}<br> <!-- 몫 --> 
	\${5 mod 2} : ${5 mod 2}<br> <!-- 나머지 -->
	\${5 > 2} : ${5 > 2}<br>
	\${5 gt 2} : ${5 gt 2}<br> <!-- great then -->
	\${5 > 2 ? 5 : 2} : ${5 > 2 ? 5 : 2}<br> <!-- 참 = 앞 : 거짓 = 뒤 -->
	\${5>2 || (2<10) } : {5>2 || (2<10) }<br>
	
	<%
		String name = null;
	%>
	<%-- name에 저장된 값이 null인지 확인 --%>
	\${empty name} : ${empty name}<br>


</body>
</html>