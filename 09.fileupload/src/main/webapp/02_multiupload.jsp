<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>복수개의 파일 업로드</h3>
		<!-- 파일 업로드 시에는 enctype 설정 -->
	<form method="post" action="multi_upload.do" enctype="multipart/form-data">
		1. 파일 지정하기: <input type="file" name="upload01"><br>
		2. 파일 지정하기: <input type="file" name="upload02"><br>
		3. 파일 지정하기: <input type="file" name="upload03"><br>
			<input type="submit" value="전송">
	</form>
	
</body>
</html>