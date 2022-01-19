<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.Enumeration" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션 삭제하기</title>
</head>
<body>
	<%
	session.setAttribute("property1", "세션속성1"); // 세션값 설정하기
	session.setAttribute("property2", "세션속성2");
	session.setAttribute("property3", "세션속성3");

	out.print("<h4> >>세션 저장 내용<< </h4>");

	Enumeration<String> names = session.getAttributeNames(); // 세션 모든 값(String) 가져온다

	while (names.hasMoreElements()) {
		String key = names.nextElement();
		String value = (String) session.getAttribute(key);
		out.println(key + " : " + value + "<br>");
	}

	// 세션에서 속성 제거
	session.removeAttribute("property2");

	out.print("<h4> >>property2 삭제후<< </h4>");
	names = session.getAttributeNames();

	// 세션속성 제거후 출력
	while (names.hasMoreElements()) {
		String key = names.nextElement();
		String value = (String) session.getAttribute(key);
		out.println(key + " : " + value + "<br>");
	}
	
	// 로그아웃 후 세션 제거
	
	session.invalidate(); // 세션 제거
	
	out.print("<h4>세션이 유효한가?<h4>");
	
		if(request.isRequestedSessionIdValid()){ // 세션 ID가 유효한지 확인하는 메소드
			out.println("세션이 유효합니다.");
		}else{
			out.println("세션이 유효하지 않습니다.");
		}
		
	%>
</body>
</html>