<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.net.URLDecoder" %> <!-- 인코더 -> 디코더(post 방식 일떄만) -->
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객 페이지</title>
</head>
<body bgcolor="pink">

	<h2>사용자로 로그인 성공</h2>

	<%=URLDecoder.decode(request.getParameter("user_name"), "UTF-8")%>
	(<%=request.getParameter("id")%>)님 환영합니다!

</body>
</html>