<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
</head>
<body>
	<h3>메인 페이지</h3>
	
	<%
	// 세션 불러오기
	String name = (String)session.getAttribute("login_user"); // (문자열 형태)의 login_user 세션을 불러와서 name 라는 변수에 저장한다
	 %>
	 
 <form method="get" action="08_logout.jsp"> <!-- 로그아웃 하면 get 방식으로 08_logout.jsp 페이지도 이동한다 -->
  
	"<b><%= name %></b>" 님 안녕하세요!<br> <!-- name에 저장된 세션값 -->
	저희 홈페이지에 방문해 주셔서 감사합니다.<br>
	즐거운 시간되세요...<br><br>
	
	<input type="submit" value="로그아웃">
	
 </form>
 
</body>
</html>