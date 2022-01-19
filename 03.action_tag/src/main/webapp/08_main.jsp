<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main page</title>
</head>
<body>
	<!-- 헤더 페이지의 내용을 메인 페이지에 포함시킨다 -->
	<jsp:include page="08_header.jsp"></jsp:include>
	
	<h4>메인 화면 입니다.</h4>
	<a href="08_sub.jsp">서브 페이지로 이동</a>
	
	<!-- 푸터 페이지의 내용을 메인 페이지에 포함시킨다 -->
	<jsp:include page="08_footer.jsp"></jsp:include>
</body>
</html>