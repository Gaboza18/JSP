<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션 설정하기</title>
</head>
<body>
	<h3>세션에 값 저장하고 읽어오기</h3>
	<%
	session.setAttribute("id", "King");
	session.setAttribute("pwd", "1234");
	session.setAttribute("name", "김춘자");

	String StrId = (String)session.getAttribute("id");
	String StrPwd = (String)session.getAttribute("pwd");
	String StrName = (String)session.getAttribute("name");

	out.print("세션 ID: " + StrId + "<br><br>");
	out.print("세션 pwd: " + StrPwd + "<br><br>");
	out.print("세션 name: " + StrName + "<br><br>");
	%>
</body>
</html>