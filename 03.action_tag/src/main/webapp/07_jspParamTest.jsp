<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.net.URLEncoder" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String userId = request.getParameter("id"); // 아이디 값
		String userPwd = request.getParameter("password"); // 암호 값
		String userType = request.getParameter("user_type"); // 이용자 타입 값
		
		// 로그인시 고객 일경우
		if(userType.equals("user")){
	%>	
			<!-- java 영역이 아니기 떄문에 따로 지정한다 -->
			<jsp:forward page="07_userMain.jsp">
			
				<jsp:param name="user_name" value='<%= URLEncoder.encode("전고객", "UTF-8") %>' ></jsp:param>
				
			</jsp:forward>
			
	<%	
		// 로그인시 관리자 일경우
		}else{
	%>
			<jsp:forward page="07_managerMain.jsp">
			
				<jsp:param name="user_name" value='<%= URLEncoder.encode("김관리", "UTF-8") %>'></jsp:param>
				
		    </jsp:forward>	
	<%					
		}
	
	%>
</body>
</html>