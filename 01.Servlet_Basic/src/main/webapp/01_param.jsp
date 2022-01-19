<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디, 나이 입력하는 JSP</title>
	<!-- JS 쿼리서언  -->
		<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
		<script type = "text/javascript" src="js/param.js"></script>
</head>
<body>

	<!-- get방식: action을 할떄 body안에 데이터가 주소 URL에 노출된다 -->
	<!-- set방식: action을 할떄 body안에 데이터가 주소 URL에 노출이 되지 않는다 -->
	
	<form method="post" action="ParamServlet">
	
		<label>
			아이디: <input type="text" name="id" id="id">
		</label>
		<br>
		<label>
			나  이: <input type="text" name="age" id="age">
		</label>
		<br><br>
		<!-- JS파일에 check() 함수 리턴 -->
		<input type="submit" value="전송" onclick="return check()">
		
	</form>
</body>
</html>