<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.Calendar" %>  
<%@ page import="java.text.SimpleDateFormat" %>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>현재 시각 출력</title>
</head>
<body>

	<%
	Calendar date = Calendar.getInstance(); // 현재 시각을 얻어옴
	SimpleDateFormat today = new SimpleDateFormat("yyyy년 MM월 dd일");
	SimpleDateFormat now = new SimpleDateFormat("hh시 mm분 ss초"); 
	%>
	
	오늘은 <b>"<%= today.format(date.getTime()) %>"</b> 입니다.<br>
	지금시각은 <b>"<%= now.format(date.getTime()) %>"</b> 입니다.<br>
</body>
</html>