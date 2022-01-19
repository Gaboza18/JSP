<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 정보 입력</title>
<style>

label {
   display: inline-block;
   width: 75px;
}

</style>
</head>
<body>

   <h2>영화 정보 입력</h2>
   
   <form method="post" action="04_MovieWrite.jsp">
   		<label for="title">제목</label>
   			<input type="text" name="title" id="title"><br>
   		<label for="price">가격</label>
   			<input type="text" name="price" id="price">원<br>
   		<label for="director">감독</label>
   			<input type="text" name="director" id="director"><br>
   		<label for="actor">출연배우</label>
   			<input type="text" name="actor" id="actor"><br><br>
   		<label for="synopsis">시놉시스</label>
   			<textarea cols="35" rows="20" name="synopsis" id="synopsis" style="vertical-align:middle" ></textarea><br><br>
   				<label for="">장르</label>
   				  <select name="genre">
      				<option value="로맨스">로맨스</option>
      				<option value="스릴러">스릴러</option>
      				<option value="미스터리">미스터리</option>
      				<option value="액션" selected="selected">액션</option>
      				<option value="코미디">코미디</option>
      				<option value="애니메이션">애니메이션</option>
   				  </select>
   				<br><br>
   
   		<div id="buttons">
      		<input type="submit" value="등록">
      		<input type="reset" value="다시작성">
   		</div>
   		
   </form>
</body>
</html>