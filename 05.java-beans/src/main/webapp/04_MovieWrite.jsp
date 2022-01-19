<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 선택결과</title>
<style>
	label{
		display: inline-block;
		width: 75px;
		font-weight:bold;
	}
</style>
</head>
<body>
	<%
	
		request.setCharacterEncoding("UTF-8"); // 한글작업을 하기위한 선언
	
		String title= request.getParameter("title");
		String price= request.getParameter("price");
		String director= request.getParameter("director");
		String actor= request.getParameter("actor");
		String synopsis= request.getParameter("synopsis");
		String genre= request.getParameter("genre");
		
	%>
	
	<jsp:useBean id="movie" class="com.mission.javabeans.MovieBean"/>
	
	<jsp:setProperty property="*" name="movie"/> <!-- 여러개의 항목을 중복으로 주지 않고 * 한번만 선언해 실행가능 -->
	
	<h3>입력 완료된 정보</h3>
	
	<label>영화 제목: </label>
	<jsp:getProperty name="movie" property="title"/><br>
	
	<label>가격: </label>
	<jsp:getProperty name="movie" property="price"/><br>
	
	<label>감독: </label>
	<jsp:getProperty name="movie" property="director"/><br>
	
	<label>출연배우: </label>
	<jsp:getProperty name="movie" property="actor"/><br>
	
	<label>줄거리: </label>
	<jsp:getProperty name="movie" property="synopsis"/><br>
	
	<label>장르: </label>
	<jsp:getProperty name="movie" property="genre"/><br>
	
</body>
</html>