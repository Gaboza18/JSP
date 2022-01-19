<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>formatDate 예제</title>
</head>
<body>

	<c:set var="now" value="<%= new java.util.Date() %>"/> <!-- 현재 날짜를 생성해서 now 에 넣는다 -->
	\${now} : ${now} <br>
	
	<!-- 날짜만 표시 -->
	date : <fmt:formatDate value="${now}" type="date"/><br>
	
	<!-- 시간만 표시 -->
	time : <fmt:formatDate value="${now}" type="time"/><br>
	
	<!-- 날짜 + 시간 표시 -->
	date & time : <fmt:formatDate value="${now}" type="both"/><br> 	
	
	long : <fmt:formatDate value="${now}" type="both" dateStyle="long" timeStyle="long"/><br>
	
	pattern : <fmt:formatDate value="${now}" pattern="yyyy년 MM월 dd일 hh시 mm분 ss초"/> 
	
</body>
</html>