<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드 예제</title>
<style>
	label{
		display:inline-block;
		width:75px;
	}
</style>
</head>
<body>
	<form method="post" action="upload.do" enctype="multipart/form-data">
	
		<label for="writer">글쓴이: </label>
		<input type="text" name="writer" id="writer" size="20"><br>
		
		<label for="title">제 &nbsp;목: </label>
		<input type="text" name="title" id="title" size="20"><br><br>
		
		파일 지정하기:
		<input type="file" name="upload_file"><br><br>
		<input type="submit" value="전송">
		
	</form>
</body>
</html>