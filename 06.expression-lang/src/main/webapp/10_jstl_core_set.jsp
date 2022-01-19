<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL c:set 태그 연습</title>
</head>
<body>
	
	<!-- 첫번째 설정방법 -->
	<c:set var="msg" value="Hello"/> <!-- var=변수이름 value=값 -->
	\${msg} = ${msg}<br> <!-- 결과 출력 -->
	
	<!-- 두번째 설정방법 -->
	<c:set var="age">23</c:set>	<!-- c:set 태그 안에 변수 선언후 값을 중간에 넣는것도 가능 -->
	\${age} = ${age}<br>
	
	<!-- 자바빈 객체 생성하기 -->
	<c:set var="member" value="<%=new com.green.javabeans.MemberBean()%>" />
	
	<!-- 자바빈 객체에 멤버 값 설정하기 -->
	<c:set target="${member}" property="name" value="홍길순"/>
	<c:set target="${member}" property="userid" value="kshong"/>
	
	\${memeber} = ${member}<br> <!-- 결과 값 출력 -->
	
	<!-- 계산 결과의 저장 -->
	<c:set var="sum" value="${10 + 20}"/>
	\${sum} = ${sum}<br>
	
	<c:set var="flag" value="${10 > 20}"/>
	\${flag} = ${flag}<br>
	
	<!-- 설정된 변수값 제거 -->
	<c:remove var="age"/>
	\${age} = ${age}<br>
	
	
</body>
</html>