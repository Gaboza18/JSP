<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript" src="script/jquery-3.6.0.min.js"></script>
	<script>
		if (window.name == 'update') { // 게시글 수정 누른경우
			$(opener.location).attr("href",
					"BoardServlet?command=board_update_form&num=${param.num}"); // 부모창을 연다
		} else if (window.name == 'delete') { // 게시글 삭제 누른경우
			$(opener.location).attr("href",
					"BoardServlet?command=board_delete&num=${param.num}");
		}

		window.close(); // 비밃번호 확인창 닫기
	</script>
</body>
</html>