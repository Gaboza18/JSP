<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>c:forEach 태그 연습</title>
</head>
<body>

	<%
		// 배열 변수는 표현언어에서 그대로 사용할수 없음(배열 변수에 값을 저장한다)
		String[] movieList ={"타이타닉", "혹성탈출", "시네마천국", "킹콩"};
		
		// 배열을 내장객체에 저장(표현언어를 사용하기 위해 속성값을 지정하고 배열변수값을 넣는다)
		pageContext.setAttribute("movieList", movieList); // 속성값, 변수
	%>
		
		<!-- 일반적인 forEach문 -->
		<c:forEach var="movie" items="${movieList}">
			${movie}<br> <!-- 속성안에 있는 값들을 하나씩 movie 라는 변수에서 뽑아온다 -->
		</c:forEach>
		
		<br><br>
	
		<c:forEach var="movie" items="${movieList}" varStatus="status">
			${status.index} &nbsp; <!-- 배열의 index 동일한 의미 = [i] -->
			${status.count} &nbsp; <!-- 반복문의 반복 횟수 -->
			${movie}<br> 
		</c:forEach>
		
		<br><br>
		
		<!-- varStatus의 first, last -->
		<c:forEach var="movie" items="${movieList}" varStatus="status">
			${movie}
			<c:if test="${not status.last}">,</c:if> <!-- 마지막 이면 , 안찍는다 --> 
		</c:forEach>
		
		<br><br>
		
		<!-- begin, end, stop 속성을 가진 forEach -->
		<c:forEach var="i" begin="1" end="10" step="2"> <!-- for(int i=1; i<10; i++) -->
			${i}<br>
		</c:forEach>
		
</body>
</html>