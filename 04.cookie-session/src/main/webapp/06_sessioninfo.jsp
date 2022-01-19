<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션 정보 얻어오기</title>
</head>
<body>
	<h3>세션 정보 얻어오기</h3>
	<%
		// 세션 ID얻어오기
		String sessionId = session.getId();
	
		// 세션이 만들어진 시간을 밀리초 단위로 변환
		long createdTime = session.getCreationTime();
	
		// 현재 페이지에서 사용자가 마지막으로 활동한 시간(밀리초 단위)
		long lastTime = session.getLastAccessedTime();
	
		// 현재까지 웹 페이지를 이용한 시간(마지막 활동시간 - 세션 생성 시간) / 분단위로 계산(1000*60)
		long timeElapsed = (lastTime - createdTime) / 60000;
	
		// 사용자의 액션 없이 세션이 유지되는 시간
		int inactiveTime = session.getMaxInactiveInterval() / 60;
	%>
	
		세션 ID는 <%= sessionId %> <br>
		웹 사이트 머문 시간: <b><%= timeElapsed %></b> 분 입니다.<br>
		세션의 유효시간: <b><%= inactiveTime %></b> 분 입니다.
	
</body>
</html>