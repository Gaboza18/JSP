<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 목록</title>
<link rel="stylesheet" href="css/movie.css" />
</head>
<body>
<div id="wrap">
<h1>영화 목록</h1>
<table>
	<tr>
		<td colspan="5" style="text-align: right; border:white;">
			<a href="movie_write.do">정보 등록</a>
		</td>
	</tr>
	<tr>
		<th>제목</th>
		<th>감독</th>
		<th>배우</th>
		<th>가격</th>
		<th>수정</th>
		<th>삭제</th>
	</tr>
	<c:forEach var="movie" items="${movieList}">
	<tr>
		<td class="item"><a href="movie_list.do">${movie.title}</a></td>
		<td class="item">${movie.director}</td>
		<td class="item">${movie.actor}</td>
		<td class="item">${movie.price}원</td>
		<td class="item">
			<a href="movie_update.do?code=${movie.code}">수정</a>
		</td>
		<td class="item">
			<a href="movieDelete.do?code=${movie.code}">삭제</a>
		</td>
	</tr>
	</c:forEach>
</table>
</div>
</body>
</html>