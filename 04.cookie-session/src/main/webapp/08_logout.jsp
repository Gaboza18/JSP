<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그아웃 페이지</title>
</head>
<body>
	<%
	session.invalidate(); // 세션 제거(로그인한 세션값 삭제) 
	%>
<script type="text/javascript">
		alert("로그아웃 되었습니다."); // JS 사용하여 로그아웃 시 알림창 생성
		location.href="08_loginForm.jsp"; // 로그아웃 메세지가 출력되면 location.href 메소드 사용하여 로그인 페이지로 이동한다
</script>	
</body>
</html>