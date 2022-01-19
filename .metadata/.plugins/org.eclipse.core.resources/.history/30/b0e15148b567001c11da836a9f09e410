<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 암호 확인</title>
<link rel="stylesheet" href="css/shopping.css" />
</head>
<body>
	<div align="center">
		<h1>비밀번호 확인</h1>
		<form method="get" action="BoardServlet">
			<input type="hidden" name="command" value="board_check_pass">
			<input type="hidden" name="num" value="${param.num}">
			<table>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="pass" id="pass" size="20"></td>
				</tr>
			</table>
			<br> <input type="submit" value="확인"
				onclick="return passCheck()"> <br> <span
				style="color: red;">${message}</span>
		</form>
	</div>

	<script type="text/javascript" src="script/jquery-3.6.0.min.js"></script>
	<script type="text/javascript" src="board.js"></script>
</body>
</html>