<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>useBean 액션태그</title>
</head>
<body>
 	<!-- id= '빈이름', class='패키지명을 포함한 클래스명' -->
	<jsp:useBean id="member" class="com.green.javabeans.MemberBean"></jsp:useBean>
	
	<%
		member.setName("장보고");
		member.setUserid("bkjang");
	%>
		이름: <%= member.getName() %> <br>
		아이디: <%= member.getUserid() %>
</body>
</html>