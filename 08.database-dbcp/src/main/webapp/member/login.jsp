<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 폼</title>
<style>

	body{
		background-color: rgba(203,178,219,0.2);
	}
	#container{
		margin: 0 auto;
		width: 300px;
		border: 0.6px solid #000;
		padding: 20px;
	}
	label{
		display: inline-block;
		width: 80px;
	}
	#submit_box{
		text-align:center;
	}
	h2{
		text-align:center;
		margin: 30px;	
	}
	#msg{
		color:red;
		font-weight:bold;
		font-size: 12px;
		text-align:center;
	}
</style>
</head>
<body>
  <div id="container">
  	<h2><i>로그인</i></h2>
	<form method="post" action="login.do" id="frm">
	
			<label for="userid">아이디 </label>
			<input type="text" name="userid" id="userid">
			<br>
			<label for="userpwd">암 &nbsp; 호 </label>
			<input type="password" name="userpwd" id="userpwd">
			<br><br>
		
		<div id="submit_box">
			<input type="submit" value="로그인" onclick="return login_check()">
			<input type="reset" value="취소">
			<input type="button" value="회원가입" onclick="location.href='join.do'"><br><br>
		</div>
	
		<span id="msg">${message}<br></span> <!-- 로그인 실패시 오류 메세지 출력 -->	
	</form>
	
<script type="text/javascript" src="script/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="script/member.js"></script>

</div>		
</body>
</html>