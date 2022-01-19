<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 정보 입력 폼</title>
</head>
<style>
label {
   display: inline-block;
   width: 75px;
}
</style>
<body>
<h2>사원 정보 입력</h2>

<!-- <form method="post" action="02_addMember.jsp"> -->

<form method="post" action="03_addEmployeesResult.jsp">
   <label>이름</label>
   <input type="text" name="name" size="20"><br>
   <label>주소</label>
   <input type="text" name="address" size="20"><br>
   <label>주민번호</label>
   <input type="text" name="jumin_no1" size="20"> -
   <input type="text" name="jumin_no2" size="20">
   <br><br>
   <div id="buttons">
      <input type="submit" value="전송">
      <input type="reset" value="취소">
   </div>

</form>
</body>
</html>