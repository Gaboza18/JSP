<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>firstPage</title>
</head>
<body>
	<%
	
	pageContext.setAttribute("name", "페이지 저장 속성"); // 해당 페이지에서만 유효하다
	request.setAttribute("name", "requset 저장 속성"); // 하나의 요청을 처리할때 사용되는 영역
	session.setAttribute("name", "session 저장 속성"); // 하나의 브라우저와 관련된 영역
	application.setAttribute("name", "application 저장 속성"); // 하나의 웹 어플리케이션과 관련된 영역 
	
	// 데이터가 사라지기 때문에 콘솔창 출력
	System.out.println("firstPage.jsp");
	System.out.println("페이지 영역 데이터: " + pageContext.getAttribute("name"));
	System.out.println("request 영역 데이터: " + request.getAttribute("name"));
	System.out.println("session 영역 데이터: " + session.getAttribute("name"));
	System.out.println("application 영역 데이터: " + application.getAttribute("name"));
	
	// 두번째 페이지로 이동 
	RequestDispatcher rd = request.getRequestDispatcher("05_secondPage.jsp");
	rd.forward(request, response); // 두번째 페이지에 현재 페이지가 갖고있는 request, response 정보를 전달
	
	%>
</body>
</html>