<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 선언문</title>
</head>
<body>

<%-- JSP의 선언부 --%>
	<%!
		String str = "안녕하세요";
		int a = 5, b = -5;
		
		public int abs(int n){
			if(n<0){
				n = -n;
			}
			return n;
		}
	%>
	
<%-- JSP의 스크립트 --%>
	<%
	out.print(str + "<br>");
	out.print(a + "의 절대값 = " + abs(a) + "<br>");
	out.print(b + "의 절대값 = " + abs(a) + "<br>");	
	%>
	
</body>
</html>