<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- 에러가 발생할때 보여줄 페이지 지정 --%>    
<%@ page errorPage="error.jsp" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러 페이지 테스트</title>
</head>
<body>
	0으로 나누어 에러가 발생했습니다.
	<%= 2/0 %>
</body>
</html>