<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 결과</title>
	<style>
		label{
			display: inline-block;
			width: 70px;
			font-weight:bold;
		}
	</style>
</head>
<body>
	<%
	
		request.setCharacterEncoding("UTF-8"); // 한글작업을 하기위한 선언
	
		/* 자바Bean에서 객체를 얻어온다 */
		String name= request.getParameter("name");
		String userid= request.getParameter("userid");
		String pwd= request.getParameter("pwd");
		String nickname= request.getParameter("nickname");
		String email= request.getParameter("email");
		String phone= request.getParameter("phone");
		
	%>
		<jsp:useBean id="member" class="com.green.javabeans.MemberBean"/>
		
		<!-- 
		
		<jsp:setProperty name="member" property="name" value='<%= name %>'/>
		<jsp:setProperty name="member" property="userid" value='<%= userid %>'/>
		<jsp:setProperty name="member" property="pwd" value='<%= pwd %>'/>
		<jsp:setProperty name="member" property="nickname" value='<%= nickname %>'/>
		<jsp:setProperty name="member" property="email" value='<%= email %>'/>
		<jsp:setProperty name="member" property="phone" value='<%= phone %>'/>
		
		 -->
		<jsp:setProperty property="*" name="member"/> <!-- 여러개의 항목을 중복으로 주지 않고 * 한번만 선언해 실행가능 -->
		 
		<h3>입력 완료된 회원정보</h3>
		<label>이름</label>
		<jsp:getProperty name="member" property="name"/><br>
		<label>아이디</label>
		<jsp:getProperty name="member" property="userid"/><br>
		<label>암 호</label>
		<jsp:getProperty name="member" property="pwd"/><br>
		<label>별 명</label>
		<jsp:getProperty name="member" property="nickname"/><br>
		<label>이메일</label>
		<jsp:getProperty name="member" property="email"/><br>
		<label>전화번호</label>
		<jsp:getProperty name="member" property="phone"/><br>
		
</body>
</html>