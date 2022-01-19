<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>request 내장객체 종류</title>
</head>
<body>
	컨텍스트 패스: <%= request.getContextPath() %><br><%-- JSP가 속한 웹프로젝트 명,server.xml에 context 태그내의 정보를 불러온다 --%>
	요청방식: <%= request.getMethod() %><br>
	요청 URL: <%= request.getRequestURL() %><br>
	요청 URI: <%= request.getRequestURI() %><br> <%-- 쿼리스트링 제외 부분만 보인다 --%>
	서버 이름: <%= request.getServerName() %><br>
	프로토콜: <%= request.getProtocol() %>
</body>
</html>