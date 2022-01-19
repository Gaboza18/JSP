<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>설문조사 결과</title>
</head>
<body>
	<h2>설문조사 결과</h2>
	<%
		// post 방식의 한글출력하기 위한 요청, 응답 선언
		request.setCharacterEncoding("UTF-8"); 
		response.setContentType("text/html; charset=UTF-8");

		String name = request.getParameter("name");
		out.print("이름: <b>" + name + "</b></br>");
		
		String gender = request.getParameter("gender");
		out.print("성별: <b>" + gender + "</b></br>");
		
		String[] seasons = request.getParameterValues("season"); // 좋아하는 계절값들을 seasons 배열에 담는다
		if(seasons == null){ // 계절값이 아무것도 없을때
			out.print("좋아하는 계절을 선택하지 않았습니다.");
		}else{ // 계절값을 선택했을때
			out.print("당신이 좋아하는 계절: ");
			for(String item : seasons){ // 향상된 for문: 대입받을 변수정의 : 배열명
				switch(item){
					case "1" : out.print("<b>봄 </b>");
						break;
					case "2" : out.print("<b>여름 </b>");
						break;
					case "3" : out.print("<b>가을 </b>");
						break;
					case "4" : out.print("<b>겨울 </b>");
						break;
				}
			}
			out.print(" 입니다.<br>");
		}
	%>
	<a href="javascript:history.go(-1)">뒤로가기</a>
</body>
</html>