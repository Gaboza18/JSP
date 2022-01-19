<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 메인페이지</title>
<style>
	i{
		color:blue;		
	}
</style>
</head>
<body>

	<h3>회원 전용 페이지</h3>
		<form method="get" action="logout.do"> 
			<br>환영합니다! <b><i>${loginUser.name}(${loginUser.userid})님</i></b>
				<br> 여기는 <b><i>회원전용</i></b> 페이지 입니다.
				<br><br>
			<input type="submit"  value="로그아웃">&nbsp;                         
			<input type="button" value="회원정보변경" 
				onclick="location.href='memberUpdate.do?userid=${loginUser.userid}'" >
		</form>
		
</body>
</html>