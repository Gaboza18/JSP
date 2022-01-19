<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 태그 라이브러리를 사용하기 위한 taglib 지시자 설정 -->	    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<!--
	prefix = "c(기본기능), fmt(형식화), DB(sql), XML 처리(x), 함수처리(fn)" 
 -->
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL 연습</title>
</head>
<body>
	<!-- c= 기본기능(core), out=출력 -->
	<c:out value="Hello World"/>
</body>
</html>