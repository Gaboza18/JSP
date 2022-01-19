<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
<style>
label {
   display: inline-block;
   width: 70px;
}
#buttons {
width: 250px;
text-align: center;
}
</style>
</head>
<body>
<h3>회원 가입</h3>
'*' 표시 항목은 필수 입력 항목입니다.
<form action="join.do" method="post" name="frm">
   <label>이름</label>
   <input type="text" name="name" id="name" size="20">* <br>
   <label>아이디</label>
    <input type="text" name="userid" id="userid" size="20"  id="userid">* 
   <input type="hidden" name="reid" id="reid" size="20"> 
   <input type="button" value="중복 체크" onclick="return idCheck()"><br>
   <label>암 호</label>
   <input type="password" name="pwd" id="pwd" size="20">* <br>
   <label>암호 확인</label>
   <input type="password" name="pwd_check" id="pwd_check" size="20">* <br>
   <label>이메일</label>
   <input type="email" name="email" size="20"> <br>
   <label>전화번호</label>
   <input type="text" name="phone" size="20"> <br>
   <label>등급</label>
   <input type="radio" name="admin" value="0" checked="checked"> 일반회원 
   <input type="radio" name="admin" value="1"> 관리자 <br><br>
   <div id="buttons">
      <input type="submit" value="확인" onclick="return joinCheck()">
               &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
      <input type="reset" value="취소"><br>
   </div>
   <span>${message}</span>
</form>
<script
  src="https://code.jquery.com/jquery-3.6.0.min.js"
  integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
  crossorigin="anonymous"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/script/member.js"></script>
</body>
</html>