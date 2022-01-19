<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
<link rel="stylesheet" href="css/shopping.css" />
</head>
<body>
	<div id="wrap">
		<h1>게시글 수정</h1>
		<form method="post" action="BoardServlet">
			<input type="hidden" name="command" value="board_update"> <input
				type="hidden" name="num" value="${board.num}">
			<table>
				<tr>
					<th>작성자</th>
					<td><input type="text" name="name" id="name"
						value="${board.name}"> * 필수</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="pass" id="pass"> * 필수
						(게시물 수정 삭제시 필요합니다.)</td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="email" name="email" value="${board.email}">
					</td>
				</tr>
				<tr>
					<th>제목</th>
					<td><input type="text" name="title" size="70" id="title"
						value="${board.title}"> * 필수</td>
				</tr>
				<tr>
					<th>내 용</th>
					<td><textarea cols="70" rows="10" name="content"> ${board.content}</textarea>
					</td>
				</tr>
			</table>
			<br>
			<div style="text-align: center;">
				<input type="submit" value="등록" onclick="return boardCheck()">&nbsp;
				<input type="reset" value="다시 작성">&nbsp; <input
					type="button" value="목록"
					onclick="location.href='BoardServlet?command=board_list'">
			</div>
		</form>
	</div>

	<script type="text/javascript" src="script/jquery-3.6.0.min.js"></script>
	<script type="text/javascript" src="script/board.js"></script>
</body>
</html>