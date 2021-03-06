<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 등록</title>
<link rel="stylesheet" href="css/movie.css"/>
</head>
<body>
<div id="wrap">
	<h1>영화 등록</h1>
	<form method="post" enctype="multipart/form-data" action="movie_write.do">
	<table>
		<tr>
			<th>제 &nbsp;목</th>
			<td> <input type="text" name="title" id="title" size="50"> </td>
		</tr>
		<tr>
			<th>가 &nbsp;격</th>
			<td> <input type="text" name="price" id="price"> </td>
		</tr>
		<tr>
			<th>감 &nbsp;독</th>
			<td> <input type="text" name="director" id="director"> </td>
		</tr>
		<tr>
			<th>배 &nbsp;우</th>
			<td> <input type="text" name="actor" id="actor"> </td>
		</tr>
		<tr>
			<th>설 &nbsp;명</th>
			<td>
				<textarea row="50" cols="70" name="synopsis" id="synopsis"></textarea>
			</td>
		</tr>
		<tr>
			<th>사 &nbsp;진</th>
			<td>
				<input type="file" name="poster" id="movie_image"><br>
				(주의사항: 이미지를 변경하고자할 때만 선택하세요)
			</td>
		</tr>

	</table>
	<br>
	<div id="buttons">
		<input type="submit" value="등록" onclick="return movieCheck()">
		<input type="reset" value="취소">
		<input type="button" value="목록" onclick="location.href='movie_list.do'">
	</div>
	</form>
	
	<script type="text/javascript" src="script/jquery-3.6.0.min.js"></script>
	<script type="text/javascript" src="script/movie.js"></script>
</div>
</body>
</html>






