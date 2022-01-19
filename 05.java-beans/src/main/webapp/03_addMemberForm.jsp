<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<style>
label {
   display: inline-block;
   width: 70px;
}
</style>
</head>
<body>
<h2>회원 정보 입력</h2>
<form method="post" action="03_addMember.jsp">

   <label for="">이름</label>
   <input type="text" name="name" size="20"><br>
   <label for="">아이디</label>
   <input type="text" name="userid" size="20"><br>
   <label for="">별명</label>
   <input type="text" name="nickname" size="20"><br>
   <label for="">비밀번호</label>
   <input type="password" name="pwd" size="20"><br>
   <label for="">이메일</label>
   <input type="email" name="email" size="20"><br>
   <label for="">전화번호</label>
   <input type="text" name="phone" size="11"><br><br>
   
   <div>
      <input type="submit" value="전송"> &nbsp; &nbsp;
      <input type="reset" value="취소">
   </div>
</form>
</body>
</html>