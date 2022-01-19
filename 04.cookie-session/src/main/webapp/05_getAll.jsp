<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.Enumeration" %> <!-- Enumeration 객체 사용하기 위한 import -->
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션 값 모두 가져오기</title>
</head>
<body>
	<h3>세션에 설정된 모든 값 가져오기</h3>
	<%
	
	// 모든값 가져올때 Enumeration -> import 해준다
	Enumeration<String> names = session.getAttributeNames();

	while (names.hasMoreElements()) { // 다음 값이 있는지 확인

		String name = names.nextElement(); // 다음 필드명을 가져온다
		String value = (String) session.getAttribute(name);
		out.print(name + " : " + value + "<br>");

	}
	%>
</body>
</html>