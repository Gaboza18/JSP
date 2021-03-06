<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정보 수정</title>
<link rel="stylesheet" href="css/movie.css"/>
</head>
<body>
<div id="wrap">
	<h1>정보 수정</h1>
	<form method="post" enctype="multipart/form-data" action="movie_update.do">
	<input type="hidden" name="code" value="${movie.code}">
	<input type="hidden" name="noupdateImg" value="${movie.poster}">
	<table>
	<tr>
		<td>
			<c:choose>
				<c:when test="${empty movie.poster}">
					<img src="upload/no_image.jpg"> <!-- 이미지 파일이 없을경우 -->
				</c:when>
				<c:otherwise>
					<img src="upload/${movie.poster}">
				</c:otherwise>
			</c:choose>
		</td>
		<td>
		<table>
			<tr>
				<th>제 &nbsp;목</th>
				<td> <input type="text" name="title" value="${movie.title}" id="title" size="50"> </td>
			</tr>
			<tr>
				<th>가 &nbsp;격</th>
				<td> <input type="text" name="price" value="${movie.price}" id="price"> </td>
			</tr>
			<tr>
				<th>감 &nbsp;독</th>
				<td> <input type="text" name="director" value="${movie.director}"id="director"> </td>
			</tr>
			<tr>
				<th>배 &nbsp;우</th>
				<td> <input type="text" name="actor" value ="${movie.actor}"id="actor"> </td>
			</tr>
			<tr>
				<th>설 &nbsp;명</th>
				<td>
					<textarea row="50" cols="50" name="synopsis" id="synopsis">${movie.synopsis}</textarea>
				</td>
			</tr>
			<tr>
				<th>사 &nbsp;진</th>
				<td>
					<input type="file" name="poster" id="poster"><br>
					(주의사항: 이미지를 변경하고자할 때만 선택하세요)
				</td>
			</tr>
		
		</table>
		</td>
	</tr>
	</table>
	<br>
	<div id="buttons">
		<input type="submit" value="수정" onclick="return movieCheck()">
		<input type="button" value="목록" onclick="location.href='movie_list.do'">
	</div>
	</form>
	
	<script type="text/javascript" src="script/jquery-3.6.0.min.js"></script>
	<script type="text/javascript" src="script/movie.js"></script>
</div>
</body>
</html>






