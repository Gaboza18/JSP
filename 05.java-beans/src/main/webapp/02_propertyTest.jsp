<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>get/setProperty 연습</title>
</head>
<body>
		
		<jsp:useBean id="member" class="com.green.javabeans.MemberBean"/>
		
		<h4>자바 빈 객체 생성 후 데이터 출력</h4>
		
		이름: <jsp:getProperty property="name" name="member"/><br>
		아이디: <jsp:getProperty property="userid" name="member"/><br>
		
		<hr>
		
		<h4>데이터 설정 후 데이터 출력</h4>
		
		<jsp:setProperty property="name" name="member" value="장보고"/> <!-- name에 값 저장 -->
		<jsp:setProperty property="userid" name="member" value="bkjang"/> <!-- user_id에 값 저장 -->
		
		이름: <jsp:getProperty property="name" name="member"/><br> <!-- 저장된 정보를 얻어온다  -->
		아이디: <jsp:getProperty property="userid" name="member"/><br> <!-- 저장된 정보를 얻어온다  -->
		
</body>
</html>